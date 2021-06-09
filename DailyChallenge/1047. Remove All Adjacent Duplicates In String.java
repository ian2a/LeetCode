class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int slow = 0;
        for (int fast = 1; fast < chars.length; fast++) {
            if (slow < 0 || chars[fast] != chars[slow]) {
                chars[++slow] = chars[fast];
            } else {
                slow--;
            }
        }
        return new String(chars, 0, slow + 1);
    }
}
