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
        String playerMove = "-";

        int moveCount = 0;

        boolean gameOver = false;

        int missCounter = 0;

        int strike = 0;

        int hitCounter = 0;

        boolean playAgain = false;

        clearBoard();
        display();

        placeShip(PATROLBOAT);
        placeShip(SUBMARINE);
        placeShip(CRUISER);
        placeShip(BATTLESHIP);
        placeShip(CARRIER);



        //Play Again Loop
        do {



            //Game Loop
            do {

                display();

                //Move Loop
                do {

                    System.out.println("What is your move?");
                    int row = SafeInput.getRangedInt(in, "Row: ", 1, 10);

                    String alphaCol = SafeInput.getRegExString(in, "Column: ", "[AaBbCcDdEeFfGgHhIiJj]");
                    alphaCol = alphaCol.toUpperCase();
                    int col = 0;

                    System.out.println(alphaCol);

                    switch (alphaCol) {

                        case "A":
                            col = 0;
                            System.out.println(col);
                            break;
                        case "B":
                            col = 1;
                            System.out.println(col);
                            break;
                        case "C":
                            col = 2;
                            System.out.println(col);
                            break;
                        case "D":
                            col = 3;
                            System.out.println(col);
                            break;
                        case "E":
                            col = 4;
                            System.out.println(col);
                            break;
                        case "F":
                            col = 5;
                            System.out.println(col);
                            break;
                        case "G":
                            col = 6;
                            System.out.println(col);
                            break;
                        case "H":
                            col = 7;
                            System.out.println(col);
                            break;
                        case "I":
                            col = 8;
                            System.out.println(col);
                            break;
                        case "J":
                            col = 9;
                            System.out.println(col);
                            break;
                        default:
                            System.out.println("Not working");
                            break;
                    }

                    col++;

                    if (board[col][row].equalsIgnoreCase("boat")) {

                        board[col][row] = "hit";
                        System.out.println("Hit");
                        hitCounter++;
                        missCounter = 0;

                    }

                    else if (board[col][row].equalsIgnoreCase("-")) {

                        board[col][row] = "miss";
                        missCounter++;
                        System.out.println("You missed :(");

                        if (missCounter == 5) {

                            strike++;
                            missCounter = 0;
                            System.out.println("You got a strike!\nStrikes: " + strike);

                            if (strike == 3) {

                                System.out.println("You got 3 strikes!\nGame Over!");
                                gameOver = true;
                                break;

                            }

                        }
                    }


                    System.out.println("Misses: " + missCounter + "\nStrikes: " + strike + "\nHits: " + hitCounter);
                    break;

                } while (true);

                if (hitCounter == 17) {

                    System.out.println("You sank all of the boats!\nYou Won!");
                    gameOver = true;

                }

            } while (!gameOver);

            playAgain = SafeInput.getYNConfirm(in, "So you want to play again?");

        } while (!playAgain);

    }

    private static void clearBoard() {
        //Loop
        for (int row = 0; row < ROW; row ++) {

            //Loop
            for (int col = 0; col < COL; col ++) {

                board[row][col] = "-";

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



    private static void gameDisplay() {

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

        boolean validMove;

        if (board[row][col].equals("-")) {

            validMove = true;

        }

        else {

            System.out.println("Already something there");
            validMove = false;

        }

        return validMove;

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

                    if (board[row + i][col].equals("-")) { //\uD83c\uDF0A is wave or -

                        //Sub needs two more spaces
                        validCounter ++;

                    }

                }

            } while (validCounter != (ship + 1));

            //We have a valid row area, place the ship

            for (int i = 0; i <= ship; i ++) {

                board[row + i][col] = "boat"; //\u26F4 is ship

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

                    if (board[row][col + i].equals("-")) {

                        //Sub needs two more spaces
                        validCounter ++;

                    }

                }

            } while (validCounter != (ship + 1));

            //We have a valid col area, place the ship

            for (int i = 0; i <= ship; i ++) {

                board[row][col + i] = "boat";

            }

        }

    }
}