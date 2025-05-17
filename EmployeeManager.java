//File Name EmployeeManager.java

import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Method to read employees from the file
    private static String[] readEmployeesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                return line.split(",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[0]; // Return an empty array if file is empty or an error occurs
    }

    // Method to write employees to the file
    private static void writeEmployeesToFile(String[] employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"))) {
            writer.write(String.join(",", employees));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java EmployeeManager <option>");
            System.out.println("Options:");
            System.out.println("  line - List all employees");
            System.out.println("  s - Show a random employee");
            System.out.println("  +<name> - Add a new employee");
            System.out.println("  ?<name> - Search for an employee");
            System.out.println("  c - Count the number of words in the file");
            System.out.println("  u<name> - Update an employee's name to 'Updated'");
            System.out.println("  d<name> - Delete an employee");
            return;
        }
        // Check arguments
        if (args[0].equals("line")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            for (String employee : employees) {
                System.out.println(employee.trim());
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            Random random = new Random();
            int randomIndex = random.nextInt(employees.length);
            System.out.println(employees[randomIndex].trim());
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            String newEmployee = args[0].substring(1);
            List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
            employeeList.add(newEmployee);
            writeEmployeesToFile(employeeList.toArray(new String[0]));
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            String searchName = args[0].substring(1);
            boolean found = false;
            for (String employee : employees) {
                if (employee.trim().equals(searchName)) {
                    System.out.println("Employee found!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            int wordCount = 0;
            for (String employee : employees) {
                if (!employee.trim().isEmpty()) {
                    wordCount++;
                }
            }
            System.out.println(wordCount + " word(s) found.");
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            String updateName = args[0].substring(1);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].trim().equals(updateName)) {
                    employees[i] = "Updated";
                }
            }
            writeEmployeesToFile(employees);
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            String[] employees = readEmployeesFromFile();
            String deleteName = args[0].substring(1);
            List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
            employeeList.removeIf(employee -> employee.trim().equals(deleteName));
            writeEmployeesToFile(employeeList.toArray(new String[0]));
            System.out.println("Data Deleted.");
        }
    }
}
