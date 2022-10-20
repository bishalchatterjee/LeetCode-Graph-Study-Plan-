import java.util.*;

public class LeetCode126 {
    //126. Word Ladder II

    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> qu = new LinkedList<>();
        Set<String> st = new HashSet<>(wordList);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        qu.offer(list);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        List<List<String>> ans = new ArrayList<>();
        int level = 0;

        while (!qu.isEmpty()) {
            List<String> currList = qu.peek();
            qu.remove();

            //erase all words that has been used in the previous level to transform
            if (currList.size() > level) {
                level++;
                for (String s : usedOnLevel)
                    st.remove(s);
            }
            String currWord = currList.get(currList.size() - 1);
            if (currWord.equals(endWord)) {
                if (ans.size() == 0)
                    ans.add(currList);
                else if (ans.get(0).size() == currList.size())
                    ans.add(currList);
            }

                for (int i = 0; i < currWord.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] replacedCharArray = currWord.toCharArray();
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);

                        //if the word already exits in the set then remove it
                        if (st.contains(replacedWord)) {
                            currList.add(replacedWord);
                            List<String> temp=new ArrayList<>(currList);
                            qu.add(temp);

                            //mark as visited on the level
                            usedOnLevel.add(replacedWord);
                            currList.remove(currList.size() - 1);
                        }
                    }
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));

        System.out.println(findLadders(beginWord,endWord,wordList));
    }
}