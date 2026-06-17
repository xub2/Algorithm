import java.util.*;

class Solution {
    
    private static final int MAX = 100 + 10;
    
    private static boolean[][] graph;
    private static boolean[][] visited;
    
    private static int[][] dist;
    
    // 상 하 좌 우
    private static int[] dirY = {-1, 1, 0, 0};
    private static int[] dirX = {0, 0, -1, 1};
    
    private static Deque<int[]> queue;
    
    private static int bfs(int[] idx, int[] end){
        dist = new int[MAX][MAX];
        queue = new ArrayDeque<>();
        queue.offer(idx);
        
        visited[idx[0]][idx[1]] = true;
        dist[idx[0]][idx[1]] = 1;
        
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            
            for(int i = 0 ; i < 4; i++){
                int nextY = next[0] + dirY[i];
                int nextX = next[1] + dirX[i];
                
                if(!visited[nextY][nextX] && graph[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    dist[nextY][nextX] = dist[next[0]][next[1]] + 1;
                    
                    if(nextY == end[0] && nextX == end[1]){
                        return dist[nextY][nextX];
                    }
                    
                    queue.offer(new int[] {nextY, nextX});
                }

            }
        }
        
        // 방문 다 하고 마지막 종점 visited = false 면 return -1;
        if(!visited[end[0]][end[1]]){
            return -1;
        }
        
        return dist[end[0]][end[1]];
    }
    
    public int solution(int[][] maps) {
        
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];
        
        for(int i = 0 ; i < maps.length; i++){
            for(int j = 0; j < maps[i].length; j++){
                
                // 0이면 벽 1이면 길
                if(maps[i][j] == 1){
                    graph[i + 1][j + 1] = true;
                }
            }
        }
        
        return bfs(new int[]{1,1}, new int[]{maps.length, maps[0].length});
    }
}