package dingcorithm.week_3.sort;

import java.util.Arrays;

public class SelectionSortV2 {

    public static void main(String[] args) {

        int[] arrayToSelectionSort = {4, 6, 2, 9, 1};

        System.out.println(Arrays.toString(selectionSort(arrayToSelectionSort)));
    }

    private static int[] selectionSort(int[] array) {
        // 제일 앞 원소를 나머지 4개와 비교
        for (int i = 0; i < array.length - 1; i++) { // 끝까지 탐색하긴 할건데..
            int minimumNumberIndexMemo = i; // 일단 array[0]이 가장 작다고 가정

            /**
             * i = 0
             * {4, 6, 2, 9, 1}
             *
             * 5 - 0 = 5
             * array[0+0] 4 < 4 == false
             * array[0+1] 6 < 4 == false
             *
             * array[0+2] 2 < 4 == true
             * minimumNumberIndexMemo = 0 + 2 = 2
             *
             * array[0+3] 9 < 4 == false
             *
             * array[0+4] 1 < 4 == true
             * minimumNumberIndexMemo = 0 + 4 = 4
             */

            /**
             * i = 1
             * {1, 6, 2, 9, 4}
             * int minimumNumberIndexMemo = 1
             *
             * array[1+0] 6 < array[1] 6 == false
             *
             * array[1+1] 2 < array[1] 6 == true
             * minimumNumberIndexMemo = 1 + 1 = 2
             *
             * array[1+2] 9 < array[1] 6 == false
             * array[1+3] 4 < array[2] 2 == false
             *
             * minimumNumberIndexMemo = 2
             */

            for (int j = 0; j < array.length - i; j++) {
                if (array[i + j] < array[minimumNumberIndexMemo]) {
                    minimumNumberIndexMemo = i + j;
                }

            }

            /**
             * temp == array[0] == 4
             * array[0] = array[4] == 1
             * array[4] = temp(4)
             */

            /**
             * temp = array[1] == 6
             * array[1] = array[2] == 2
             * array[2] = temp(6)
             */

            int temp = array[i];
            array[i] = array[minimumNumberIndexMemo];
            array[minimumNumberIndexMemo] = temp;

        }

        return array;
    }


}
