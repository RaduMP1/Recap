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

    public static int findMissingNumber(int[] arr, int maxNumber){
        int[] f = new int[maxNumber+1];       // definim vectorul f (un array f cu dimensiunea maxNumber+1)
        for (int i = 0; i < f.length; i++) {  // initializam vectorul f, ca fiecare element al lui sa fie egal cu zerp
            f[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            f[arr[i]]++; //frecventa fiecarui element arr[i] in f
        }
        for (int i = 1; i < f.length; i++) {
            if (f[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static int findMissingNumberUsingSum(int[] arr, int maxNumber){
        int sum = 0;
        // [1,2,3,4,5] => 1+2+3+4+5 = 15
        //suma = n(n+1)/2 = 5(5+1)/2 = 15
        int expectedSum = maxNumber*(maxNumber+1)/2;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return expectedSum-sum;
    }
}
