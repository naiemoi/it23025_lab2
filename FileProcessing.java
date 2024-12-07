import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessing {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            // Initialize Scanner to read from the input file
            Scanner scanner = new Scanner(new File(inputFilePath));

            // Variables to track the highest value and the sum
            double highestValue = Double.MIN_VALUE; // Initialize to the smallest possible value
            double sum = 0;

            // Read and process numbers from the file
            while (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                sum += number; // Add to sum
                if (number > highestValue) {
                    highestValue = number; // Update highest value
                }
            }
            scanner.close(); // Close the scanner

            // Write the result to the output file
            PrintWriter writer = new PrintWriter(outputFilePath);
            writer.println("Highest Value: " + highestValue);
            writer.println("Sum of All Values: " + sum);
            writer.close(); // Close the writer

            System.out.println("Processing complete. Results written to " + outputFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }
}
