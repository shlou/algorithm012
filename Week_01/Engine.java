import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// just for local degbugging to see what happened there.
public class Engine {
    public static void main (String[] args) {
        
        // To do: How to use DEQUE properly?
        Deque<CodeRunner> runners = createInstances(new LinkedList<String>(Arrays.asList(args)));

        while (runners.size() > 0) {
            CodeRunner runner = runners.poll();
            System.out.println(runner.getName() + ", time elapse in ms: " + runner.diagnose());
        }

    }

    private static Deque<CodeRunner> createInstances (Deque<String> names) {

        Deque<CodeRunner> runners = new LinkedList<>();
        while (names.size() > 0) {
            switch (names.poll()) {
                case "TestDeque":
                    runners.add(new TestDeque());
                    break;
                case "RemoveDuplicates":
                    runners.add(new RemoveDuplicates());
                    break;
                case "Rotate":
                    runners.add(new Rotate());
                    break;
                case "MergeTwoLists":
                    runners.add(new MergeTwoLists());
                    break;
                case "MergeTwoArrays":
                    runners.add(new MergeTwoArrays());
                    break;
                case "TwoSum":
                    runners.add(new TwoSum());
                    break;
                case "MoveZeros":
                    runners.add(new MoveZeros());
                    break;
                case "PlusOne":
                    runners.add(new PlusOne());
                    break;
                case "TestMyCircularDeque":
                    runners.add(new TestMyCircularDeque());
                    break;
                case "Trap":
                    runners.add(new Trap());
                    break;
                case "MaxSubArray":
                    runners.add(new MaxSubArray());
                    break;
                default:
                    break;
            }
        }

        return runners;
    }
}