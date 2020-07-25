

public class Runner {

    public static void main(String[] args) {
        Debugger debugger = GetLeetCode(args[0]);
        debugger.run();
    }
    
    static Debugger GetLeetCode (String name) {

        switch (name) {
            case "RecursionTemplate":
                return new RecursionTemplate();
            case "ClimbStairs":
                return new ClimbStairs();
            case "GenerateParenthesis":
                return new GenerateParenthesis();
            default:
                return null;
        }

    }
}