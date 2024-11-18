package DSAPLP6;

import java.util.*;

public class Main {
    public Scanner in = new Scanner(System.in);

    Node root;

    Main() {
        this.root = null;
    }

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

    public void showTree() {

    }

    public void insertNode() {

    }

    public void deleteNode() {

    }

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
                break;
        }
    }

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
                showTree();
                break;
            case "I":
                insertNode();
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
    }
}
