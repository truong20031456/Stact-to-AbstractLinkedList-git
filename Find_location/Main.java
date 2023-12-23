package Find_location;

public class Main {
    public static void main(String[] args) {

        boolean[][] board ={{true,true,true},
                             {true, false,true},
                              {true,true,true}};
        CoordinatesWithObstracle("",board,0,0);
    }
    static void CoordinatesWithObstracle(String s,boolean[][]board, int row,int column){
        if(row == board.length -1 && column== board[0].length-1){
            System.out.println(s);
            return;
        }
        if(!board[row][column]){
            return;
        }
        board[row][column]=false;
        // Go down
        if(row< board.length-1){
            CoordinatesWithObstracle(s+"D",board,row +1, column);
        }
        //Go right
        if(column<board[0].length-1){
            CoordinatesWithObstracle(s+"R",board,row,column+1);
        }
        // go up
        if(row>0){
            CoordinatesWithObstracle(s+"U",board,row-1,column);
        }
        // go left
        if(column>0){
            CoordinatesWithObstracle(s+"L",board,row,column-1);
        }
        board[row][column]= true;

    }

}
