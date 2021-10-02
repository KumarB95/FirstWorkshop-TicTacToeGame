package com.bridgelabz.tictactoegame;

import java.util.Random;
import java.util.Scanner;

public class Utility {
    private static final Scanner scan = new Scanner(System.in);
    public static int getUserInteger() {
        return scan.nextInt();
    }

     /* Random for calling different random numbers
	 */
    private static final Random random= new Random();

    public static int getRandomInt(int number) {
        return random.nextInt(number);
    }

    public static int[] winArray(int number) {
        if (number==1) {
            int arrayWin[]= {1,2,3};
            return arrayWin;
        } else if (number==2) {
            int arrayWin[]= {4,5,6};
            return arrayWin;
        } else if (number==3) {
            int arrayWin[]= {7,8,9};
            return arrayWin;
        } else if (number==4) {
            int arrayWin[]= {1,4,7};
            return arrayWin;
        } else if (number==5) {
            int arrayWin[]= {2,5,8};
            return arrayWin;
        } else if (number==6) {
            int arrayWin[]= {3,6,9};
            return arrayWin;
        } else if (number==7) {
            int arrayWin[]= {1,5,9};
            return arrayWin;
        } else {
            int arrayWin[]= {3,5,7};
            return arrayWin;
        }
    }

}
