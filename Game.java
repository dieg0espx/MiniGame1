package Labs.MiniProject1;

import java.io.*;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        // Getting the Random Word
        double num = Math.random() * 100;
        int num2 = (int) num;
        String RandomWord = "";

        try {
            File f = new File("src/Labs/MiniProject1/cities.txt");
            Scanner in = new Scanner(f);
            for (int i = 0; i < num2; i++) {
                in.nextLine();
                if (i == num2 - 1) {
                    RandomWord = in.nextLine();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


        // Printing the RandomWord
       System.out.println(RandomWord);

        // Converting the RandomWorld into Char Array
        char[] charword = RandomWord.toCharArray();

        // Creating arrays
        int[] numcharword = new int[charword.length]; // the same array than 'charword' but in numbers
        char[] wrongletterss = new char[10]; // array of 10 elements collecting all wrong letters

        int wrong = 0; // variable that counts wrong letters

        System.out.println("Here is the Question !");

        // printing the arrray of the question
        for (int i = 0; i < charword.length; i++) {
            if (charword[i] == ' ') {
                numcharword[i] = 3;
                System.out.print(" ");
            } else {
                System.out.print("_");
            }
        }

        // elements for the scanner
        String letra;
        Scanner teclado = new Scanner(System.in);

        boolean right = false; // Flag variable that check if the typed letter is rigt

        while (wrong < 10) {

            System.out.println();
            System.out.print("Guess a Letter : ");
            letra = teclado.nextLine(); // read what the user type

            while (letra.equals("")){
                System.out.print("Guess a Letter : ");
                letra = teclado.nextLine(); // read what the user type
            }

            while (letra.length() > 1) {
                System.out.print("Guess a Letter : ");
                letra = teclado.nextLine(); // read what the user type
                
                while (letra.equals("")){
                    System.out.print("Guess a Letter : ");
                    letra = teclado.nextLine(); // read what the user type
                }

            }

            char charletra = letra.charAt(0); // Convert the String letra into char to can be comparate

            // Cheking if the letter wich was typing is in the Charword
            for (int i = 0; i < charword.length; i++) {
                if (charletra == charword[i]) {
                    numcharword[i] = 1;
                    right = true;
                }
            }

            // What happens if the typed letter is wrong
            if (!right) {
                for (int i = 0; i < wrongletterss.length; i++) {
                    if (charletra != wrongletterss[i]) {
                        wrongletterss[wrong] = charletra;
                        wrong = wrong + 1;
                        break;
                    }
                }
            }

            // Printing the array whit the correct letters
            for (int i = 0; i < charword.length; i++) {
                if (numcharword[i] == 1) {
                    System.out.print(charword[i]);
                }
                if (numcharword[i] == 3) {
                    System.out.print(" ");
                }
                if (numcharword[i] == 0) {
                    System.out.print("_");
                }
            }

            // Print the wrong times
            System.out.println();
            System.out.print(" You have guessed (" + wrong + ") wrong letters :");
            for (int i = 0; i <wrongletterss.length ; i++) {
                System.out.print(" ");
                if (wrongletterss[i] != 0) {
                    System.out.print(wrongletterss[i]);
                }
            }
                right = false; // change the flag status

                // Checking if all the array is complete
                int allcorrect = 0;
                for (int i = 0; i < numcharword.length; i++) {
                    if (numcharword[i] == 1 || numcharword[i] == 3) {
                        allcorrect = allcorrect + 1;
                    }
                }

                if(wrong == 10){
                    System.out.println();
                    System.out.println("You lose !! ");
                    System.out.println(" :(");
                    System.out.println("The Word was : " + RandomWord);
                }

                // if all the array is completed exit !
                if (allcorrect == numcharword.length) {
                    wrong = 10;
                    System.out.println();
                    System.out.println("You Win!!");
                    System.out.println("You have guessed " + RandomWord + " correctly!");
                }
            }

    }
    }


