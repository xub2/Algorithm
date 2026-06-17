import java.util.*;

class Solution {
    
    private static final int MAX = 200 + 10;
    
    private static boolean[][] graph;
    private static boolean[] visited;
    
    private static void dfs(int idx){
        visited[idx] = true;
        
        for(int i = 0 ; i < graph[idx].length; i++){
            if(!visited[i] && graph[idx][i]){
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0 ; j < computers[i].length; j++){
                if(computers[i][j] == 1){
                    graph[i + 1][j + 1] = true;
                }
            }
        }
        
        int answer = 0;
        
        // 전체에 대해 DFS 수행 
        for(int i = 0 ; i < n ; i++){
            if(!visited[i + 1]){
                dfs(i + 1);
                answer++;
            }
            
        }
        
        return answer;
    }
}