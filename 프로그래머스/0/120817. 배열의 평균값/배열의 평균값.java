import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double numbersSum = (double)Arrays.stream(numbers).sum();
        return numbersSum / numbers.length;
    }
}