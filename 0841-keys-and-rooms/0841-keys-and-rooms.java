class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, Boolean> visited = new HashMap<>();

        dfs(0, rooms, visited);
        return visited.size() == rooms.size();

    }
    private void dfs (int room, List<List<Integer>> rooms, HashMap<Integer, Boolean> visited ){
        if(visited.containsKey(room)) return;

        visited.put(room, true);

        for(int key : rooms.get(room)){
            dfs(key, rooms, visited);
        }
    }
}

