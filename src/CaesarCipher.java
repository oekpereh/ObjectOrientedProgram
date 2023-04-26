/**
 * @Class: Caesar Cipher
 * @author: Olufunmilayo Ekpereh
 * version 1.0
 * Course: ITEC 2140 Spring 2023
 * Written: April 25, 2023
 * This program will implement the Caesar Cipher encryption and decryption algorithm
 * using object-oriented programming principles
 */


import java.util.Scanner;
public class CaesarCipher {
    private int shift;
    public CaesarCipher(int shift) {
        this.shift = shift;
    }
    public String encrypt(String message) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    encryptedMessage += (char) ((c + shift - 65) % 26 + 65);
                } else {
                    encryptedMessage += (char) ((c + shift - 97) % 26 + 97);
                }
            } else {
                encryptedMessage += c;
            }
        }
        return encryptedMessage;
    }

    public String decrypt(String message) {
        String decryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    decryptedMessage += (char) ((c - shift - 65 + 26) % 26 + 65);
                } else {
                    decryptedMessage += (char) ((c - shift - 97 + 26) % 26 + 97);
                }
            } else {
                decryptedMessage += c;
            }
        }
        return decryptedMessage;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to be encrypted or decrypted: ");
        String message = scanner.nextLine();
        System.out.print("Enter an integer key value for encryption or decryption: ");
        int key = scanner.nextInt();
        CaesarCipher cipher = new CaesarCipher(key);
        System.out.print("Enter 'E' to encrypt or 'D' to decrypt: ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("E")) {
            String encryptedMessage = cipher.encrypt(message);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if (choice.equalsIgnoreCase("D")) {
            String decryptedMessage = cipher.decrypt(message);
            System.out.println("Decrypted message: " + decryptedMessage);
        } else {
            System.out.println("Invalid choice. Please choose E or D.");
        }
        scanner.close();
    }
}