public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        return match(pattern, str, map, used);
    }

    private boolean match(String pattern, String str, Map<Character, String> map, Set<String> used) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char ch = pattern.charAt(0);
        if (map.containsKey(ch)) {
            String word = map.get(ch);
            if (!str.startsWith(word)) {
                return false;
            }
            return match(pattern.substring(1), str.substring(word.length()), map, used);
        }

        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (used.contains(word)) {
                continue;
            }
            map.put(ch, word);
            used.add(word);

            if (match(pattern.substring(1), str.substring(word.length()), map, used)) {
                return true;
            }

            map.remove(ch);
            used.remove(word);
        }
        return false;
    }
}
