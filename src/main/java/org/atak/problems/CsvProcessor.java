package org.atak.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {

  public static void main(String[] args) {
    String inputFile = "src/main/resources/cashstocks.csv";
    String outputFile = "src/main/resources/processed_stocks.csv";

    try {
      processCsvFile(inputFile, outputFile);
      System.out.println("CSV processing completed successfully!");
      System.out.println("Output file: " + outputFile);
    } catch (IOException e) {
      System.err.println("Error processing CSV file: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void processCsvFile(String inputFile, String outputFile) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(inputFile));

    // Create output lines
    List<String> outputLines = new ArrayList<>();

    // Add header
    outputLines.add("symbol,exchange,quantity,type");

    // Process each line (skip header)
    for (int i = 1; i < lines.size(); i++) {
      String line = lines.get(i);
      String processedLine = processLine(line);
      if (processedLine != null) {
        outputLines.add(processedLine);
      }
    }

    // Write to output file
    Files.write(Paths.get(outputFile), outputLines);
  }

  private static String processLine(String line) {
    try {
      // Parse CSV line (handle quoted fields)
      String[] fields = parseCsvLine(line);

      if (fields.length >= 6) {
        String symbol = fields[2].trim(); // Symbol column
        String priceStr = fields[5].trim(); // Price column

        // Remove quotes if present
        symbol = symbol.replace("\"", "");
        priceStr = priceStr.replace("\"", "");

        // Calculate quantity: price / 100, rounded to integer
        double price = Double.parseDouble(priceStr);
        int quantity = (int) Math.round(10000 / price);

        // Ensure minimum quantity of 1
        if (quantity < 1) {
          quantity = 1;
        }

        // Format: symbol,exchange,quantity,type
        return String.format("%s,NSE,%d,MIS", symbol, quantity);
      }
    } catch (Exception e) {
      System.err.println("Error processing line: " + line + " - " + e.getMessage());
    }

    return null;
  }

  private static String[] parseCsvLine(String line) {
    List<String> fields = new ArrayList<>();
    StringBuilder currentField = new StringBuilder();
    boolean inQuotes = false;

    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);

      if (c == '"') {
        inQuotes = !inQuotes;
      } else if (c == ',' && !inQuotes) {
        fields.add(currentField.toString());
        currentField = new StringBuilder();
      } else {
        currentField.append(c);
      }
    }

    // Add the last field
    fields.add(currentField.toString());

    return fields.toArray(new String[0]);
  }
}
