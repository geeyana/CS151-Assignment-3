public class FactoryChoiceAlgorithm {

    public static ChoiceAlgorithm create(String arg){
        switch (arg){
            case "-m":
                return new MLAlgorithm();
            case "r":
            default:
                return new RandomAlgorithm();
        }
    }
}
