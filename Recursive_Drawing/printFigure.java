package Recursive_Drawing;

public class printFigure {
    public static void main(String[] args) {
        printFg(4);
    }

    static void printFg(int n){
        if (n > 0) {
            printLineOfChars('*', n);
            printFg(n - 1);
            printLineOfChars('#', n);
        }
    }

    static void printLineOfChars(char c, int n) {
        if (n > 0) {
            System.out.print(c);
            printLineOfChars(c, n - 1);
        } else {
            System.out.println();
        }
    }
}
