package BookSolution.recommend.array;

import java.util.*;
public class Recommend1 {

    public double solution(int[] numbers) {
        double numbersSum = (double)Arrays.stream(numbers).sum();

        return numbersSum / numbers.length;
    }

    public static void main(String[] args) {
        Recommend1 recommend1 = new Recommend1();
        System.out.println(recommend1.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(recommend1.solution(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}));

    }
}
