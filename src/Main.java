import java.util.*;

public class Main {

    private static final int ROW = 11;

    private static final int COL = 11;

    private static final String[][] board = new String[ROW][COL];

    //Ship lengths
    private static final int PATROLBOAT = 1;

    private static  final int SUBMARINE = 2;

    private static final int CRUISER = 2;

    private static final int BATTLESHIP = 3;

    private static final int CARRIER = 4;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Random rand = new Random();

        //Variables
        String playerMove = "\u26F4";

        int moveCount = 0;

        boolean gameOver = false;

        clearBoard();
        display();

        placeShip(PATROLBOAT);
        placeShip(SUBMARINE);
        placeShip(CRUISER);
        placeShip(BATTLESHIP);
        placeShip(CARRIER);

        display();

    }

    private static void clearBoard() {



        //Loop
        for (int row = 0; row < ROW; row ++) {

            //Loop
            for (int col = 0; col < COL; col ++) {

                board[row][col] = "\uD83C\uDF0A";

            }

        }

        //Numbers on top of board
        board[0][0] = "  ";
        board[0][1] = "1";
        board[0][2] = " 2";
        board[0][3] = "3";
        board[0][4] = " 4";
        board[0][5] = "5";
        board[0][6] = " 6";
        board[0][7] = "7";
        board[0][8] = " 8";
        board[0][9] = "9";
        board[0][10] = " 10";

        //Letters on side of board
        board[1][0] = "A";
        board[2][0] = "B";
        board[3][0] = "C";
        board[4][0] = "D";
        board[5][0] = "E";
        board[6][0] = "F";
        board[7][0] = "G";
        board[8][0] = "H";
        board[9][0] = "I";
        board[10][0] = "J";

    }

    //display the board
    private static void display() {

        //Loop
        for (int row = 0; row < ROW; row ++) {

            System.out.print("| ");

            //Loop
            for (int col = 0; col < COL; col ++) {

                System.out.print(board[row][col] + " | ");

            }
            System.out.println();

        }

    }

    private static boolean isValidMove (int row, int col) {

        boolean validMove = board[row][col].equals("\uD83C\uDF0A");

        return validMove;

    }

    public static void PlaceShips() {



    }

    public static void PatrolShip() {

        //Variables
        Random rand = new Random();


        //Variables
        int vertOrHori = rand.nextInt(2);


        //If ship is vertical
        if (vertOrHori == 0) {

            board[rand.nextInt(9) + 1][rand.nextInt(10) + 1] = "\u26F4";

        }

        //If ship is horizontal
        else if (vertOrHori == 1) {

            board[rand.nextInt(10) + 1][rand.nextInt(9) + 1] = "\u26F4";

        }

    }

    public static void placeShip (int ship) {

        Random rnd = new Random();

        //vertOrHorz needs to be bound to 2 (0,1)
        int vertOrHorz = rnd.nextInt(2);

        //Need to count valid spaces
        int validCounter = 0;
        int row = 0;
        int col = 0;

        //Place ship vertically
        if (vertOrHorz == 0) {

            //Rely on column - check all positions to see if we can go there

            do {

                //Reset the validCounter each time
                validCounter = 0;

                row = rnd.nextInt(10 - ship);

                col = rnd.nextInt(10 - ship + 1);

                System.out.println("Vertically placing " + ship + " in position: " + row + " " + col);

                for (int i = 0; i <= ship; i ++) {

                    if (board[row + i][col].equals("\uD83C\uDF0A")) { //\uD83c\uDF0A is wave or -

                        //Sub needs two more spaces
                        validCounter ++;

                    }

                }

            } while (validCounter != (ship + 1));

            //We have a valid row area, place the ship

            for (int i = 0; i <= ship; i ++) {

                board[row + i][col] = "\u26F4"; //\u26F4 is ship

            }

        }

        //Place the ship horizontally
        else {

            do {

                //Reset the validCounter each time
                validCounter = 0;

                row = rnd.nextInt(10 - ship + 1);

                col = rnd.nextInt(10 - ship);

                System.out.println("Horizontally placing " + ship + " in position: " + row + " " + col);

                for (int i = 0; i <= ship; i ++) {

                    if (board[row][col + i].equals("\uD83C\uDF0A")) {

                        //Sub needs two more spaces
                        validCounter ++;

                    }

                }

            } while (validCounter != (ship + 1));

            //We have a valid col area, place the ship

            for (int i = 0; i <= ship; i ++) {

                board[row][col + i] = "\u26F4";

            }

        }

    }
}