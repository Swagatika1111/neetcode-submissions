class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check for row
        for(int row=0; row<9; row++){
                Set<Character> set = new HashSet<>();
            for(int col=0; col<9; col++){
                if(board[row][col]=='.'){
                    continue;
                }
                if(!set.add(board[row][col])){
                    return false;
                }
            }
        }

        //check for column
        for(int col=0; col<9; col++){
                Set<Character> set = new HashSet<>();
            for(int row=0; row<9; row++){
                if(board[row][col]=='.'){
                    continue;
                }
                if(!set.add(board[row][col])){
                    return false;
                }
            }
        }

        //check for sub-boxes
        for(int sr=0; sr<9; sr+=3){
            int er=sr+2;
            for(int sc=0; sc<9; sc+=3){
                int ec=sc+2;
                if(!traverse(board,sr,er,sc,ec)){
                    return false;
                }
            }
            
    }
    return true;
    }

    public boolean traverse(char[][] board, int sr, int er, int sc, int ec){
        Set<Character> set = new HashSet<>();
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                if(board[i][j]=='.') continue;

                if(!set.add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
    
}