import java.util.*;
public class ConnectFour {
    public static void main (String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Connect 4. Decide which player is red and which is yellow. Who goes first is random.");
        int turn;
        boolean isWon = false;
        int col;
        int movesPlayed = 0;
        boolean full = false;

        if ((int)(Math.random() + .5) == 0) {
            turn = 0; //red goes first
            System.out.println("Red goes first. Begin!");
        }
        else {
            turn = 1; //yellow goes first
            System.out.println("Yellow goes first. Begin!");
        }

        String[][]board = new String[6][8]; //made the board 6x8 so the board would be printed formatted correctly
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = "|   ";
            }
        }

        do {
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    System.out.print(board[row][column]);
                }
                System.out.println();
            }
            System.out.println(". . . . . . . . . . . . . . . ");

            if (turn % 2 == 0 || turn == 0) {
                System.out.print("Drop a red disk at column (0 - 6): "); //RED
                while(true ) {
                    try {
                        col = input.nextInt();
                        if (col >= 7 || col < 0) {
                            col = 100;
                            while(col >= 7 ) {
                                System.out.print("NOPE! Try again: ");
                                System.out.print("\nDrop a red disk at column (0 - 6): "); //RED
                                input.nextLine();
                                col = input.nextInt();
                                if (col < 0) {
                                    col = 100;
                                }
                                if (col <= 6 && col >= 0) {
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    catch (InputMismatchException e) {
                        System.out.println("NOPE! Try again");
                        System.out.print("Drop a red disk at column (0 - 6): "); //RED
                        input.nextLine();
                    }
                }
                full = fullColumn(board, col);
                inputChip(board, col, turn); // call method to put chip down
                if (fullColumn(board, col) == true) {
                    System.out.println("Column " + col + " is full. Try another column");
                    continue;
                }
                movesPlayed++;
                if (isHorizontal(board) == true) { // checks for horizontal win
                    isWon = true;
                }
                else if (isVertical(board) == true) { // checks for vertical win
                    isWon = true;
                }
                else if (isDiagonal1(board) == true) { // checks for Diagonal1 win
                    isWon = true;
                }
                else if (isDiagonal2(board) == true) { // checks for Diagonal2 win
                    isWon = true;
                }
                else if (movesPlayed == 42) {
                    isWon = true;
                }

                if (isWon == true) {
                    for (int row = 0; row < board.length; row++) {
                        for (int column = 0; column < board[row].length; column++) {
                            System.out.print(board[row][column]);
                        }
                        System.out.println();
                    }
                    System.out.println(". . . . . . . . . . . . . . . ");

                    if (movesPlayed == 42) {
                        System.out.println("No winner. You ended in a tie. Hit run to play again");
                    }
                    else {
                        System.out.println( "Red wins! Gratz!!!");
                    }
                }
                turn++; //increases counter. Yellow's turn
            }
            else {
                System.out.print("Drop a yellow disk at column (0 - 6): "); //YELLOW
                while(true) {
                    try {
                        col = input.nextInt();
                        if (col >= 7 || col < 0) {
                            col = 100;
                            while(col >= 7) {
                                System.out.print("NOPE! Try again: ");
                                System.out.print("\nDrop a yellow disk at column (0 - 6): "); //YELLOW
                                input.nextLine();
                                col = input.nextInt();
                                if (col < 0) {
                                    col = 100;
                                }
                                if (col <= 6 && col >= 0) {
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    catch (InputMismatchException e) {
                        System.out.println("NOPE! Try again");
                        System.out.print("Drop a yellow disk at column (0 - 6): "); //YELLOW
                        input.nextLine();
                    }
                }
                full = fullColumn(board, col);
                inputChip(board, col, turn); // call method to put chip down
                if (full == true) {
                    System.out.println("Column " + col + " is full. Try another column");
                    continue;
                }
                movesPlayed++;
                if (isHorizontal(board) == true) { // checks for horizontal win
                    isWon = true;
                }
                else if (isVertical(board) == true) { // checks for vertical win
                    isWon = true;
                }
                else if (isDiagonal1(board) == true) { // checks for Diagonal1 win
                    isWon = true;
                }
                else if (isDiagonal2(board) == true) { // checks for Diagonal2 win
                    isWon = true;
                }
                else if (movesPlayed == 42) {
                    isWon = true;
                }

                if (isWon == true) {
                    for (int row = 0; row < board.length; row++) {
                        for (int column = 0; column < board[row].length; column++) {
                            System.out.print(board[row][column]);
                        }
                        System.out.println();
                    }
                    System.out.println(". . . . . . . . . . . . . . . ");

                    if (movesPlayed == 42) {
                        System.out.println("No winner. You ended in a tie. Hit run to play again");
                    }
                    else {
                        System.out.println( "Yellow Wins! Gratz!!!");
                    }
                }
                turn++; //increases counter. Yellow's turn
            }
        }

        while (isWon == false);
    }

    //Method 1
    public static void inputChip (String[][] matrix, int col, int counter) {

        try {
            if (counter % 2 == 0) { //even/red
                for (int row = 5; row < 6; row--) {
                    if (matrix[row][col] == "|   ") {
                        matrix[row][col] = "| R ";
                        break;

                    }
                    else if (matrix[row][col] == "|   "){
                        matrix[row][col] = "| R ";
                    }
                }
            }
            else { //odd/yellow
                for (int row = 5; row < 6; row--) {
                    if (matrix[row][col] == "|   ") {
                        matrix[row][col] = "| Y ";
                        break;
                    }
                    else if (matrix[row][col] == "|   "){
                        matrix[row][col] = "| Y ";
                    }
                }
            }
        }
        catch (Exception e2) {
            return;
        }
    }

    //Method 2
    public static boolean isHorizontal(String[][] ary) {
        boolean izHorizontal = false;
        int redCounter = 0;
        int yellowCounter = 0;
        String red = "| R ";
        String yellow = "| Y ";

        for (int i = 0;i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (ary[i][j] == red) {
                    redCounter++;
                }
                else {
                    redCounter = 0;
                }
                if (redCounter >= 4) {
                    izHorizontal = true;
                    return izHorizontal ;
                }
            }
        }

        for (int i = 0;i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (ary[i][j] == yellow) {
                    yellowCounter++;
                }
                else {
                    yellowCounter = 0;
                }
                if (yellowCounter >= 4) {
                    izHorizontal = true;
                    return izHorizontal;
                }
            }
        }
        return izHorizontal;
    }

    //Method 3
    public static boolean isVertical(String[][] ary) {
        boolean izVertical = false;
        int redCounter = 0;
        int yellowCounter = 0;
        String red = "| R ";
        String yellow = "| Y ";

        for (int i = 0;i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (ary[j][i] == red) {
                    redCounter++;
                }
                else {
                    redCounter = 0;
                }
                if (redCounter >= 4) {
                    izVertical = true;
                    return izVertical;
                }
            }
        }

        for (int i = 0;i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (ary[j][i] == yellow) {
                    yellowCounter++;
                }
                else {
                    yellowCounter = 0;
                }
                if (yellowCounter >= 4) {
                    izVertical = true;
                    return izVertical;
                }
            }
        }

        return izVertical;
    }

    //Method 4
    public static boolean isDiagonal1(String[][] ary) {
        boolean izDiagonal1 = false;
        int redCounter = 0;
        int yellowCounter = 0;
        String red = "| R ";
        String yellow = "| Y ";
        int r1, c1, x1, y1;
        int r2, c2, x2, y2;

        for (r1 = 2, c1 = 3; r1 >= 0 && c1 <= 5; r1--, c1++) {
            for (x1 = r1, y1 = 0; y1 <= c1 && x1 <= 5; x1++, y1++) {

                if (ary[x1][y1] == red) {
                    redCounter++;
                }
                else {
                    redCounter = 0;
                }
                if (redCounter >= 4) {
                    izDiagonal1 = true;
                    return izDiagonal1;
                }
                if (x1 == 5) {
                    redCounter = 0;
                }
            }
        }
        for (r2 = 5, c2 = 1; r2 >= 3 && c2 <= 6; r2--, c2++) {
            for (x2 = 0, y2 = c2; x2 <= r2 && y2 <= 6; x2++, y2++) {
                if (ary[x2][y2] == red) {
                    redCounter++;
                }
                else {
                    redCounter = 0;
                }
                if (redCounter >= 4) {
                    izDiagonal1 = true;
                    return izDiagonal1;
                }
                if (y2 == 6) {
                    redCounter = 0;
                }
            }
        }

        for (r1 = 2, c1 = 3; r1 >= 0 && c1 <= 5; r1--, c1++) {
            for (x1 = r1, y1 = 0; y1 <= c1 && x1 <= 5; x1++, y1++) {
                if (ary[x1][y1] == yellow) {
                    yellowCounter++;
                }
                else {
                    yellowCounter = 0;
                }
                if (yellowCounter >= 4) {
                    izDiagonal1 = true;
                    return izDiagonal1;
                }
                if (x1 == 5) {
                    yellowCounter = 0;
                }
            }
        }
        for (r2 = 5,c2 = 1;r2 >= 3 && c2 <= 6;r2--, c2++) {
            for (x2 = 0, y2 = c2; x2 <= r2 && y2 <= 6; x2++, y2++) {
                if (ary[x2][y2] == yellow) {
                    yellowCounter++;
                }
                else {
                    yellowCounter = 0;
                }
                if (yellowCounter >= 4) {
                    izDiagonal1 = true;
                    return izDiagonal1;
                }
                if (y2 == 6) {
                    redCounter = 0;
                }
            }
        }

        return izDiagonal1;
    }

    //Method 5
    public static boolean isDiagonal2(String[][] ary) {
        boolean izDiagonal2 = false;
        int redCounter = 0;
        int yellowCounter = 0;
        String red = "| R ";
        String yellow = "| Y ";
        int r1, c1, x1, y1;
        int r2, c2, x2, y2;

        for (r1 = 3, c1 = 3; r1 >= 0 && c1 <= 5; r1++, c1++) {
            for (x1 = r1, y1 = 0; y1 <= c1 && x1 >= 0; x1--, y1++) {

                if (ary[x1][y1] == red) {
                    redCounter++;
                }
                else {
                    redCounter = 0;
                }
                if (redCounter >= 4) {
                    izDiagonal2 = true;
                    return izDiagonal2;
                }
                if (x1 == 0) {
                    redCounter = 0;
                }
            }
        }
        for (r2 = 0, c2 = 1; r2 <= 2 && c2 <= 6; r2++, c2++) {
            for (x2 = 5, y2 = c2; x2 >= r2 && y2 <= 6; x2--, y2++) {
                if (ary[x2][y2] == red) {
                    redCounter++;
                }
                else {
                    redCounter = 0;
                }
                if (redCounter >= 4) {
                    izDiagonal2 = true;
                    return izDiagonal2;
                }
                if (y2 == 6) {
                    redCounter = 0;
                }
            }
        }

        for (r1 = 3, c1 = 3; r1 >= 0 && c1 <= 5; r1++, c1++) {
            for (x1 = r1, y1 = 0; y1 <= c1 && x1 >= 0; x1--, y1++) {
                if (ary[x1][y1] == yellow) {
                    yellowCounter++;
                }
                else {
                    yellowCounter = 0;
                }
                if (yellowCounter >= 4) {
                    izDiagonal2 = true;
                    return izDiagonal2;
                }
                if (x1 == 0) {
                    yellowCounter = 0;
                }
            }
        }
        for (r2 = 0, c2 = 1; r2 <= 2 && c2 <= 6; r2++, c2++) {
            for (x2 = 5, y2 = c2; x2 >= r2 && y2 <= 6; x2--, y2++) {
                if (ary[x2][y2] == yellow) {
                    yellowCounter++;
                }
                else {
                    yellowCounter = 0;
                }
                if (yellowCounter >= 4) {
                    izDiagonal2 = true;
                    return izDiagonal2;
                }
                if (y2 == 6) {
                    redCounter = 0;
                }
            }
        }

        return izDiagonal2;
    }

    //Method 6
    public static boolean fullColumn(String[][] ary, int col) {
        boolean full = false;
        String empty = "|   ";


        if (ary[0][col] !=  empty) {
            return true;
        }
        return full;
    }
}