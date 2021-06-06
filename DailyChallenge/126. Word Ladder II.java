class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // String and its neighbors map
        Map<String, List<String>> map = new HashMap<>();
        // Distance to the end map
        Map<String, Integer> distance = new HashMap<>();
        
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.add(beginWord);
        
        bfs(endWord, beginWord, map, distance, dict);
        dfs(beginWord, endWord, map, distance, res, new ArrayList<String>());
        
        return res;
    }
    
    private void dfs(String start,
                     String end,
                     Map<String,
                     List<String>> map,
                     Map<String, Integer> distance,
                     List<List<String>> res,
                     List<String> path) {
        path.add(start);
        if (start.equals(end)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String next : map.get(start)) {
                if (distance.containsKey(next) && distance.get(start) == distance.get(next) + 1) {
                    dfs(next, end, map, distance, res, path);
                }
            }
        }
        path.remove(path.size() -1);
    }
    
    private void bfs(String start,
                     String end,
                     Map<String,
                     List<String>> map,
                     Map<String, Integer> distance,
                     Set<String> dict) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(start);
        distance.put(start, 0);
        
        for (String word : dict) {
            map.put(word, new ArrayList<>());
        }
        
        while (!queue.isEmpty()) {
            String cur = queue.pollFirst();
            for (String next : getNextWords(cur, dict)) {
                map.get(next).add(cur);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(cur) + 1);
                    queue.offerLast(next);
                }
            }
        }
    }
    
    private List<String> getNextWords(String str, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) {
                    continue;
                }
                chars[i] = c;
                String newWord = new String(chars);
                if (dict.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
            chars[i] = oldChar;
        }
        
        return nextWords;
    }
}
