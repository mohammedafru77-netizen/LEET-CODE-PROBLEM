class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];
         
        for (char c : jewels.toCharArray()) {
            isJewel[c] = true;
        }
        
        int count = 0;
      
        for (char c : stones.toCharArray()) {
            if (isJewel[c]) {
                count++;
            }
        }
        
        return count;
    }
}
