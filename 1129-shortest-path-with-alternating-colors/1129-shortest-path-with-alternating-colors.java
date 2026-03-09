import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];

        for(int i=0;i<n;i++){
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }

        for(int[] e: redEdges) red[e[0]].add(e[1]);
        for(int[] e: blueEdges) blue[e[0]].add(e[1]);

        int[][] dist = new int[n][2];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0}); 
        q.offer(new int[]{0,1});

        dist[0][0] = dist[0][1] = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];

            if(color == 0){
                for(int next : blue[node]){
                    if(dist[next][1] == Integer.MAX_VALUE){
                        dist[next][1] = dist[node][0] + 1;
                        q.offer(new int[]{next,1});
                    }
                }
            } 
            else{
                for(int next : red[node]){
                    if(dist[next][0] == Integer.MAX_VALUE){
                        dist[next][0] = dist[node][1] + 1;
                        q.offer(new int[]{next,0});
                    }
                }
            }
        }

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int d = Math.min(dist[i][0], dist[i][1]);
            ans[i] = (d == Integer.MAX_VALUE) ? -1 : d;
        }

        return ans;
    }
}