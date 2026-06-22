import java.util.*;

class Solution {
    
    private static final int MAX = 20000 + 10;
    
    private static List<Integer>[] graph;
    private static boolean[] visited;
    
    private static int[] bfs(int n){
        int[] distArr = new int[n + 1];
        boolean[] visited = new boolean[MAX];
        visited[1] = true;
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        
        while(!queue.isEmpty()){
            int polled = queue.poll();
            
            for(int i = 0 ; i < graph[polled].size(); i++){
                int next = graph[polled].get(i);
                
                if(!visited[next]){
                    visited[next] = true;
                    distArr[next] = distArr[polled] +1;
                    queue.offer(next);
                }
            }
        }
        
        return distArr;
    }
    
    public int solution(int n, int[][] vertex) {
        
        graph = new ArrayList[MAX];
        
        for(int i = 0 ; i < MAX; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] v : vertex){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        
        int[] distArr = bfs(n);
        
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distArr[i]);
        }
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (distArr[i] == maxDistance) {
                result++;
            }
        }
        
        return result;
    }
}