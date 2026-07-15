package dingcorithm.week_2.homework;

import java.util.Arrays;
import java.util.HashSet;

public class DeliveryAvailable {

    public static void main(String[] args) {
        String[] shopMenus = {"만두", "떡볶이", "오뎅", "사이다", "콜라"};
        String[] shopOrders = {"오뎅", "콜라", "만두"};

//        boolean isAvailableToOrder = isAvailableToOrderBinarySearch(shopMenus, shopOrders);
//        System.out.println(isAvailableToOrder);

        System.out.println(isAvailableToOrderSet(shopMenus, shopOrders));
    }

    private static boolean isAvailableToOrderBinarySearch(String[] shopMenus, String[] shopOrders) {

        Arrays.sort(shopMenus);
        Arrays.sort(shopOrders);


        int orderListLengthMin = 0;
        int orderListLengthMax = shopOrders.length - 1;
        int currentMiddle = (orderListLengthMax - orderListLengthMin) / 2;

        for (int i = 0; i < shopOrders.length; i++) {
            String targetOrderToCheck = shopOrders[i];

            // 사전상 뒤로 갈수록 문자열은 크다고 본다 compareTo() 함수 쓰자
            for (int j = 0; j < shopMenus.length; j++) {
                if (targetOrderToCheck.equals(shopMenus[currentMiddle])) {
                    return true;
                } else if ((targetOrderToCheck.compareTo(shopMenus[currentMiddle]) < 0)) {
                    orderListLengthMin = currentMiddle + 1;

                } else {
                    orderListLengthMax = currentMiddle - 1;
                }

                currentMiddle = (orderListLengthMax + orderListLengthMin) / 2;
            }
        }

        return false;
    }

    private static boolean isAvailableToOrderSet(String[] shopMenus, String[] shopOrders) {
        HashSet<String> menuSet = new HashSet<>();

        for (String menu : shopMenus) {
            menuSet.add(menu);
        }

        for (String order : shopOrders) {
            if (!menuSet.contains(order)) {
                return false;
            }
        }

        return true;
    }

}
