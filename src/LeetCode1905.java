public class LeetCode1905 {
    //1905. Count Sub Islands


    static int countSubIslands(int[][] grid1,int[][] grid2){
        int res=0;
        for (int i = 0; i < grid2.length ; i++) {
            for (int j = 0; j < grid2[0].length ; j++) {
                if(grid2[i][j]==1 && helperDFS(grid1,grid2,i,j)) res++;
            }
        }
        return res;
    }
    static boolean helperDFS(int[][] grid1,int[][] grid2,int i,int j){ //DFS function
        if(i>=0 && i< grid2.length &&  j>=0 && j < grid2[0].length && grid2[i][j]==1){

            if(grid2[i][j]!=grid1[i][j]) return false;
            grid1[i][j]=0;

            boolean down=helperDFS(grid1, grid2, i+1, j);
            boolean up=helperDFS(grid1, grid2, i-1, j);
            boolean right=helperDFS(grid1, grid2, i, j+1);
            boolean left=helperDFS(grid1, grid2, i, j-1);

            if(!left || !right || !up || !down) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};

        System.out.println(countSubIslands(grid1,grid2));
    }
}


//T.C - O(row*column)
//S.C - O(row*column)