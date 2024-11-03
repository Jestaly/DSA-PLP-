import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    private int choiceBase;

    public boolean isValidPostfix(String str) {
        int numOperator = 0;
        int numLetter = 0;
        str.replace(" ", "");

        if (str.isEmpty()) {
            System.out.println("No expression Entered.");
            return false;
        }
        if (str.contains("(") || str.contains(")")) {
            System.out.println("Expression shouldn't contain parentheses.");
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*' || str.charAt(i) != '/' ||
                    str.charAt(i) != '+' || str.charAt(i) != '-') {
                if (i == str.length() - 1) {
                    System.out.println("Operand is at the last index.");
                    return false;
                }
            }
            if (str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (i == 0) {
                    System.out.println("Ordering of operator is Invalid");
                    return false;
                }
                numOperator++;
                continue;
            }
            numLetter++;
        }
        if (numOperator == numLetter - 1) {
            return true;
        } else {
            System.out.println("Number of operators does not match with the number of letters.");
            return false;
        }
    }

    public boolean isValidInfix(String str) {
        int numOperator = 0;
        int numLetter = 0;
        str = str.replace(" ", "");

        if (str.isEmpty()) {
            System.out.println("No Expression Entered.");
            return false;
        }
        if ((!str.contains("(") && str.contains(")")) || (str.contains("(") && !str.contains(")"))) {
            System.out.println("Invalid Parentheses.");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                continue;
            }

            if (str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-') {

                if (i == str.length() - 1) {
                    System.out.println("Operator shouldn't be in the last index.");
                    return false;
                }
                if (i == 0) {
                    System.out.println("Operator shouldn't be in the first index.");
                    return false;
                }
                if ((str.charAt(i + 1) == ')' || str.charAt(i + 1) == '+' ||
                        str.charAt(i + 1) == '-' || str.charAt(i + 1) == '*' ||
                        str.charAt(i + 1) == '/') && i != str.length() - 1) {
                    System.out.println("Operator should be followed by an operand or opening parenthesis");
                    return false;
                }
                if (str.charAt(i - 1) == '(' && i != 0) {
                    System.out.println("Operator should be preceded by an operand or closing parenthesis");
                    return false;
                }
                numOperator++;
                continue;
            }
            numLetter++;
        }
        if (numOperator == numLetter - 1) {
            return true;
        } else {
            System.out.println("Number of operators does not match with the number of letters.");
            return false;
        }
    }

    public void backToMenu() {
        System.out.print("Back to Menu? [Y/N]: ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            openMenu();
        } else if (choice.equalsIgnoreCase("N")) {
            switch (choiceBase) {
                case 1:
                    infixToPostfix();
                    break;
                case 2:
                    infixToPrefix();
                    break;
                case 3:
                    postfixToInfix();
                    break;
            }
        } else {
            System.out.println("Enter a valid choice.");
            backToMenu();
        }
    }

    public void infixToPostfix() {
        choiceBase = 1;
        Stack<Character> stackLet = new Stack<>();
        StringBuilder strTemp = new StringBuilder();

        // INFIX TO POSTFIX
        String str = "";
        do {
            System.out.print("Enter Valid Infix Expression: ");
            str = scanner.nextLine();
        } while (!isValidInfix(str));

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '(' || str.charAt(i) == ')')) {
                strTemp.append(str.charAt(i));
                continue;
            }
            if (stackLet.isEmpty() || str.charAt(i) == '(' || stackLet.peek() == '(') {
                stackLet.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == ')') {
                while (stackLet.peek() != '(') {
                    strTemp.append(stackLet.pop());
                }
                stackLet.pop();
                continue;
            }
            if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                while (stackLet.peek() == '*' || stackLet.peek() == '/') {
                    strTemp.append(stackLet.pop());
                    if (stackLet.isEmpty()) {
                        break;
                    }
                }
                stackLet.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                while (stackLet.peek() == '*' || stackLet.peek() == '/' ||
                        stackLet.peek() == '+' || stackLet.peek() == '-') {
                    strTemp.append(stackLet.pop());
                    if (stackLet.isEmpty()) {
                        break;
                    }
                }
                stackLet.push(str.charAt(i));
            }
        }
        while (!stackLet.isEmpty()) {
            strTemp.append(stackLet.pop());
        }
        str = strTemp.toString();
        str = str.replace('(', ' ').replace(')', ' ').replace(" ", "");
        System.out.println(str);

        backToMenu();
    }

    public void infixToPrefix() {
        Stack<Character> stackLet = new Stack<>();
        StringBuilder strTemp = new StringBuilder();

        // INFIX TO PREFIX
        String str = "";
        do {
            System.out.print("Enter Valid Infix Expression: ");
            str = scanner.nextLine();
        } while (!isValidInfix(str));

        str = strTemp.append(str).reverse().toString();
        strTemp.delete(0, strTemp.length());

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '(' || str.charAt(i) == ')')) {
                strTemp.append(str.charAt(i));
                continue;
            }
            if (stackLet.isEmpty() || str.charAt(i) == ')' || stackLet.peek() == ')') {
                stackLet.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == '(') {
                while (stackLet.peek() != ')') {
                    strTemp.append(stackLet.pop());
                }
                stackLet.pop();
                continue;
            }
            if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                stackLet.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                while (!stackLet.isEmpty() && (stackLet.peek() != '+' || stackLet.peek() != '-')) {
                    strTemp.append(stackLet.pop());
                }
                stackLet.push(str.charAt(i));
            }
        }
        while (!stackLet.isEmpty()) {
            strTemp.append(stackLet.pop());
        }
        str = strTemp.reverse().toString();
        str = str.replace('(', ' ').replace(')', ' ').replace(" ", "");
        System.out.println(str);

        backToMenu();
    }

    public void postfixToInfix() {
        choiceBase = 3;
        Stack<String> stackLet = new Stack<>();

        // POSTFIX TO INFIX
        String str = "";
        do {
            System.out.print("Enter Valid Postfix Expression: ");
            str = scanner.nextLine();
        } while (!isValidPostfix(str));

        String charTemp;
        String strTemp = "";
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-')) {
                stackLet.push(Character.toString(str.charAt(i)));
            } else {
                charTemp = stackLet.pop();
                strTemp = "(" + stackLet.pop() + str.charAt(i) + charTemp + ")";
                if (i != str.length() - 1) {
                    stackLet.push(strTemp);
                }
            }
        }
        while (!stackLet.isEmpty()) {
            strTemp += stackLet.pop();
        }
        str = strTemp;
        System.out.println(str);

        backToMenu();
    }

    public void openMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("[1] Infix to Postfix");
            System.out.println("[2] Infix to Prefix");
            System.out.println("[3] Postfix to Infix");
            System.out.println("[0] Stop");
            System.out.print("Enter Choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    infixToPostfix();
                    break;
                case 2:
                    infixToPrefix();
                    break;
                case 3:
                    postfixToInfix();
                    break;
                case 0:
                    System.out.println("Program Stopped.");
                    return;
            }
            in.close();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.openMenu();
    }
}
