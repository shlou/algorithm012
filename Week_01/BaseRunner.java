public class BaseRunner implements CodeRunner {
    
    public String getName () { 
        return "BaseRunner"; 
    }

    public long diagnose () {

        long start = System.currentTimeMillis();
        run();
        long end = System.currentTimeMillis(); 
        return start - end;

    }

    public void run () { System.out.println("THIS ONE SHOULD BE OVERRIDDEN."); }

}