public class Engine {
    public static void main (String[] args) {

        if (args.length == 0) {
            return;
        }

        Testable testable = getTestRunner(args[0]);

        if (testable != null)
            testable.run();

    }

    private static Testable getTestRunner (String leetCode) {

        switch (leetCode) {
            case "IsAnagram":
                return new IsAnagram();
            case "TwoSum":
                return new TwoSum();
            case "NaryTreePreorder":
                return new NaryTreePreorder();
            case "HeapSort":
                return new HeapSort();
            case "GroupAnagrams":
                return new GroupAnagrams();
            case "InorderTraversal":
                return new InorderTraversal();
            case "PreorderTraversal":
                return new PreorderTraversal();
            case "Levelorder":
                return new Levelorder();
            case "NthUglyNumber":
                return new NthUglyNumber();
            case "TopKFrequent":
                return new TopKFrequent();
            default:
                return null;
        }

    }
}