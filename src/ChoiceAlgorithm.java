public interface ChoiceAlgorithm {
    Choice makeChoice();
    void recordResult(Choice computerChoice, Choice humanChoice);
    void saveData();
}
