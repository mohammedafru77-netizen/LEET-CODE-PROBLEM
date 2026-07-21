class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }

        if (count == n || count == 0) {
            return true;
        }
        
        return count == 1 && Character.isUpperCase(word.charAt(0));
    }
}
