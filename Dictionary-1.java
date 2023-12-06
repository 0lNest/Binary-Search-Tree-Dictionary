
import java.util.Scanner;
/**
* Programmer: Oleksandr
* Class: CS 145
* Date: 11/30/2023
* Assignment: Lab 6: Binary Search Tree Dictionary
* Reference Materials: https://www.geeksforgeeks.org/binary-tree-to-binary-search-
tree-conversion/?ref=rp, course material.
* Purpose: This program implements a dictionary using a binary search tree to
manage employee, customer, or member records.
* It provides functionality for adding, deleting, modifying, and looking
up records, along with various
* traversal options. ASCII art is included for visual appeal.
* Time: ~6h 20m
*/
public class Dictionary {
public static void main(String args[]) {
Node root = null;
Scanner scanner = new Scanner(System.in);
BST.binaryTreeToBST(root);
while (true) {
System.out.println("Dictionary Menu:");
System.out.println("1. Add Record");
System.out.println("2. Delete Record"); // Add other menu options
System.out.println("3. Modify Record");
System.out.println("4. Lookup Records");
System.out.println("5. List Number of Records");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
switch (choice) {
case 1:
addRecord(root, scanner);
break;
// Add cases for other operations
default:
System.out.println("Invalid choice. Please enter a valid
option.");
}
}
}
/**
* Method to add a new record to the dictionary.
*/
static void addRecord(Node root, Scanner scanner) {
System.out.println("Adding a New Record:");
System.out.print("Enter Primary Key: ");
int primaryKey = scanner.nextInt();
// Check if the primary key already exists
if (BST.searchRecord(root, primaryKey) != null) {
System.out.println("Record with the given primary key already exists.
Cannot add duplicate records.");
return;
}
Node newNode = new Node();
newNode.primaryKey = primaryKey;
// Prompt user for information to create a new record
System.out.print("Enter First Name: ");
newNode.firstName = scanner.next();
System.out.print("Enter Last Name: ");
newNode.lastName = scanner.next();
System.out.print("Enter Street Address: ");
newNode.streetAddress = scanner.next();
System.out.print("Enter City: ");
newNode.city = scanner.next();
System.out.print("Enter State: ");
newNode.state = scanner.next();
System.out.print("Enter ZIP Code: ");
newNode.zip = scanner.next();
System.out.print("Enter E-mail: ");
newNode.email = scanner.next();
System.out.print("Enter Phone Number: ");
newNode.phoneNumber = scanner.next();
// Insert the new record into the binary search tree
root = BST.insertRecord(root, newNode);
System.out.println("Record added successfully.");
}
/**
* Dictionary class for managing records using a binary search tree.
*/
public class Dictionary {
public static void main(String args[]) {
Node root = null;
Scanner scanner = new Scanner(System.in);
BST.binaryTreeToBST(root);
while (true) {
System.out.println("Dictionary Menu:");
System.out.println("1. Add Record");
System.out.println("2. Delete Record");
System.out.println("3. Modify Record");
System.out.println("4. Lookup Records"); // Add other menu options
System.out.println("5. List Number of Records");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
switch (choice) {
case 1:
addRecord(root, scanner);
break;
case 2:
System.out.print("Enter Primary Key to Delete: ");
int deleteKey = scanner.nextInt();
root = BST.deleteRecord(root, deleteKey);
System.out.println("Record deleted successfully.");
break;
case 3:
System.out.print("Enter Primary Key to Modify: ");
int modifyKey = scanner.nextInt();
System.out.print("Choose Field to Modify (e.g., first name,
last name): ");
String modifyField = scanner.next().toLowerCase();
root = BST.modifyRecord(root, modifyKey, modifyField);
System.out.println("Record modified successfully.");
break;
case 4:
System.out.println("Choose Traversal Order for Lookup:");
System.out.println("1. Pre-order");
System.out.println("2. In-order");
System.out.println("3. Post-order");
int traversalChoice = scanner.nextInt();
switch (traversalChoice) {
case 1:
// Implement pre-order lookup
break;
case 2:
// Implement in-order lookup
break;
case 3:
// Implement post-order lookup
break;
default:
System.out.println("Invalid traversal option.");
}
break;
case 5:
System.out.println("Number of Records: " +
BST.countRecords(root));
break;
case 6:
System.out.println("Exiting program.");
System.exit(0);
default:
System.out.println("Invalid choice. Please enter a valid
option.");
}
}
}
}
