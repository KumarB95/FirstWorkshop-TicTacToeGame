package com.bridgelabz.tictactoegame;

import java.util.Random;
import java.util.Scanner;

/**
 * Program for TicTacToe Game
 * Author: Navalkumar
 * Date: 23/09/2021
 */

public class TicTacToeGame {
    static char[] board = new char[10];
    static char userMark, computerMark;
    static int turn = 1, flag = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Program !");
        //creating board
        createBoard();
        //choosing letter and determining player and computer letter
        choosingLetter();
        //Displaying board to player
        toss();
        //to play game until someone wins i.e. flag = 1
        outerloop:
        while(flag==0) {
            if((turn+1)%2==0) {
                //to check whether game is tie or not
                flag=checkTie();
                if (flag!=0) {
                    System.out.println("Nice Play! It's Tie");;
                    break outerloop;
                }
                //for display the current board
                currentBoard();
                //for calling the user for number
                userCall();
                //for making the mark on user number
                userMove();
                //to check whether user is winner or not
                flag=checkWin();
                if (flag!=0) {
                    System.out.println("Excellent! You are the winner");
                    break outerloop;
                }
                turn++;
            } else {
                //to check whether game is tie or not
                flag=checkTie();
                if (flag!=0) {
                    System.out.println("Nice Play! It's Tie");;
                    break outerloop;
                }
                //To check whether computer is winning or not
                flag=computerWin();
                if (flag==1) {
                    break outerloop;
                }
                //Choosing to block user else opting for number
                for (int i=1; i<=3; i++) {
                    switch (i) {
                        case 1: flag=computerBlock();
                            break;
                        case 2: flag=computerCorner();
                            break;
                        default: flag=computerCenterSide();
                    }
                    if (flag==1) {
                        turn++;
                        flag=0;
                        break;
                    }
                }
            }
        }
        //To initiate the game again
        gameAgain();
    }

    private static void gameAgain() {
        System.out.println("\nWanna play again. 1) Restart 2) Exit");
        int option=Utility.getUserInteger();
        if (option==1) {
            String[] args = { };
            main(args);
        } else {
            System.exit(1);
        }
    }

    private static int computerCenterSide() {
        if (board[5] != 'X' && board[5] != 'O') {
            board[5]=computerMark;
            System.out.println("Computer choice is '5'");
            flag=1;
        } else {
            int side[] = {2,6,8,4};
            for(int j=0;j<4;j++) {
                if(board[side[j]] != 'X' && board[side[j]] != 'O') {
                    board[side[j]]=computerMark;
                    System.out.println("My choice is '"+side[j]+"'");
                    flag=1;
                    break;
                }
            }
        }
        return flag;
    }

    private static int computerCorner() {
        int corner[]={7,3,1,9};
        for(int i=0;i<4;i++) {
            if(board[corner[i]] != 'X' && board[corner[i]] != 'O') {
                board[corner[i]]=computerMark;
                System.out.println("Cmputer choice is '"+corner[i]+"'");
                flag=1;
                break;
            }
        }
        return flag;
    }

    //Created board for game
    public static void createBoard(){
        for (int i=1; i<10;i++){
                board[i]=' ';
        }
    }
    //choosing letter for user and computer
    private static void choosingLetter() {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose your mark \n1 for 'X' or Choose 2 for 'O' :");
        int option = s.nextInt();
        switch (option) {
            case 1: userMark = 'X';
                computerMark = 'O';
                break;
            case 2: userMark = 'O';
                computerMark = 'X';
                break;
            default:
                System.out.println("Your input is invalid");
                choosingLetter();
        }
        System.out.println("User mark is : "+userMark+"; Computer mark is : "+computerMark);
    }
    //Display the board to player
    private static void showBoard(){
        System.out.println("---------------");
        System.out.println("| "+board[1]+" | "+board[2]+" | "+board[3]+" |");
        System.out.println("---------------");
        System.out.println("| "+board[4]+" | "+board[5]+" | "+board[6]+" |");
        System.out.println("---------------");
        System.out.println("| "+board[7]+" | "+board[8]+" | "+board[9]+" |");
        System.out.println("---------------");
    }
        //Taking user move to mark on board
    private static void userMove(){
        System.out.println("Enter your move 1-9 : ");
        Scanner sc =new Scanner(System.in);
        int userInput=sc.nextInt();
        if (board[userInput]!='X' && board[userInput]!='O'){
            board[userInput]=userMark;
        }
        else{
            System.out.println("Position already Taken ! please choose another position ");
        }
    }
        //Printing board after mark
    private static void currentBoard(){
        for (int i=1;i<10;i++) {
            if (board[i] !='X'&&board[i] !='O') {
                board[i]=(char) (i+'0');
            }
        }
        showBoard();
    }
    //Tossing to check who will play first
    private static void toss(){
        System.out.println("\nMaking a toss to check who plays first\nChoose 1 for Head or 2 for Tail");
        int option = Utility.getUserInteger();;
        if ( option==1 || option==2 ) {
            int flip = Utility.getRandomInt(2)+1;
            if (flip==1) {
                System.out.println("\nBy tossing Coin it shows HEAD\n");
            } else {
                System.out.println("\nBy tossing Coin it shows TAIL\n");
            }
            if (flip == option) {
                System.out.println("User will start the game\n");
            } else {
                System.out.println("Computer will start the game\n");
                computerFirstTurn();
            }
        } else {
            System.out.println("\nInvalid input Again");
            toss();
        }
    }
    //Taking user Input
    private static void userCall() {
        System.out.println("\nEnter a number from board to make the mark:\n");
        int userNumber = Utility.getUserInteger();
        if (userNumber < 1 || userNumber > 9) {
            currentBoard();
            System.out.println("Your input is Invalid");
            userCall();
        }
    }
    //If computer turn is first
    public static void computerFirstTurn() {
        int computerNumber = Utility.getRandomInt(9)+1;
        board[computerNumber]=computerMark;
        System.out.println("Computer choses '"+computerNumber+"' now user turn");
    }
    //Checking winning condition
    public static int checkWin() {
        for (int i=1;i<9;i++) {
            int win[]= Utility.winArray(i);
            if (board[win[0]]==board[win[1]]&&board[win[1]]==board[win[2]]) {
                flag=1;
            }
        }
        return flag;
    }
    //all possible winning chances
    private static int winBlock(char playerMark, char opponentMark) {
        int winBlock[] = new int[3];
        for (int i=1;i<9;i++) {
            winBlock=Utility.winArray(i);
        }
        if (board[winBlock[0]]==board[winBlock[1]]&&board[winBlock[0]]==playerMark&&board[winBlock[2]]!=opponentMark) {
            flag=winBlock[2];
        } else if (board[winBlock[0]]==board[winBlock[2]]&&board[winBlock[2]]==playerMark&&board[winBlock[1]]!=opponentMark) {
            flag=winBlock[1];
        } else if (board[winBlock[1]]==board[winBlock[2]]&&board[winBlock[2]]==playerMark&&board[winBlock[0]]!=opponentMark) {
            flag=winBlock[0];
        }
        return flag;
    }
    //Checking tie condition
    public static int checkTie() {
        for (int i=1; i<10; i++) {
            if (board[i]=='X' || board[i]=='O') {
                if (i==9) {
                    flag=1;
                }
            }
        }
        return flag;
    }
    //checking for Computer win
    private static int computerWin() {
        int index=winBlock(computerMark,userMark);
        if (index!=0) {
            board[index]=computerMark;
            System.out.println("My choice is '"+index+"'");
            currentBoard();
            System.out.println("I won. Better Luck next time");
            flag=1;
        }
        return flag;
    }
       //making User block from winning
        private static int computerBlock() {
            int index=winBlock(userMark,computerMark);
            if (index!=0) {
                board[index]=computerMark;
                System.out.println("Computer goes for '"+index+"' to block User");
                flag=1;
            }
            return flag;
        }
}
