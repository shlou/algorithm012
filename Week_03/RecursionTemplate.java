public class RecursionTemplate implements Debugger {
    
    public void run () {
        recurse(0, 10, "beign - ");
    }

    private void recurse (int level, int max, String s) {

        // recursion teminator

        if (level > max)
            return;

        // process logic in current level

        String s1 = " " + s + "level - " + level;
        System.out.println(s1);

        // drill down

        recurse(level + 1, max, s1);

        // reverse current level status if needed

    }

}