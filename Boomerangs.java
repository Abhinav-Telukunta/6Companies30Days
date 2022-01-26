class Solution {
    public int numberOfBoomerangs(int[][] points) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<points.length; i++) {
        for(int j=0; j<points.length; j++) {
            if(i == j)
                continue;
            int d = getDistance(points[i], points[j]);                
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        for(int val : map.values()) {
            res += val*(val-1);
        }            
        map.clear();
    }
    
    return res;
    }
    public int getDistance(int[] x,int[] y){
        int xdist=x[0]-y[0];
        int ydist=x[1]-y[1];
        return xdist*xdist+ydist*ydist;
    }
}