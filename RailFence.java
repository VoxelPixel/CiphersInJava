/*********
 -*- Made by VoxelPixel
 -*- For YouTube Tutorial
 -*- https://github.com/VoxelPixel
 -*- Support me on Patreon: https://www.patreon.com/voxelpixel
*********/

import java.util.Scanner;

public class RailFence {
    private static Scanner in;
    public static void main(String[] args){
        in = new Scanner(System.in);

        System.out.print("1. Encryption\n2. Decryption\nChoose(1,2): ");
        int choice = in.nextInt();
        in.nextLine();

        if (choice == 1){
            System.out.println("---Encryption---");
            cipherEncryption();

        } else if (choice == 2){
            System.out.println("---Decryption---");
            cipherDecryption();
        } else {
            System.out.println("Incorrect Choice");
        }
    }

    private static void cipherDecryption() {
        System.out.print("Enter message: ");
        String message = in.nextLine();
        // removing white space from message
        message = message.replaceAll("\\s","");
        in.nextLine();

        System.out.print("Enter key(number of rails): ");
        int key = in.nextInt();
        in.nextLine();

        char[][] rail = new char[key][message.length()];
        // matrix
        for (int i = 0; i < key; i++){
            for (int j = 0; j < message.length(); j++) {
                rail[i][j] = '.';
            }
        } // for

        // testing rail
//        for (int i = 0; i < key; i++) {
//            for (int j = 0; j < message.length(); j++) {
//                System.out.print(rail[i][j]);
//            }
//            System.out.println();
//        }

        // putting letters in the matrix in zig-zag
        int row = 0;
        int check = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0){
                rail[row][i] = message.charAt(i);
                row++;
                if (row == key){
                    check = 1;
                    row--;
                }
            } else if(check == 1){
                row--;
                rail[row][i] = message.charAt(i);
                if (row == 0){
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for

        // changing order of rails
        int ordr = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                String temp = rail[i][j] + "";
                if (temp.matches("\\.")){
                    // skipping in case of '.'
                    continue;
                } else {
                    // adding cipher letters one by one diagonally
                    rail[i][j] = message.charAt(ordr);
                    ordr++;
                } // if-else
            } // inner for
        } // for

        // checking message reorder on rails
        System.out.println("Reorder");
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                System.out.print(rail[i][j]);
            }
            System.out.println();
        }

        String decrypText = "";
        check = 0;
        row = 0;
        // converting rails back into a single line message
        for (int i = 0; i < message.length(); i++) {
            if (check == 0){
                decrypText += rail[row][i];
                row++;
                if(row == key){
                    check = 1;
                    row--;
                }
            } else if (check == 1){
                row--;
                decrypText += rail[row][i];
                if(row == 0){
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for

        System.out.println("Decrypted Text: " + decrypText);


    }

    private static void cipherEncryption() {
        System.out.print("Enter message: ");
        String message = in.nextLine();
        // removing white space from message
        message = message.replaceAll("\\s","");
        in.nextLine();

        System.out.print("Enter key(number of rails): ");
        int key = in.nextInt();
        in.nextLine();

        char[][] rail = new char[key][message.length()];
        // matrix
        for (int i = 0; i < key; i++){
            for (int j = 0; j < message.length(); j++) {
                rail[i][j] = '.';
            }
        } // for

//        // testing rail
//        for (int i = 0; i < key; i++) {
//            for (int j = 0; j < message.length(); j++) {
//                System.out.print(rail[i][j]);
//            }
//            System.out.println();
//        }

        // putting letters in the matrix in zig-zag
        int row = 0;
        int check = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0){
                rail[row][i] = message.charAt(i);
                row++;
                if (row == key){
                    check = 1;
                    row--;
                }
            } else if(check == 1){
                row--;
                rail[row][i] = message.charAt(i);
                if (row == 0){
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for

        String encrypText = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                encrypText += rail[i][j];
//                System.out.print(rail[i][j]);
            }
//            System.out.println();
        }

        encrypText = encrypText.replaceAll("\\.","");
        System.out.println("Encrypted Message: " + encrypText);
    }
}
