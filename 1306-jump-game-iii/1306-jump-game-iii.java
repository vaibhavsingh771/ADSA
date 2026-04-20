class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (arr[curr] == 0) return true;
            
            int forward = curr + arr[curr];
            int backward = curr - arr[curr];
            
            if (forward < n && !visited[forward]) {
                q.add(forward);
                visited[forward] = true;
            }
            
            if (backward >= 0 && !visited[backward]) {
                q.add(backward);
                visited[backward] = true;
            }
        }
        
        return false;
    }
}