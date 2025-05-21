import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static String readFromFile() throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader (Constants.FILE_PATH));){
            return reader.readLine();
        }
    }
    public static void writeToFile(String data) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_PATH, true));){
            writer.write(data);
        }
    }
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("No argument given");
            return;
        }
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readFromFile().split(",");
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                System.out.println(readFromFile());
                String employees[] = readFromFile().split(",");
                int index = new Random().nextInt(employees.length);
                System.out.println(employees[index]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newEmployee = args[0].substring(1);
                writeToFile(", " + newEmployee);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readFromFile().split(",");
                String searchEmployee = args[0].substring(1);
                if (Arrays.asList(employees).contains(searchEmployee)) {
                    System.out.println("Employee found!");
                } else {
                    System.out.println("Employee not found.");
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                String[] words = line.split(" ");
                int wordCount = words.length;
                System.out.println(wordCount + " word(s) found " + line.length());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readFromFile().split(",");
                String employeesToUpdate = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(employeesToUpdate)) {
                        employees[i] = "Updated";
                    }
                }
                writeToFile(String.join(",", employees));
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readFromFile().split(",");
                String employeesToDelete = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeesToDelete);
                writeToFile(String.join(",", employeeList));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}