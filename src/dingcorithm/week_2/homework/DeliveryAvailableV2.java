package dingcorithm.week_2.homework;

import java.util.HashSet;
import java.util.Set;

public class DeliveryAvailableV2 {

    public static void main(String[] args) {
        String[] shopMenus = {"만두", "떡볶이", "오뎅", "사이다", "콜라"};
        String[] orders = {"오뎅", "콜라", "만두", "사이다"};

        System.out.println(isAvailableToOrder(shopMenus, orders));
    }

    private static boolean isAvailableToOrder(String[] shopMenus, String[] orders) {

        Set<String> availableMenus = new HashSet<>();
        for (String shopMenu : shopMenus) {
            availableMenus.add(shopMenu);
        }

        for (String order : orders) {
            if (!availableMenus.contains(order)) {
                return false;
            }
        }

        return true;
    }
}
