//File Name EmployeeManager.java
import java.io.*;
import java.util.*;
public class EmployeeManager {
public static void main(String[] args) {
// Check arguments
if (args[0].equals("l")) {
System.out.println("Loading data ...");
try {
BufferedReader r = new BufferedReader(
new InputStreamReader(
new FileInputStream("employees.txt")));
String l = r.readLine();
String e[] = l.split(",");
for (String emp : e) {
System.out.println(emp);
}
} catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].equals("s")) {
System.out.println("Loading data ...");
try {
BufferedReader r = new BufferedReader(
new InputStreamReader(
new FileInputStream("employees.txt")));
String l = r.readLine();
System.out.println(l);
String e[] = l.split(",");
Random rand = new Random();
int idx = rand.nextInt(e.length);
System.out.println(e[idx]);
} catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("+")) {
System.out.println("Loading data ...");
try {
BufferedWriter w = new BufferedWriter(
new FileWriter("employees.txt", true));
String n = args[0].substring(1);
