// Library for greater input control

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {
        CommandLineArgs(args);
        RequestUserInput();
        ReadAndWriteFiles();

        // Formatted string output
        String.format("%s and then %d", "String", 123);
    }

    private static void CommandLineArgs(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static void RequestUserInput() {
        // Ask user for input
        Scanner ask_for_input = new Scanner(System.in);
        System.out.println("Please input an integer:");
        double number = ask_for_input.nextInt();
        System.out.println(number);  // -> user's input
    }

    private static void ReadAndWriteFiles() {
        // Read until you hit a \n or \r
        try (BufferedReader input_stream = new BufferedReader(new FileReader("input.txt"))) {
            try (BufferedWriter output_stream = new BufferedWriter(new FileWriter("output.txt"))) {

                String line;
                while ((line = input_stream.readLine()) != null) {
                    int offset = 0;
                    int length = line.length();
                    output_stream.write(line, offset, length);
                    output_stream.newLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printCliDDemoValue() {
        System.out.println(System.getProperty("jarCli"));
    }

    public void printCliFileProperties() {
    		InputStream input = getClass().getResourceAsStream("/app.properties");
    		Properties properties = new Properties();
    		try {
    			properties.load(input);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		System.out.println(properties.getProperty("app.name", "default value"));
    		System.out.println(properties.getProperty("app.version", "another default value"));
    }
}
