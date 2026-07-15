package dingcorithm.week_4.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    List<Integer> items;

    public MaxHeap() {
        this.items = new ArrayList<>();
        this.items.add(null); // 이진트리를 쉽게 쓰기 위해 0번째 인덱스 사용 X -> null 삽입
    }

    public void insert(int value) {
        // 먼저 원소를 제일 뒤에 추가
        items.add(value);
        // 본인의 현재 인덱스 기록
        int currentIndex = this.items.size() - 1;

        // 추가한 값이 자신의 부모노드보다 클 때 부모노드와 자신의 위치를 swap
        while (currentIndex != 1) { // 첫번째 탈출 조건은 삽입한 노드가 루트 노드가 되면 종료

            int parentIndex = currentIndex / 2;

            /**
             * 자식 <-> 부모노드 구하는 공식
             * 부모의 왼쪽 자식 노드 구하기 : 현재 Index * 2
             * 부모의 오른쪽 자식 노드 구하기 : 현재 Index * 2 + 1
             * 자식의 부모 노드 구하기 : 현재 Index / 2 (나머지 버림)
             */

            // 부모 노드와 비교 -> 부모보다 크다면 swap
            if (this.items.get(currentIndex) > this.items.get(parentIndex)) {
                int temp = this.items.get(currentIndex);
                this.items.set(currentIndex, this.items.get(parentIndex));
                this.items.set(parentIndex, temp);

                currentIndex = parentIndex; // swap 하게 되면 현재 추가한 원소가 부모 노드가 된다
            } else { // 만약 위 조건이 아니라면? -> 이미 부모 노드가 자식 노드보다 큰 상태
                break;
            }
        }
    }

    // max value 제거
    // 기존 루트노드 삭제 -> 이후 아래로 내려가면서 부모와 자식 노드 비교
    // 원소 제거 로직의 탈출 조건은 부모 노드 값이 자식노드 두개보다 반드시 커야함 && size-1 도달시 탈출
    public int delete() {

        // 1. 먼저 마지막 노드와 루트노드 교체
        int temp = this.items.get(1);
        this.items.set(1, this.items.get(this.items.size() - 1));
        this.items.set(this.items.size() - 1, temp);
        // 여기까지 오면 현재 노드 순서 바뀜

        // 2. 마지막 노드(루트 노드였던 것) 삭제 (나중에 반환해야 함)
        int prevMax = this.items.remove(this.items.size() - 1);
        int currentIndex = 1; // 비교 시작 지점 (루트 노드)

        while (currentIndex <= this.items.size() - 1) {

            /**
             * 자식 <-> 부모노드 구하는 공식
             * 부모의 왼쪽 자식 노드 구하기 : 현재 Index * 2
             * 부모의 오른쪽 자식 노드 구하기 : 현재 Index * 2 + 1
             * 자식의 부모 노드 구하기 : 현재 Index / 2 (나머지 버림)
             */

            int leftChildIndex = currentIndex * 2;
            int rightChildIndex = currentIndex * 2 + 1;
            int maxIndex = currentIndex; // 지금 부모 노드가 가장 크다고 가정

            // 만약 좌측 자식 노드의 인덱스가 마지막이 아니고 , 좌측 자식 노드의 현재 값이 부모보다 크다면?
            if (leftChildIndex <= this.items.size() - 1
                    && this.items.get(leftChildIndex) > this.items.get(maxIndex)) {
                maxIndex = leftChildIndex; // 좌측 자식 노드가 크다고 업데이트
            }

            // 만약 우측 자식 노드의 인덱스가 마지막이 아니고 , 좌측 자식 노드의 현재 값이 부모보다 크다면?
            if (rightChildIndex <= this.items.size() - 1
                    && this.items.get(rightChildIndex) > this.items.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == currentIndex) {
                break;
            }
            // 여기 조건문까지 끝나면 부모 - 좌측 자식 - 우측 자식 노드중 가장 큰 값이 나옴

            // 현재 부모 노드와 maxIndex의 값을 swap
            temp = this.items.get(currentIndex); // 기존 부모 노드 값
            this.items.set(currentIndex, this.items.get(maxIndex)); // 부모 노드의 값을 부모 - 좌측 자식 - 우측 자식 노드 중 현재 max인 인덱스 값으로 변경
            this.items.set(maxIndex, temp); // 그리고 원래 부모의 값을 자식의 자리로 옮김

            // 여기서 끝나면 안되고, 현재 인덱스에 최근까지 수정한 자식 노드의 인덱스를 넣어줘야 추가로 탐색 가능
            currentIndex = maxIndex;

        }

        return prevMax;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        System.out.println(maxHeap.items); // [null, 8, 6, 7, 2, 5, 4]
        System.out.println(maxHeap.delete()); // 8 을 반환해야 합니다!
        System.out.println(maxHeap.items); // [null, 7, 6, 4, 2, 5]
    }
}

