class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }
        int result = 0;
        while (index < n) {
            char curr = s.charAt(index);
            
            if (curr < '0' || curr > '9') {
                break;
            }

            int digit = curr - '0';

           
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
