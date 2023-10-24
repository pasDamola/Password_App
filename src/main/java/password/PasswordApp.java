package password;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordApp {
    public static void main(String[] args) {
        // NotLongEnough exception
        // NotStrongEnough exception
        String filename = "/Users/oyindamolaoyetunmibi/Desktop/password_app/src/main/java/password/password.txt";
        File file = new File(filename);
        int passwordLength = 8;

        String text = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Read the file
            text = br.readLine();

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error file not found");
        } catch (IOException e) {
            System.out.println("Could not read file");
        }

        try {
            if(text.length() < passwordLength) {
                throw new NotLongEnoughException(text);
           }
          else if(!hasUpperCaseChar(text)) {
              throw  new NoUpperCaseException(text);
            }
          else if(!hasSpecialChars(text)) {
              throw new NoSpecialSymbolException(text);
          }
           else{
                System.out.println("Good password: " + text);
            }



        } catch (NotLongEnoughException e) {
            System.out.println(e.toString());
        } catch (NoUpperCaseException e) {
            System.out.println(e.toString());
        } catch (NoSpecialSymbolException e) {
            System.out.println(e.toString());
        }

    }

    public static boolean hasUpperCaseChar(String password) {
        // Define the regex pattern to match uppercase letters
        Pattern pattern = Pattern.compile("[A-Z]");

        // Create a Matcher object for the input text
        Matcher matcher = pattern.matcher(password);

        // Find and print all uppercase letters in the text
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean hasSpecialChars(String password) {
        // Define the regex pattern to match uppercase letters
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        // Create a Matcher object for the input text
        Matcher matcher = pattern.matcher(password);

        // Find and print all uppercase letters in the text
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}

class NotLongEnoughException extends  Exception {
    String text;

    public NotLongEnoughException(String text) {
        this.text = text;
    }
    public String toString() {
        return "Password Not long enough";
    }
}

class NoUpperCaseException extends Exception {
    String text;

    public NoUpperCaseException(String text) {
        this.text = text;
    }
    public String toString() {
        return "No UpperCase in the password";
    }
}


class NoSpecialSymbolException extends Exception {
    String text;

    public NoSpecialSymbolException(String text) {
        this.text = text;
    }
    public String toString() {
        return "No special symbol in the password";
    }
}




