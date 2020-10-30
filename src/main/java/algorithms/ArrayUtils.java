package algorithms;

public class ArrayUtils {

    public static boolean isPalindrome(int[] n){
        boolean isPalindrome = false;
        // palindrom: int[] n = { 1, 2, 5, 5, 2, 1 }
        // i: n[0], n[1], n[2], n[3], n[4], n[5]
        // j: n[5], n[4], n[3], n[2], n[1], n[0]
        // i: 0, 1, 2
        // j: 2, 1, 0
        for (int i=0, j=n.length-1; i <= j ; i++, j--) {
            if (n[i] != n[j]){
                isPalindrome = false;
                break;
            } else {
                isPalindrome = true;
            }
        }
        return isPalindrome;
    }
}
