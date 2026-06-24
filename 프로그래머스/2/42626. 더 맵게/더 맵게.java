// 스코빌 배열이 최대 백만이니까 N^2 으로 풀면 ㅈ됨
// 힙으로 풀자
// 힙은 항상 정렬되어 있는 상태

// 뽑은 음식 두개는 소멸 -> 새로 만든 음식 추가
import java.util.*;

class Solution {
    
    private static int k;
    
    public int solution(int[] scoville, int K) {
        
        k = K;
        
        Queue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        
        for(int i = 0 ; i < scoville.length; i++){
            heap.offer(scoville[i]);
        }
        
        while(heap.size() >= 2 && !isAllGreaterThenK(heap)){
            Integer firstFood = heap.poll();
            Integer secondFood = heap.poll();
            
            heap.offer(createNewFood(firstFood, secondFood));
            count++;
        }
       
        if(isAllGreaterThenK(heap)){
            return count;
        }
        
        return -1;
        
    }
    
    private static Integer createNewFood(Integer firstFood, Integer secondFood){
        return firstFood + (secondFood * 2);
    }
    
    private static boolean isAllGreaterThenK(Queue<Integer> tempHeap){
        for(Integer temp : tempHeap){
            if(temp < k){
                return false;
            }
        }
        
        return true;
    }
    
    
}