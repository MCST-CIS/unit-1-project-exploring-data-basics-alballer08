//Name:Albert Zhang
//Date: 11/13/2024
//Program: Bert Cipher
//Purpose:  Protect and secure data using the Bert Cipher

//importing scanner
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //creating scanner
        Scanner reply = new Scanner(System.in);
        //variables
        boolean cont=true;
        String eord;
        String text;
        int shift;
        String encryptedText;
        String decryptedText;
        
        //while loop for error trap
        while (cont){
            //asking if they want to encrypt or decrypt
            System.out.println("Would you like to encrypt or decrypt (e or d)?");
            eord=reply.nextLine();
            //if they want to encrypt
            if (eord.equals("e")){
                //getting text and shift key to encrypt and calling method
                System.out.print("Enter the text to encrypt: ");
                text = reply.nextLine();
         System.out.print("Enter the Caesar shift amount: ");
            shift = reply.nextInt();
            encryptedText = encrypt(text, shift);
            //printing out decrypted text
        System.out.println("Encrypted text: " + encryptedText);
            cont=false;
            }
            //if they want to decrypt
            else if(eord.equals("d")){
                //getting text and shift key to decrypt and calling method
                System.out.print("Enter the text to decrypt: ");
                text = reply.nextLine();
         System.out.print("Enter the Caesar shift amount: ");
            shift = reply.nextInt();
             // Decrypt the text
        decryptedText = decrypt(text, shift);
        //priniting out decrypted text
        System.out.println("Decrypted text: " + decryptedText);
            cont=false;
            }
            //error trap
            else{
                //printing out error and continuing the while loop
                System.out.println("Invalid Input.  Please enter e for encrypt or d for decrypt.");
                continue;
            }
        }
    }
    
        //encrypt function
    public static String encrypt(String text, int shift) {
        //creating stringbuilder
        StringBuilder result = new StringBuilder();
        
        //for loop for every character in the text
        for (char ch : text.toCharArray()) {
            char encryptedChar = ch;

            //atbash encryption
            if (Character.isUpperCase(ch)) {
                encryptedChar = (char) ('Z' - (ch - 'A'));
            } else if (Character.isLowerCase(ch)) {
                encryptedChar = (char) ('z' - (ch - 'a'));
            }
            
            //caesar encryption
            if (Character.isUpperCase(encryptedChar)) {
                encryptedChar = (char) ('A' + (encryptedChar - 'A' + shift) % 26);
            } else if (Character.isLowerCase(encryptedChar)) {
                encryptedChar = (char) ('a' + (encryptedChar - 'a' + shift) % 26);
            }
            //appending to result stringbuilder
            result.append(encryptedChar);
        }
        //returning back to where it is called
        return result.toString();
    }

    //decrypt function
    public static String decrypt(String text, int shift) {
        //string builder
        StringBuilder result = new StringBuilder();
        
        //for loop for every character in text
        for (char ch : text.toCharArray()) {
            char decryptedChar = ch;

            //reversing caesar cipher
            if (Character.isUpperCase(decryptedChar)) {
                decryptedChar = (char) ('A' + (decryptedChar - 'A' - shift + 26) % 26);
            } else if (Character.isLowerCase(decryptedChar)) {
                decryptedChar = (char) ('a' + (decryptedChar - 'a' - shift + 26) % 26);
            }

            //atbash cipher is the same, still technically reversed
            if (Character.isUpperCase(decryptedChar)) {
                decryptedChar = (char) ('Z' - (decryptedChar - 'A'));
            } else if (Character.isLowerCase(decryptedChar)) {
                decryptedChar = (char) ('z' - (decryptedChar - 'a'));
            }
            //appending to result stringbuilder
            result.append(decryptedChar);
        }
        //returning back to where it is called
        return result.toString();
    }
}
