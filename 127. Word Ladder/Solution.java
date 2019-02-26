class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        HashMap<String, Integer> pathCnt = new HashMap<>();
        pathCnt.put(beginWord, 1);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            String word = q.poll();
            for(int i=0; i<word.length(); i++) {
                String newWord = word;
                for(char ch='a'; ch<='z'; ch++) {
                    char[] wordCharArray = newWord.toCharArray();
                    wordCharArray[i] = ch;
                    newWord = String.valueOf(wordCharArray);
                    if(wordSet.contains(newWord) && newWord.equals(endWord)) return pathCnt.get(word)+1;
                    if(wordSet.contains(newWord) && !pathCnt.containsKey(newWord)) {
                        q.add(newWord);
                        pathCnt.put(newWord, pathCnt.get(word)+1);
                    }
                }
            }
        }
        return 0;
    }
}