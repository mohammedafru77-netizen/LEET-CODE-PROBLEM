class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
       
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        
        int dx = x1 - x0;
        int dy = y1 - y0;
        
      
        for (int i = 2; i < coordinates.length; i++) {
            int currX = coordinates[i][0];
            int currY = coordinates[i][1];
            
            if (dy * (currX - x0) != dx * (currY - y0)) {
                return false;
            }
        }
        return true;
    }
}
