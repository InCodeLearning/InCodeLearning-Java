package org.incodelearning.basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href=https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html>java tutorial link</a>.
 */
public class Variables {

    int instanceVar; //instance variable, non-static field
    /* The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
       number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found, then an
       InvalidClassException is thrown.
     */
    final static long serialUID = 1L; //static field, class variables

    public static void print4VarTypes() {
        // local variable
        String[] varTypes = {"instance variable (non-static field)", "class variable (static field)", "local varible (only " +
                "visible in the method)", "parameters"};
        System.out.println(Arrays.toString(varTypes));
    }

    public static void naming() {
        /* an unlimited-length sequence of Unicode letters and digits.
           beginning with a letter, the dollar sign "$", or the underscore character "_"
           the dollar sign and underscore characters, by convention, are never used at all.
         */
        int s试试 = 0;
        System.out.println("s试试 = " + s试试);
        int gearRatio = 1; // camel case
    }

    public static void keywords(File file){
        try (Scanner scan = new Scanner(file)) {
            int count = 0;
            while (scan.hasNext()) {
                System.out.printf("%-20s", scan.next());
                count++;
                if (count % 5 == 0) System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("error finding file.");
        }
    }

    public static void main(String[] args) {
        //args is parameter of main method, parameters are always classified as variables not fields
        //generally speaking, variables > fields
        //members = a type's fields + methods + nested types
        final String keywordFile = "org/incodelearning/java-keywords.txt";
        File file = new File(Variables.class.getClassLoader().getResource(keywordFile).getFile());
        print4VarTypes();
        naming();
        keywords(file);
    }
}
