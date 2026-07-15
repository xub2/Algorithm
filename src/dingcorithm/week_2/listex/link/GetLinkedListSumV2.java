package dingcorithm.week_2.listex.link;

import java.util.LinkedList;
import java.util.List;

public class GetLinkedListSumV2 {

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(6);
        list1.add(7);
        list1.add(8);

        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(5);
        list2.add(4);

        int sum1 = getSingleLinkedListSum(list1);
        int sum2 = getSingleLinkedListSum(list2);

        System.out.println(sum1 + sum2);
    }

    private static int getSingleLinkedListSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum = sum * 10 + i;
        }

        return sum;
    }
}
