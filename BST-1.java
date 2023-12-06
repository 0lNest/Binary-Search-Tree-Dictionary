
import java.util.Arrays;
/**
* BST class contains methods for binary search tree operations.
*/
public class BST {
static int index;
/**
* Helper method to store inorder traversal of a tree rooted with a given node.
*/
static void storeInorder(Node node, int inorder[]) {
if (node == null)
return;
storeInorder(node.left, inorder);
inorder[index] = node.primaryKey;
index++;
storeInorder(node.right, inorder);
}
/**
* Helper method to count nodes in a binary tree.
*/
static int countNodes(Node root) {
if (root == null)
return 0;
return countNodes(root.left) + countNodes(root.right) + 1;
}
/**
* Helper method to convert a binary tree to a binary search tree.
*/
static void arrayToBST(int[] arr, Node root) {
if (root == null)
return;
arrayToBST(arr, root.left);
root.primaryKey = arr[index];
index++;
arrayToBST(arr, root.right);
}
/**
* Main method to convert a given Binary Tree to BST.
*/
static void binaryTreeToBST(Node root) {
if (root == null)
return;
int n = countNodes(root);
int arr[] = new int[n];
storeInorder(root, arr);
Arrays.sort(arr);
index = 0;
arrayToBST(arr, root);
}
/**
* Helper method to create a new Binary Tree node.
*/
static Node newNode(int primaryKey) {
Node temp = new Node();
temp.primaryKey = primaryKey;
temp.left = null;
temp.right = null;
return temp;
}
/**
* Helper method to print inorder traversal of Binary Tree.
*/
static void printInorder(Node node) {
if (node == null)
return;
printInorder(node.left);
// Print information for each record
System.out.println("Primary Key: " + node.primaryKey);
System.out.println("First Name: " + node.firstName);
System.out.println("Last Name: " + node.lastName);
System.out.println("Street Address: " + node.streetAddress);
System.out.println("City: " + node.city);
System.out.println("State: " + node.state);
System.out.println("ZIP Code: " + node.zip);
System.out.println("E-mail: " + node.email);
System.out.println("Phone Number: " + node.phoneNumber);
System.out.println();
printInorder(node.right);
}
// New Methods for Dictionary Operations
/**
* Helper method to insert a record into the binary search tree.
*/
static Node insertRecord(Node root, Node newNode) {
if (root == null)
return newNode;
if (newNode.primaryKey < root.primaryKey)
root.left = insertRecord(root.left, newNode);
else if (newNode.primaryKey > root.primaryKey)
root.right = insertRecord(root.right, newNode);
return root;
}
/**
* Helper method to search for a record with a specific primary key.
*/
static Node searchRecord(Node root, int primaryKey) {
if (root == null || root.primaryKey == primaryKey)
return root;
if (primaryKey < root.primaryKey)
return searchRecord(root.left, primaryKey);
else
return searchRecord(root.right, primaryKey);
}
/**
* Helper method to delete a record with a specific primary key from the binary
search tree.
*/
static Node deleteRecord(Node root, int primaryKey) {
if (root == null)
return root;
if (primaryKey < root.primaryKey)
root.left = deleteRecord(root.left, primaryKey);
else if (primaryKey > root.primaryKey)
root.right = deleteRecord(root.right, primaryKey);
else {
// Node with only one child or no child
if (root.left == null)
return root.right;
else if (root.right == null)
return root.left;
// Node with two children, get the inorder successor (smallest in the
right subtree)
root.primaryKey = minValue(root.right);
// Delete the inorder successor
root.right = deleteRecord(root.right, root.primaryKey);
}
return root;
}
/**
* Helper method to find the smallest value in a binary search tree.
*/
static int minValue(Node root) {
int minValue = root.primaryKey;
while (root.left != null) {
minValue = root.left.primaryKey;
root = root.left;
}
return minValue;
}
/**
* Helper method to modify the information of a specific record in the binary
search tree.
*/
static Node modifyRecord(Node root, int primaryKey, String newInfo) {
Node targetNode = searchRecord(root, primaryKey);
if (targetNode != null) {
switch (newInfo) {
case "first name":
System.out.print("Enter New First Name: ");
targetNode.firstName = scanner.next();
break;
case "last name":
System.out.print("Enter New Last Name: ");
targetNode.lastName = scanner.next();
break;
// Add cases for other fields
default:
System.out.println("Invalid modification option.");
}
} else {
System.out.println("Record with the given primary key not found.");
}
return root;
}
/**
* Helper method to list the number of records in the binary search tree.
*/
static int countRecords(Node root) {
return countNodes(root);
}
}
