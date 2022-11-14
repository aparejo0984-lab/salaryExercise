
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.NumberFormat;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder salaryDetails = readFile();
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(String.valueOf(salaryDetails));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static StringBuilder readFile() {
        StringBuilder processText = new StringBuilder();
        try {
            File fileInput = new File("input.txt");
            Scanner myReader = new Scanner(fileInput);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] inputArray = data.split(":");
                processText.append(processFileSalary(inputArray));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return processText;
    }

    public static StringBuilder processFileSalary(String[] input) {
        Double salary = Double.valueOf(input[1]);
        Double tax = getTax(salary);
        Double computedAnnual = salary - tax;
        Double monthly = monthlySalary(computedAnnual);
        Double biweekly = biWeeklySalary(computedAnnual);

        StringBuilder details = new StringBuilder();
        details.append("\nEmployee: " + input[0]);
        details.append("\nInputed Salary: $" + input[1]);
        details.append("\nTotal tax: $" + formatSalary(tax));
        details.append("\nComputed Annual Salary: $" + formatSalary(computedAnnual));
        details.append("\nMonthly Salary: $" + formatSalary(monthly));
        details.append("\nBiweekly Salary: $" + formatSalary(biweekly));
        details.append("\n=================================================\n");
        return details;
    }

    public static double getTax(Double salary) {
        //26% if the annual salary more than 85k
        if (salary >= 85000.00) {
            return salary * 0.26;
        }
        //18% if the annual salary more than 60k
        else if (salary >= 60000.00 && salary < 85000.00) {
            return salary * 0.18;
        }
        //no tax otherwise
        else {
            return 0.00;
        }
    }

    public static double monthlySalary(Double salary) {
        return salary / 12;

    }
    public static double biWeeklySalary(Double salary) {
        return monthlySalary(salary) / 2;
    }

    public static String formatSalary(Double salary) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(salary);
    }
}