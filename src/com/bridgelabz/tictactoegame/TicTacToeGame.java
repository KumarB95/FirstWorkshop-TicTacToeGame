package com.bridgelabz.tictactoegame;

import java.util.Scanner;

/**
 * Program for TicTacToe Game
 * Author: Navalkumar
 * Date: 23/09/2021
 */

public class TicTacToeGame {
    static char[] board = new char[10];
    static char userMark, computerMark;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Program !");
        //creating board
        createBoard();
        //choosing letter and determining player and computer letter
        choosingLetter();
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
        System.out.println("Choose your mark \n 1 for 'X' or Choose 2 for 'O' :");
        int option = s.nextInt();
        switch (option) {
            case 1: userMark = 'X';
                computerMark = 'O';
                System.out.println("User mark is : "+userMark+"; Computer mark is : "+computerMark);
                break;
            case 2: userMark = 'O';
                computerMark = 'X';
                System.out.println("User mark is : "+userMark+"; Computer mark is : "+computerMark);
                break;
            default:
                System.out.println("Your input is invalid");
                choosingLetter();
        }
    }
}
