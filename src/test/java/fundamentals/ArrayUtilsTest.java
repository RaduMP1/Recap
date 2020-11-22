package fundamentals;

import algorithms.ArrayUtils;
import algorithms.StringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArrayUtilsTest {

    @BeforeAll
    public static void setUp() {
        System.out.println("before all tests");
    }

    @Test
    public void isPalindromeTest(){
        //given
        int[] e1 = { 1, 2, 5, 5, 2, 1};
        int[] e2 = { 2, 1, 1, 3, 2, 1};
        int[] e3 = { 1, 3, 5, 3, 1};
        int[] e4 = { 4, 8, 7};
        int[] e5 = { 10, 20, 20, 30, 40, 50, 50};
        //when
        boolean testResultE1 = ArrayUtils.isPalindrome(e1);
        //then
        Assertions.assertTrue(testResultE1);
        Assertions.assertFalse(ArrayUtils.isPalindrome(e2));
        Assertions.assertTrue(ArrayUtils.isPalindrome(e3));
        Assertions.assertFalse(ArrayUtils.isPalindrome(e4));
        Assertions.assertFalse(ArrayUtils.isPalindrome(e5));
    }

    @Test
    public void findMissingNumberTest() {
        //given
        int[] a1 = {1,2,4,5};
        // [1,2,3,4,5] => 1+2+3+4+5 = 15
        //suma = n(n+1)/2 = 5(5+1)/2 = 15
        int maxNumber = 5;
        //when
        int result = ArrayUtils.findMissingNumber(a1, 5);
        int resultUsingSum = ArrayUtils.findMissingNumberUsingSum(a1, 5);
        //then
        Assertions.assertEquals(3, result);
        Assertions.assertEquals(3, resultUsingSum);
    }


    @AfterAll
    public static void tearDown() {
        System.out.println("after all tests");
    }

}
