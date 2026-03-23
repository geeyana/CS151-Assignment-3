public class FactoryChoiceAlgorithm {

    public static ChoiceAlgorithm create(String arg) {
        switch (arg) {
            case "2":
                return new MLAlgorithm();
            case "1":
            default:
                return new RandomAlgorithm();
        }
    }
}
