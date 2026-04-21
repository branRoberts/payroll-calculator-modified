package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculatorModified {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the name of the file you would like to process: ");
        String fileName = input.nextLine();

        System.out.println("Please enter the name of the file you would like to create: ");
        String fileOutput = input.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            FileWriter file = new FileWriter(fileOutput);
            BufferedWriter writer = new BufferedWriter(file);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                /*System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay()); */

                writer.write(employee.getEmployeeId() + "|" + employee.getName() + "|" + employee.getGrossPay() + "\n");
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}