import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {

       String stringA = args[0];
       String stringB = args[1];
       StringBuilder strEnd = xorString(stringA, stringB);
        System.out.printf(String.valueOf(strEnd));
    }
    public static StringBuilder xorString(String s1, String s2) {
        int length;
        if (s1.length() < s2.length()) {
            length = s1.length();
        } else {
            length = s2.length();
        }
        StringBuilder xorString= new StringBuilder();
        for (int i = 0; i < length; i++) {
            char xoredChar = (char) (s1.charAt(i) ^ s2.charAt(i));
            xorString.append(xoredChar);
        }
        return xorString;
    }
}