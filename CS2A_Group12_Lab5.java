
/** * A program that will Display, Insert Node, Traverse, and Delete a Node from a Binary Tree
 * Group 12
 * Authors: Castillo, Jestaly Joseph A.
 *          Cabug, John Aim Vrezymier T.
 *          
 * Laboratory Exercise 5
 * Date: December 10, 2024
 */
import java.util.*;

public class CS2A_Group12_Lab5 {
    private static Scanner in = new Scanner(System.in);
    private static Node root;
    private static Main main = new Main();

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        menu();
    }

    private static class Main {

        // DEPLOYING NODE TO BE INSERTED
        void insert(Node node) {
            root = insertNode(root, node);
        }

        // INSERT RECURSION
        private Node insertNode(Node root, Node node) {
            int data = node.data;

            if (root == null) {
                root = node;
                return root;
            }

            if (data < root.data) {
                root.left = insertNode(root.left, node);
            }
            if (data > root.data) {
                root.right = insertNode(root.right, node);
            }
            return root;
        }

        // COUNTING TOTAL NUMBER OF NODES
        private int countNodes(Node node) {
            if (node == null) {
                return 0;
            }

            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);

            return leftCount + rightCount + 1;
        }

        // GETS THE HEIGHT OF A BST BASE ON LEFT OR RIGHT SUB TREE USING RECURSION
        private int getHeight(Node node) {
            if (node == null) {
                return 0;
            }
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            return Math.max(left, right) + 1;
        }

        // INORDER OF BST
        private void displayInorder(Node root) {
            if (root != null) {
                displayInorder(root.left);
                System.out.print(root.data + " ");
                displayInorder(root.right);
            }
        }

        // PREORDER OF BST
        private void displayPreorder(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                displayPreorder(root.left);
                displayPreorder(root.right);
            }
        }

        // POSTORDER OF BST
        private void displayPostorder(Node root) {
            if (root != null) {
                displayPostorder(root.left);
                displayPostorder(root.right);
                System.out.print(root.data + " ");
            }
        }

        // SEARCH DATA OF A NODE
        private boolean searchNode(Node root, int data) {
            if (root == null) {
                return false;
            } else if (root.data == data) {
                return true;
            }

            if (root.data > data) {
                return searchNode(root.left, data);
            }
            return searchNode(root.right, data);
        }

        // I STOPPED HERE
        private void remove(int data) {
            if (searchNode(root, data)) {
                removeHelper(root, data);
                System.out.println();
                text("Succesfully Deleted " + data, false);
            } else {
                System.out.println();
                System.out.println(data + " is not in the tree");
            }
        }

        private Node removeHelper(Node root, int data) {
            if (root == null) {
                return root;
            } else if (data < root.data) {
                root.left = removeHelper(root.left, data);
            } else if (data > root.data) {
                root.right = removeHelper(root.right, data);
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.right != null) {
                    root.data = successor(root);
                    root.right = removeHelper(root.right, root.data);
                } else {
                    root.data = predecessor(root);
                    root.left = removeHelper(root.left, root.data);
                }
            }
            return root;
        }

        private int successor(Node root) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }

        private int predecessor(Node root) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root.data;
        }

        private int height(Node node) {
            if (node == null)
                return 0;
            return 1 + Math.max(height(node.left), height(node.right));
        }

        private void drawNode(List<String> output, List<String> linkAbove, Node node, int level, int minPos,
                char linkChar) {
            if (node == null)
                return;

            int h = output.size();
            String SP = " ";

            if (minPos < 0) {
                String extra = " ".repeat(-minPos);
                for (int i = 0; i < output.size(); i++)
                    if (!output.get(i).isEmpty())
                        output.set(i, extra + output.get(i));
                for (int i = 0; i < linkAbove.size(); i++)
                    if (!linkAbove.get(i).isEmpty())
                        linkAbove.set(i, extra + linkAbove.get(i));
            }

            if (level < h - 1)
                minPos = Math.max(minPos, output.get(level + 1).length());
            if (level > 0)
                minPos = Math.max(minPos, output.get(level - 1).length());
            minPos = Math.max(minPos, output.get(level).length());

            if (node.left != null) {
                String leftData = SP + node.left.data + SP;
                drawNode(output, linkAbove, node.left, level + 1, minPos - leftData.length(), 'L');
                minPos = Math.max(minPos, output.get(level + 1).length());
            }

            int space = minPos - output.get(level).length();
            if (space > 0)
                output.set(level, output.get(level) + " ".repeat(space));

            String nodeData = SP + node.data + SP;
            output.set(level, output.get(level) + nodeData);

            space = minPos + SP.length() - linkAbove.get(level).length();
            if (space > 0)
                linkAbove.set(level, linkAbove.get(level) + " ".repeat(space));
            linkAbove.set(level, linkAbove.get(level) + linkChar);

            if (node.right != null)
                drawNode(output, linkAbove, node.right, level + 1, output.get(level).length(), 'R');
        }

        private void draw() {
            int h = height(root);
            List<String> output = new ArrayList<>(h);
            List<String> linkAbove = new ArrayList<>(h);

            for (int i = 0; i < h; i++) {
                output.add("");
                linkAbove.add("");
            }

            drawNode(output, linkAbove, root, 0, 20, ' ');

            for (int i = 1; i < h; i++) {
                for (int j = 0; j < linkAbove.get(i).length(); j++) {
                    if (linkAbove.get(i).charAt(j) != ' ') {
                        int size = output.get(i - 1).length();
                        if (size < j + 1)
                            output.set(i - 1, output.get(i - 1) + " ".repeat(j + 1 - size));
                        int jj = j;
                        if (linkAbove.get(i).charAt(j) == 'L') {
                            while (output.get(i - 1).charAt(jj) == ' ')
                                jj++;
                            for (int k = j + 1; k < jj - 1; k++) {
                                char[] chars = output.get(i - 1).toCharArray();
                                chars[k] = '_';
                                output.set(i - 1, new String(chars));
                            }
                        } else if (linkAbove.get(i).charAt(j) == 'R') {
                            while (output.get(i - 1).charAt(jj) == ' ')
                                jj--;
                            for (int k = j - 1; k > jj + 1; k--) {
                                char[] chars = output.get(i - 1).toCharArray();
                                chars[k] = '_';
                                output.set(i - 1, new String(chars));
                            }
                        }
                        char[] chars = linkAbove.get(i).toCharArray();
                        chars[j] = '|';
                        linkAbove.set(i, new String(chars));
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                if (i > 0)
                    System.out.println(linkAbove.get(i));
                System.out.println(output.get(i));
            }
        }

    }

    private static void showTree() {
        clearScreen();
        lineHeader();
        text("Binary Search Tree", true);
        lineHeader();
        int height = main.getHeight(root);
        int nodeCount = main.countNodes(root);

        if (root == null) {
            System.out.println();
            text("Tree is Empty!", false);
            anyKey();
            menu();
        } else {
            System.out.println();
            main.draw();
            System.out.println();
            System.out.println("   Number of Nodes in the Tree: " + nodeCount);
            System.out.println("   Height of the Tree: " + height);
            anyKey();
            menu();
        }
    }

    private static void insertNode() {
        clearScreen();
        lineHeader();
        text("Inserting Node", true);
        lineHeader();
        String rep;

        System.out.printf("%n%45s", "Enter Value to Insert: ");
        checkNum();
        int val = in.nextInt();

        if (main.searchNode(root, val)) {
            System.out.println();
            text("Duplicate Value! Please Enter a New Value!", false);
        } else if (!main.searchNode(root, val)) {
            main.insert(new Node(val));
            System.out.println();
            text("Succesfully Inserted " + val, false);
        }
        in.nextLine();
        do {
            System.out.printf("%n%30s", "Try Again [y/n] :");
            rep = in.nextLine();

            if (rep.equalsIgnoreCase("y")) {
                insertNode();
                break;
            } else if (rep.equalsIgnoreCase("n")) {
                menu();
                break;
            } else {
                text("Please Enter only [y/n]!", false);
            }
        } while (!rep.equalsIgnoreCase("n"));
    }

    private static void deleteNode() {
        clearScreen();
        lineHeader();
        text("Deleting Node", true);
        lineHeader();

        if (root == null) {
            System.out.println();
            text("Tree is Empty!", false);
            anyKey();
            menu();
        } else {
            System.out.printf("%n%45s", "Enter Value to Delete: ");
            checkNum();
            int delVal = in.nextInt();
            main.remove(delVal);
            in.nextLine();
            System.out.println();
            lineHeader();
            text("Press Enter to Show Tree", true);
            lineHeader();
            in.nextLine();
            showTree();
        }
    }

    private static void traverseTree() {
        try {
            traverseTable();
            String choice;
            do {
                System.err.printf("%n%30s", "Enter Your Choice : ");
                choice = in.nextLine();
                if (choice.equals("1")) {
                    inorder();
                } else if (choice.equals("2")) {
                    preorder();
                } else if (choice.equals("3")) {
                    postorder();
                } else if (choice.equals("4")) {
                    menu();
                    in.close();
                    break;
                } else {
                    text("Please Enter only from Selection!", false);
                }
            } while (!choice.equals("4"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inorder() {
        clearScreen();
        lineHeader();
        text("Inorder Traversal", true);
        lineHeader();
        System.out.println();
        if (root == null) {
            text("Tree is Empty!", false);
            anyKey();
            traverseTable();
        } else {
            System.out.println();
            main.draw();
            System.out.println();
            System.out.printf("%15s Inorder Traversal : ", "");
            main.displayInorder(root);
            System.out.println();
            anyKey();
            traverseTree();
        }
    }

    private static void postorder() {
        clearScreen();
        lineHeader();
        text("Postorder Traversal", true);
        lineHeader();
        System.out.println();
        if (root == null) {
            text("Tree is Empty!", false);
            anyKey();
            traverseTable();
        } else {
            System.out.println();
            main.draw();
            System.out.println();
            System.out.printf("%15s Postorder Traversal : ", "");
            main.displayPostorder(root);
            System.out.println();
            anyKey();
            traverseTree();
        }
    }

    private static void preorder() {
        clearScreen();
        lineHeader();
        text("Preorder Traversal", true);
        lineHeader();
        System.out.println();
        if (root == null) {
            text("Tree is Empty!", false);
            anyKey();
            traverseTable();
        } else {
            System.out.println();
            main.draw();
            System.out.println();
            System.out.printf("%15s Preorder Traversal : ", "");
            main.displayPreorder(root);
            System.out.println();
            anyKey();
            traverseTree();
        }
    }

    private static void menu() {
        try {
            menuTable();
            System.out.println();
            String ans;
            do {
                System.out.printf("%50s", "Enter First Letter of Your Choice : ");
                ans = in.nextLine();
                if (ans.equalsIgnoreCase("S")) {
                    showTree();
                    break;
                } else if (ans.equalsIgnoreCase("I")) {
                    insertNode();
                    break;
                } else if (ans.equalsIgnoreCase("D")) {
                    deleteNode();
                    break;
                } else if (ans.equalsIgnoreCase("T")) {
                    traverseTree();
                    break;
                } else if (ans.equalsIgnoreCase("q")) {
                    stop();
                    break;
                } else {
                    text("Invalid Selection! Please Enter only within Selection\n", false);
                }
            } while (!ans.equalsIgnoreCase("q"));
        } catch (Exception e) {
            text("Error: " + e, false);
        }
    }

    private static void lineHeader() {
        System.out.print(
                "+⋆꙳•̩̩͙❅*̩̩͙‧͙ ‧͙*̩̩͙❆ ͙͛ ˚₊⋆⋆꙳•̩̩͙❅*̩̩͙‧͙ ‧͙*̩̩͙❆ ͙͛ ˚₊⋆⋆꙳•̩̩͙❅*̩̩͙‧͙ ‧͙*̩̩͙❆ ͙͛ ˚₊⋆⋆꙳•̩̩͙❅*̩̩͙‧͙ ‧͙*̩̩͙❆ ͙͛ ˚₊⋆⋆꙳•̩̩͙❅*̩̩͙‧͙ ‧͙*̩̩͙❆ ͙͛ ˚₊⋆⋆꙳•̩̩͙❅*̩̩͙‧͙ ‧͙*̩̩͙❆ \n");
    }

    private static void text(String title, boolean hasBorder) {
        int width = 60;
        String text = title;
        int padding = (width - text.length()) / 2;

        if (hasBorder) {
            System.out.printf("˚₊⋆%" + padding + "s%s%" + padding + "s%n", "", title, "˚₊⋆");
        } else {
            System.out.printf("%" + padding + "s%s%" + padding + "s%n", "", title, "");
        }
    }

    private static void menuTable() {
        clearScreen();
        lineHeader();
        text("Menu", true);
        text("BST Operations", true);
        lineHeader();
        text("", true);

        text("", true);
        text("[S] Show", true);
        text("   [I] Insert ", true);
        text("  [D] Delete", true);
        text("    [T] Traverse", true);
        text("", true);
        text("[Q] Quit", true);
        text("", true);
        text("", true);
        text("", true);
        text("", true);
        lineHeader();
    }

    private static void traverseTable() {
        clearScreen();
        lineHeader();
        text("Tree Traversal", true);
        text("Menu", true);
        lineHeader();
        text("", true);

        text("[1] - Inorder ", true);
        text("[2] - Preorder", true);
        text("  [3] - Postorder ", true);
        text(" [4] - Exit     ", true);
        text("", true);
        lineHeader();

    }

    private static void anyKey() {
        System.out.println();
        lineHeader();
        text("Press Enter To Continue!", true);
        lineHeader();
        in.nextLine();
    }

    private static void stop() {
        clearScreen();
        lineHeader();
        text("Program Terminated", true);
        lineHeader();

        System.out.println("\n");
        System.out.println("                                 |");
        System.out.println("                               \\ ' /");
        System.out.println("                             -- (*) --");
        System.out.println("                                >*<");
        System.out.println("                               >0<@<");
        System.out.println("                              >>>@<<*");
        System.out.println("                             >@>*<0<<<");
        System.out.println("                            >*>>@<<<@<<");
        System.out.println("                           >@>>0<<<*<<@<");
        System.out.println("                          >*>>0<<@<<<@<<<");
        System.out.println("                         >@>>*<<@<>*<<0<*<");
        System.out.println("           \\*/          >0>>*<<@<>0><<*<@<<");
        System.out.println("       __\\\\U//__     >*>>@><0<<*>>@><*<0<<");
        System.out.println("       |\\\\ | | \\|    >@>>0<*<0>>@<<0<<<*<@<<");
        System.out.println("       | \\| | (UU) >((*))_>0><*<0><@<<<0<*<");
        System.out.println("       |\\ \\| || / //||.*.*.*.|>>@<<*<<@>><0<<<");
        System.out.println("  dsa  |\\\\_|_|&&_// ||*.*.*.*|_\\\\db//_");
        System.out.println("       \"\"\"\"|'.'.'.|~~|.*.*.*|     ___|");
        System.out.println("           |'.'.'.|   ^^^^^^|____|>>>>>>|");
        System.out.println("           ~~~~~~         '\"\"\"\"`------'");
    }

    private static void checkNum() {
        while (!in.hasNextInt()) {
            System.out.printf("%n%50s", "Invalid Input! Please Enter an Integer!  :  ");
            in.next();
        }
    }

    private static void clearScreen() {
        System.out.print('\u000c');
    }
}
