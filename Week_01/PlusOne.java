// given a not null array that represent an integer digits, find out the array represent the integer plus one in the same way.
// 1. highest order digit will be the first element in array.
// 2. you can assume no zero element.
public class PlusOne extends BaseRunner {
    
    //#region leet code
    // 1. simply follow without thoughts, what a fucking mess!
    //  - time complexity: O(n),
    //  - space complexity: O(n)
    class Solution implements Tester {
        public int[] plusOne(int[] digits) {
            int num = digits[digits.length - 1], dec = 10;
            for (int i = digits.length - 2; i >= 0 && i < (digits.length - 1); i--) {
                num += digits[i] * dec;
                dec *= 10;
            }
            num += 1;
            int[] digits_new = num / dec == 0 ? new int[digits.length] : new int[digits.length + 1];
            dec = digits_new.length == digits.length + 1 ? dec *= 10 : dec;
            for (int i = 10, j = digits_new.length - 1; i <= dec; i *= 10) {
                digits_new[j--] = (num % i) / (i / 10);
            }
            return digits_new;
        }
    }

    // 2. from the start indedx to find out the digit % 10 != 0, should be 1,000 ... if none. SKILLFUL.
    //  - time complexity: O(n),
    //  - space complexity: O(1)
    class Solution2 implements Tester {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) return digits;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

    //#endregion

    //#region local debugging

    public String getName () { 
        return "PlusOne"; 
    }

    public void run () {
        Tester leetCode = new Solution2();
        leetCode.plusOne(new int[] { 1, 9 });
    }

    interface Tester {
        int[] plusOne(int[] nums);
    }

    //#endregion

}