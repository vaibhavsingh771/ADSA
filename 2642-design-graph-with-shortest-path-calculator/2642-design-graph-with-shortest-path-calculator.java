class Graph {

    private List<List<int[]>> adj;
    private int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, node1});
        dist[node1] = 0;

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            if(node == node2) return currDist;

            if(currDist > dist[node]) continue;

            for(int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if(currDist + weight < dist[nextNode]) {
                    dist[nextNode] = currDist + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        return -1;
    }
}