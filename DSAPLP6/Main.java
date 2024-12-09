package DSAPLP6;

import java.util.*;

public class Main {
    public Scanner in = new Scanner(System.in);

    Node root;

    // Initializes root as null..
    Main() {
        this.root = null;
    }

    // Basic binary tree node class structure..
    class Node {
        Node right;
        Node left;
        int val;

        Node(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    public void inOrderTraversal() {

    }

    public void preOrderTraversal() {

    }

    public void postOrderTraversal() {

    }

    public void showTree(Node node) {

    }

    // Inserting nodes
    public void insertNode() {
        System.out.print("Enter value to insert: ");
        int val = in.nextInt();
        in.nextLine();
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            System.out.println(root.val);
            return;
        }
        Node current = root;
        while (newNode.val < current.val) {
            if (current.left == null) {
                current.left = newNode;
                System.out.println(current.left.val);
                return;
            }
            current = current.left;
            while (newNode.val > current.val) {
                if (current.right == null) {
                    current.right = newNode;
                    System.out.println(current.right.val);
                    return;
                }
                current = current.right;
            }
        }

        while (newNode.val > current.val) {
            if (current.right == null) {
                current.right = newNode;
                System.out.println(current.right.val);
                return;
            }
            current = current.right;
            while (newNode.val < current.val) {
                if (current.left == null) {
                    current.left = newNode;
                    System.out.println(current.left.val);
                    return;
                }
                current = current.left;
            }
        }
    }

    // Deleting nodes
    public void deleteNode() {
        System.out.print("Enter value to delete: ");
        int val = in.nextInt();
        in.nextLine();
        Node deleteNode = new Node(val);

        // Bunch of deleting code here...
    }

    // Menu for traversals..
    public void traverseMenu() {
        int choice = 0;
        while (true) {
            try {
                System.out.println("TREE TRAVERSAL");
                System.out.println("Menu");
                System.out.println("1 - InOrder");
                System.out.println("2 - PreOrder");
                System.out.println("3 - PostOrder");
                System.out.println("4 - Exit");
                System.out.print("Enter your choice: ");
                choice = in.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;
                }
                System.out.println("Invalid Input. Try Again.");
            } catch (Exception e) {
                in.next();
                System.out.println("Invalid Input. Try Again.");
            }
        }
        switch (choice) {
            case 1:
                inOrderTraversal();
                break;
            case 2:
                preOrderTraversal();
                break;
            case 3:
                postOrderTraversal();
                break;
            case 4:
                System.out.println("Exiting the traversal menu...");
                System.out.println();
                menu();
                break;
        }
    }

    // Main menu of the program..
    public void menu() {
        String choice = "";
        while (true) {
            System.out.println("Menu");
            System.out.println("BST Tree Operations");
            System.out.println("[S] Show");
            System.out.println("[I] Insert");
            System.out.println("[D] Delete");
            System.out.println("[T] Traverse");
            System.out.println("[Q] Quit");
            System.out.print("Enter your choice: ");
            choice = in.nextLine();
            choice = choice.toUpperCase();
            if (choice.equals("S") || choice.equals("I") || choice.equals("D") || choice.equals("T")
                    || choice.equals("Q")) {
                break;
            }
            System.out.println("Wrong Input. Try Again.");
        }

        switch (choice) {
            case "S":
                showTree(root);
                break;
            case "I":
                insertNode();
                menu();
                break;
            case "D":
                deleteNode();
                break;
            case "T":
                traverseMenu();
                break;
            case "Q":
                System.out.println("Exiting the program...");
                break;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();

        // Sample of hard coded nodes to show values.
        System.out.println(main.root.val);
        System.out.println(main.root.left.val);
        System.out.println(main.root.left.left.val);
        System.out.println(main.root.left.right.val);

        // Create a sample tree
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
    }
}
