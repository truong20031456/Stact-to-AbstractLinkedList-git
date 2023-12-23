package Findway;

public class Maze {
    final static int N = 4;
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        maze("",0,0, maze);

    }
    static void maze(String s,int row, int column, int[][] maze){
        if(row==4||column==4){
            return;
        }
        if(row==3&&column==3){
            System.out.println(s);
            return;
        }
        //go down
        if(row<3 && maze[row+1][column] == 1){
            maze[row][column] = 0;
            maze(s+'D',row+1,column, maze);
            maze[row][column] = 1;
        }
        //go up
        if(row>0 && maze[row-1][column] == 1){
            maze[row][column] = 0;
            maze(s+'U',row-1,column, maze);
            maze[row][column] = 1;
        }
        //go right
        if(column<3 && maze[row][column+1] == 1){
            maze[row][column] = 0;
            maze(s+'R',row,column+1, maze);
            maze[row][column] = 1;
        }
        //go left
        if(column>0 && maze[row][column-1] == 1){
            maze[row][column] = 0;
            maze(s+'L',row,column-1, maze);
            maze[row][column] = 1;
        }
    }
}
