import java.util.*;

class Pair{
    String first; //word
    int second;  //step

    Pair(String first, int second){
        this.first=first;
        this.second=second;
    }
}
public class LeetCode127 {
    //127. Word Ladder

    static int wordLadderShortestTransformationSequence(String beginWord, String endWord, List<String> wordList){
        Queue<Pair> qu=new LinkedList<>();
        qu.offer(new Pair(beginWord,1));

        Set<String> st=new HashSet<>(wordList);  //same as adding each element from wordList into set using foreach loop
        st.remove(beginWord);

        while(!qu.isEmpty()){
            String currWord=qu.peek().first;
            int step=qu.peek().second;
            qu.remove();

            if(currWord.equals(endWord)) return step;

            for (int i = 0; i < currWord.length() ; i++) {
                for (char ch = 'a'; ch <= 'z' ; ch++) {
                    char[] replacedCharArray=currWord.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);

                    //if the word already exits in the set then remove it
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        qu.offer(new Pair(replacedWord,step+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));

        System.out.println(wordLadderShortestTransformationSequence(beginWord,endWord,wordList));
    }
}

//T.C - O(n*m) // where n=number of words in the wordlist , m=currWord.length    (exact complexity= n * m * 26(for internal character loop) * Log n(for hashset operations))
//S.C - O(n)
