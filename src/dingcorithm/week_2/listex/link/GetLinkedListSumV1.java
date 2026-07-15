package dingcorithm.week_2.listex.link;

import java.util.LinkedList;
import java.util.List;

public class GetLinkedListSumV1 {

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(6);
        list1.add(7);
        list1.add(8);

        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(5);
        list2.add(4);

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            sb1.append(list1.get(i));
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < list2.size(); i++) {
            sb2.append(list2.get(i));
        }

        int list1ToNum = Integer.parseInt(sb1.toString());
        System.out.println(list1ToNum);
        int list2ToNum = Integer.parseInt(sb2.toString());
        System.out.println(list2ToNum);

        System.out.println(list1ToNum + list2ToNum);


    }
}
