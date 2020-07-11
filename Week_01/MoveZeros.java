//
public class MoveZeros {

    class Solution implements Tester {
        public void moveZeroes(int[] nums) {
    
        }
    }

    public String getName () { 
        return "MoveZeros"; 
    }

    public void run () {
        Tester leetCode = new Solution();
        leetCode.moveZeroes(new int[] {  });
    }

    interface Tester {
        void moveZeroes(int[] nums);
    }
}