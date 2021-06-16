class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> matches = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return matches;
        }
        
        // Build char count map
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int toMatch = charCount.size();
        
        // Loop string s
        for (int i = 0; i < s.length(); i++) {
            char newChar = s.charAt(i);
            Integer newFreq = charCount.get(newChar);
            if (newFreq != null) {
                charCount.put(newChar, --newFreq);
                if (newFreq == 0) {
                    toMatch--;
                }
            }
            
            // Move the left of window
            if (i >= p.length()) {
                char oldChar = s.charAt(i - p.length());
                Integer oldFreq = charCount.get(oldChar);
                if (oldFreq != null) {
                    charCount.put(oldChar, ++oldFreq);
                    if (oldFreq == 1) {
                        toMatch++;
                    }
                }
            }
            if (toMatch == 0) {
                matches.add(i - p.length() + 1);
            }
        }
        
        return matches;
    }
}
