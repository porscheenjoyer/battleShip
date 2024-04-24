import java.util.*;

public class SafeInput {

    public static String yourName(Scanner pipe) {

        String fName = " ";
        String lName = " ";

        System.out.println("What is your first name?");
        fName = pipe.nextLine();

        System.out.println("What is your last name?");
        lName = pipe.nextLine();



        return fName + " " + lName;

    }

    public static int twoNumbers(int a, int b) {

        int c = 0;

        c = a + b;

        return c;

    }

    public static void prettyHeader(String msg) {

        int totalSpaces = 60 - 6 - msg.length();
        int leftSpace = 0;
        int rightSpace = 0;

        if (totalSpaces % 2 == 0) {

            leftSpace = rightSpace = totalSpaces / 2;


        }
        else {

            rightSpace = totalSpaces / 2;
            leftSpace = rightSpace + 1;

        }

        //Print top border
        for (int i = 0; i <= 60; i ++) {

            System.out.print("*");

        }

        System.out.println();

        //first three *
        System.out.print("***");

        //Left Spaces
        for (int i = 0; i <= leftSpace; i ++) {

            System.out.print(" ");

        }

        //Print the message
        System.out.print(msg);

        //Print right side
        for (int i = 0; i < rightSpace; i ++) {

            System.out.print(" ");

        }

        System.out.print("***");
        System.out.println();

        //Bottom border
        for (int i = 0; i <= 60; i ++) {

            System.out.print("*");

        }

        return;

    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {

        String retString = " ";

        do {

            System.out.print("\n" +prompt+ ": ");
            retString = pipe.nextLine();


        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, int userNum) {

        String trash = " ";
        boolean done = false;

        do {

            System.out.println("What is your favorite integer?");

            if (pipe.hasNextInt()) {

                userNum = pipe.nextInt();
                done = true;

            }

            else {

                trash = pipe.nextLine();
                System.out.println("You must input an Integer\nYour input: " + trash);

            }

        } while (!done);

        return userNum;

    }

    public static double getDouble(Scanner pipe, double userNum) {

        String trash = " ";
        boolean done = false;

        do {

            System.out.println("What is your favorite double?");

            if (pipe.hasNextDouble()) {

                userNum = pipe.nextDouble();
                done = true;

            }

            else {

                trash = pipe.nextLine();
                System.out.println("You must input a double\nYour input: " + trash);

            }

        } while (!done);

        return userNum;

    }

    public static  int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        int returnInt;
        String trash = "";

        while(true) {

            System.out.println(prompt);
            if(pipe.hasNextInt()) {

                returnInt = pipe.nextInt();

                if (returnInt >= low && returnInt <= high) {

                    return returnInt;

                }

                else {

                    System.out.println("Number out of range.");

                }

            }

            else {

                trash = pipe.nextLine();
                System.out.println("Incorrect Input: " + trash);

            }

        }

    }

    public static  double getRangedDouble(Scanner pipe, String prompt, double low, double high) {

        double returnDouble;
        String trash = "";

        while(true) {

            System.out.println(prompt);
            if(pipe.hasNextDouble()) {

                returnDouble = pipe.nextDouble();

                if (returnDouble >= low && returnDouble <= high) {

                    return returnDouble;

                }

                else {

                    System.out.println("Number out of range.");

                }

            }

            else {

                trash = pipe.nextLine();
                System.out.println("Incorrect Input: " + trash);

            }

        }

    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {

        boolean done = false;
        String response = "";
        String trash = "";

        do {

            System.out.println(prompt);

            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {

                System.out.println("Continue...");
                done = true;
                break;

            }

            else if (response.equalsIgnoreCase("n")){

                done = false;
                break;

            }

        } while (true);

        return done;


    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx){

        String userInput = "";



        do {

            System.out.println(prompt);

            userInput = pipe.nextLine();

            if (userInput.matches(regEx)) {

                break;

            }

            else {

                System.out.println("Does not match the pattern, try again");

            }

        } while (true);


        return userInput + regEx;

    }

    public static double getAverage(int values[]) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        values = new int [100];

        for (int i = 0; i < values.length; i ++) {

            values[i] = rnd.nextInt(100);

        }

        for (int i = 0; i < values.length; i ++) {

            System.out.print(values[i] + " | ");

        }

        System.out.println();

        double sum = 0;

        int counter = 0;

        for (int i = 0; i < values.length; i ++) {

            sum = sum + values[i];

            counter += 1;

        }

        double average = sum / counter;

        return average;

    }

    public static int min(int values[]) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        values = new int [100];

        for (int i = 0; i < values.length; i ++) {

            values[i] = rnd.nextInt(100);

        }

        int min = 0;

        int minLocation = 0;

        min = values[0];

        for (int i = 0; i < values.length; i ++) {

            if (values[i] < min) {

                min = values[i];
                minLocation = i;

            }

        }

        return min + minLocation;

    }

    public static int max(int values[]) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        values = new int [100];

        for (int i = 0; i < values.length; i ++) {

            values[i] = rnd.nextInt(100);

        }

        int max = 0;

        int maxLocation = 0;

        for (int i = 0; i < values.length; i ++) {

            if (values[i] > max) {

                max = values[i];
                maxLocation = i;

            }

        }

        return max + maxLocation;

    }

    public static int occuranceScan(int values[], int target) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        values = new int [100];

        for (int i = 0; i < values.length; i ++) {

            values[i] = rnd.nextInt(100);

        }

        target = SafeInput.getRangedInt(in, "Enter a number 1 to 100.", 1, 100);

        for (int i = 0; i < values.length; i ++) {

            if (target == values[i]) {

                target += 1;

            }

        }

        return target;

    }

    public static int sum(int values[]) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        values = new int [100];

        for (int i = 0; i < values.length; i ++) {

            values[i] = rnd.nextInt(100);

        }

        int sum = 0;

        int counter = 0;

        for (int i = 0; i < values.length; i ++) {

            sum = sum + values[i];

        }

        return sum;

    }

    public static boolean contains(int values[], int target) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        values = new int[100];

        for (int i = 0; i < values.length; i++) {

            values[i] = rnd.nextInt(100);

        }

        int userNum = SafeInput.getRangedInt(in, "Enter a number 1 to 100.", 1, 100);

        boolean found = false;

        for (int i = 0; i < values.length; i++) {

            if (userNum == values[i]) {

                found = true;
                break;

            }

        }

        return found;

    }


}