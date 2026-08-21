import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    static int invalidLines = 0;
    public static void main(String[] args) {
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores(filename);

        double avg = calculateAverage(scores);

        int highest = Integer.MIN_VALUE; 
        int lowest = Integer.MAX_VALUE;

        for (int number : scores){
                if (number > highest){
                    highest = number;
                }
                if (number < lowest){
                    lowest = number;
                }
        }
        if (scores.isEmpty()){
            highest = 0;
            lowest = 0;
        }

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int number : scores){
            if (number >= 90){
                countA++;
            } else if (number >= 80){
                countB++;
            } else if (number >= 70) {
                countC++;
            } else if (number >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        int[] gradeBands = {countA, countB, countC, countD, countF};

        String outputFile = "report.txt";

        writeReport(scores, avg, highest, lowest, invalidLines, gradeBands, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null){
                line = line.trim();

                if (line.isEmpty()){
                    invalidLines++;
                    continue;
                }

                try {
                    int number = Integer.parseInt(line);
                    scores.add(number);
                } catch (NumberFormatException e){
                    invalidLines++;
                    System.out.println("The following error was encountered when parsing the value: " + e);
                }
            }
        }
        catch (IOException e){
            System.out.println("The following error was encountered when reading the data: " + e);
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()){
            return 0.0;
        } else {
            double total = 0.0;
            for (int number : scores){
                total += number;
            }

            return total / scores.size();
        }


    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low, int invalidLines, int[] gradeBands,
                                   String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write("=== Grade Analysis Report ===");
            writer.newLine();

            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            writer.write(String.format("Invalid lines skipped: %d%n", invalidLines));
            writer.newLine();

            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));
            writer.newLine();

            writer.write("Grade distribution:");
            writer.newLine();
            writer.write(String.format("A (90-100): %d%n", gradeBands[0]));
            writer.write(String.format("B (80-89): %d%n", gradeBands[1]));
            writer.write(String.format("C (70-79): %d%n", gradeBands[2]));
            writer.write(String.format("D (60-69): %d%n", gradeBands[3]));
            writer.write(String.format("F (below 60): %d%n", gradeBands[4]));

            // Print report to terminal
            System.out.println("=== Grade Analysis Report ===");
            System.out.println("Total scores processed: " + scores.size());
            System.out.println("Invalid lines skipped: " + invalidLines);
            System.out.println();

            System.out.println(String.format("Average score: %.2f", avg));
            System.out.println("Highest score: " + high);
            System.out.println("Lowest score: " + low);
            System.out.println();

            System.out.println("Grade distribution:");
            System.out.println("A (90-100): " + gradeBands[0]);
            System.out.println("B (80-89): " + gradeBands[1]);
            System.out.println("C (70-79): " + gradeBands[2]);
            System.out.println("D (60-69): " + gradeBands[3]);
            System.out.println("F (below 60): " + gradeBands[4]);
            }
        catch (IOException e){
            System.out.println("The following error was encountered when writing the report: " + e);
        }
    }
} 