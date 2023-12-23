package Find_location;


    public class Mainenhance  {
//    public static void main(String[] args){
//        pathFinding(0,0);
//    }
//    static void pathFinding(int r, int c){
//        int cout = 0;
//        if(r == 2 && c == 2){// base condition
//            cout++;
//            System.out.println(cout);
//            return;
//        }
//        // down
//        if ( r < 2){
//            pathFinding(r + 1, c ); //recursive call
//            System.out.println("Go down");
//        }
//        //right
//        if (c < 2){
//            pathFinding(r, c +1);  //recursive call
//            System.out.println("Go right");
//        }
//    }

        public static void main(String[] args){
//        pathFinding("",0,0);
            boolean[][] board = {
                    {true,true,true},
                    {true,true,true},
                    {true,true,true}
            };
//        pathFindingWithObstacle(" ", board ,0,0);
            allPath("", board, 0,0);
        }
        static void pathFinding(String p, int r, int c){
            if(r == 2 && c == 2){// base condition
                System.out.println(p);
                return;
            }
            // down
            if ( r < 2){
                pathFinding(p + 'D',r + 1, c ); //recursive call
            }
            //right
            if (c < 2){
                pathFinding(p+'R',r, c +1);  //recursive call
            }
        }
        static void pathFindingWithObstacle(String p, boolean[][] board, int r, int c){
            if(r == board.length && c == board.length){// base condition
                System.out.println(p);
                return;
            }
            //check restriction
//        if( r == 1 && c == 1) {
//            return;
//        }
            if(!board[r][c]){
                return;
            }
            // down
            if (r < 2) {
                pathFindingWithObstacle(p + 'D', board,r + 1, c); //recursive call
            }
            //right
            if (c < 2) {
                pathFindingWithObstacle(p + 'R',  board, r, c + 1);  //recursive call
            }
        }
        static void allPath(String p, boolean[][] board, int r, int c){
            if(r == board.length - 1  && c == board[0].length - 1){// base condition
                System.out.println(p);
                return;
            }
            if(!board[r][c]){
                return;
            }
            board[r][c] = false; //backtracking
            // up
            if (r > 0) {
                allPath(p + 'U', board,r - 1, c); //recursive call
            }
            // down
            if (r < board[0].length-1) {
                allPath(p + 'D', board,r + 1, c); //recursive call
            }
            //right
            if (c < board.length-1) {
                allPath(p + 'R',  board, r, c + 1);  //recursive call
            }
            //left
            if (c > 0) {
                allPath(p + 'L',  board, r , c - 1);  //recursive call
            }

            board[r][c] = true; //backtracking
        }
    }