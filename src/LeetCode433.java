import java.util.*;

class Gene{
    String mutation;
    Integer step;

    Gene(String mutation,Integer step){
        this.mutation=mutation;
        this.step=step;
    }
}

public class LeetCode433 {
    //433. Minimum Genetic Mutation
    //BFS Based Solution

    static int mutationCount(String start,String end,String[] bank){
        if(start.equals(end)) return 1;

        Set<String> visited = new HashSet<>();

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));  // same as adding each element from bank[] into set using foreach loop
        Queue<Gene> qu=new LinkedList<>();

        visited.add(start);
        qu.offer(new Gene(start,1));

        while(!qu.isEmpty()){
            Gene nextMutaion=qu.poll();
            if(nextMutaion.mutation.equals(end)) {
                return nextMutaion.step-1;
            }

            for (int i = 0; i < 8 ; i++) { //length of the gene is 8
                char[] possibleGenes=new char[]{'A','B','C','G','T'};
                for(char currGene:possibleGenes){
                    String temp= nextMutaion.mutation.substring(0,i)+currGene+nextMutaion.mutation.substring(i+1);
                    if(bankSet.contains(temp) && !visited.contains(temp)){
                        visited.add(temp);
                        qu.offer(new Gene(temp,nextMutaion.step+1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        System.out.println(mutationCount(start,end,bank));
    }
}
