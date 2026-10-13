class Solution {
    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
             // Skip non-alphanumeric characters from the left
            while (start < end &&
                   !Character.isLetterOrDigit(str.charAt(start))) {
                start++;
            }

            // Skip non-alphanumeric characters from the right
            while (start < end &&
                   !Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}