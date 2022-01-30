class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<int[]>>map=new HashMap<>();
        for(int i=0;i<edges.length;++i){
            int u=edges[i][0],v=edges[i][1];
            map.computeIfAbsent(u,x->new ArrayList<>()).add(new int[]{v,i});
            map.computeIfAbsent(v,x->new ArrayList<>()).add(new int[]{u,i});
        }
        Queue<Integer>queue=new LinkedList<>();
        double[] p=new double[n];
        p[start]=1.0;
        queue.add(start);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int[] a:map.getOrDefault(curr,Collections.emptyList())){
                int neigh=a[0],index=a[1];
                if(p[curr]*succProb[index]>p[neigh]){
                    p[neigh]=p[curr]*succProb[index];
                    queue.add(neigh);
                }
            }
        }
        return p[end];
    }
}