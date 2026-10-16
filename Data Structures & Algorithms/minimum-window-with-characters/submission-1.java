
class Solution {
    public String minWindow(String s, String t) {
        int[] window = new int[256];
        int[] target = new int[256];

        for (char ch : t.toCharArray()) {
            target[ch]++;
        }

        int left = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right)]++;

            while (contains(window, target)) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    minStart = left;
                }

                window[s.charAt(left)]--;
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }

    private boolean contains(int[] window, int[] target) {
        for (int i = 0; i < 256; i++) {
            if (window[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}