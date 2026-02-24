class Solution {

    public int findCheapestPrice(int n, int[][] flights,int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, src, 0});

        int[] stopsUsed = new int[n];
        Arrays.fill(stopsUsed, Integer.MAX_VALUE);

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if(node == dst) return cost;

            if(stops > k) continue;

            if(stops > stopsUsed[node]) continue;
            stopsUsed[node] = stops;

            for(int[] neighbor : adj.get(node)) {
                pq.offer(new int[]{
                    cost + neighbor[1],
                    neighbor[0],
                    stops + 1
                });
            }
        }

        return -1;
    }
}