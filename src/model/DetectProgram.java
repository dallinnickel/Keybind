package model;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class DetectProgram {


    /**
     *
     * @param Name A string of the name of the program you wish to see if it is running.
     * @return True if program is running or False if it isn't
     */
    public static boolean isRunning(String Name) throws IOException {

        ProcessBuilder processbuildier = new ProcessBuilder("tasklist.exe");
        Process process = processbuildier.start();
        String tasks = toString(process.getInputStream());


        return tasks.contains(Name);
    }

    /**
     * used for isRunning method to format Inputsteam into usable format.
     * @param input unformatted string from InputStream
     * @return the formatted string.
     */
    public static String toString(InputStream input){
        Scanner scan = new Scanner(input, "UTF-8").useDelimiter("\\A");
        String output = scan.hasNext() ? scan.next() : "";
        scan.close();

        return output;
    }

}
