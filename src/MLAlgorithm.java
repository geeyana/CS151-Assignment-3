import java.io.*;
import java.util.*;

public class MLAlgorithm implements ChoiceAlgorithm {

    private static final int N = 5;
    private static final String FILE_NAME = "ml_data.txt";

    // key = last N-1 human moves
    // value = counts of next human move [rock, paper, scissors]
    private Map<String, int[]> patternMap;

    private LinkedList<Character> history;
    private Random random;

    public MLAlgorithm() {
        patternMap = new HashMap<>();
        history = new LinkedList<>();
        random = new Random();
        loadData();
    }

    @Override
    public Choice makeChoice() {
        if (history.size() < N - 1) {
            return getRandomChoice();
        }

        String key = buildKey();
        int[] counts = patternMap.get(key);

        if (counts == null) {
            return getRandomChoice();
        }

        int predictedIndex = getMaxIndex(counts);
        Choice predictedHuman = indexToChoice(predictedIndex);

        return getWinningMove(predictedHuman);
    }

    @Override
    public void recordResult(Choice computerChoice, Choice humanChoice) {
        if (history.size() == N - 1) {
            String key = buildKey();

            patternMap.putIfAbsent(key, new int[3]);
            patternMap.get(key)[choiceToIndex(humanChoice)]++;

            history.removeFirst();
        }

        history.add(choiceToChar(humanChoice));
    }

    @Override
    public void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, int[]> entry : patternMap.entrySet()) {
                int[] counts = entry.getValue();
                writer.println(entry.getKey() + ":" +
                        counts[0] + "," + counts[1] + "," + counts[2]);
            }
        } catch (IOException e) {
            System.out.println("Error saving ML data: " + e.getMessage());
        }
    }

    private void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(":");
                if (parts.length != 2) {
                    continue;
                }

                String key = parts[0];
                String[] nums = parts[1].split(",");
                if (nums.length != 3) {
                    continue;
                }

                int[] counts = new int[3];
                counts[0] = Integer.parseInt(nums[0]);
                counts[1] = Integer.parseInt(nums[1]);
                counts[2] = Integer.parseInt(nums[2]);

                patternMap.put(key, counts);
            }
        } catch (IOException e) {
            System.out.println("Error loading ML data: " + e.getMessage());
        }
    }

    private String buildKey() {
        StringBuilder sb = new StringBuilder();
        for (char c : history) {
            sb.append(c);
        }
        return sb.toString();
    }

    private Choice getRandomChoice() {
        int num = random.nextInt(3);
        return indexToChoice(num);
    }

    private int getMaxIndex(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    private int choiceToIndex(Choice c) {
        if (c == Choice.ROCK) return 0;
        if (c == Choice.PAPER) return 1;
        return 2;
    }

    private Choice indexToChoice(int i) {
        if (i == 0) return Choice.ROCK;
        if (i == 1) return Choice.PAPER;
        return Choice.SCISSORS;
    }

    private char choiceToChar(Choice c) {
        if (c == Choice.ROCK) return 'R';
        if (c == Choice.PAPER) return 'P';
        return 'S';
    }

    private Choice getWinningMove(Choice humanMove) {
        if (humanMove == Choice.ROCK) return Choice.PAPER;
        if (humanMove == Choice.PAPER) return Choice.SCISSORS;
        return Choice.ROCK;
    }
}
