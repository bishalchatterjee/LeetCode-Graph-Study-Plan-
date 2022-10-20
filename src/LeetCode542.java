import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
    //542. 01 Matrix

    static int[][] updateMatrixToDistance(int[][] matrix){
        Queue<int[]> q=new LinkedList<>();

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if(matrix[i][j]==0)
                    q.offer(new int[]{i,j});
                else
                    matrix[i][j]=-1; //used as a visited or not check
            }
        }

        int[][] dirs={{0,1},{-1,0},{1,0},{0,-1}}; //directions

        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            level++;
            while(size-- > 0){
                int[] cell=q.poll();

                for(int[] dir:dirs) {
                    int r = cell[0]+dir[0];
                    int c = cell[1]+dir[1];

                    if (r < 0 || r == matrix.length || c < 0 || c == matrix[0].length || matrix[r][c] !=-1)
                        continue;
                    matrix[r][c]=level;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix={{0,0,0},{0,1,0},{1,1,1}};

        System.out.println(Arrays.deepToString(updateMatrixToDistance(matrix)));
    }
}


//T.C - O(row * col)
//S.C - O(row * col)