package DSAPLP5;

import java.util.*;
public class Menu {
    Scanner scanner = new Scanner(System.in);

    private int choiceBase;

    public boolean isValidInfix(String str){
        int numOperator = 0;
        int numLetter = 0;
        str = str.replace(" ","");

        if(str.isEmpty()) {
            System.out.println("No Expression Entered.");
            return false;
        }
        if (!str.contains("(") && str.contains(")") || str.contains("(") && !str.contains(")")) {
            System.out.println("Invalid Parentheses.");
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(' || str.charAt(i) == ')'){

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
                if((str.charAt(i + 1) == ')' || str.charAt(i + 1) == '+'  ||
                        str.charAt(i + 1) == '-' || str.charAt(i + 1) == '*' ||
                        str.charAt(i + 1) == '/') && i != str.length() - 1){
                    System.out.println("Operator should be followed by an operand or opening parenthesis");
                    return false;
                }
                if(str.charAt(i - 1) == '(' && i != 0){
                    System.out.println("Operator should be preceded by an operand or closing parenthesis");
                    return false;
                }
                numOperator++;
                continue;
            }
            numLetter++;
        }
        if(numOperator == numLetter - 1){
            return true;
        }else{
            System.out.println("Correct number of operators does not match with the number of letters.");
            return false;
        }
    }

    public void backToMenu(){
        System.out.print("Back to Menu? [Y/N]: ");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("Y")){
            openMenu();
        } else if (choice.equalsIgnoreCase("N")) {
            switch (choiceBase){
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
        }
        else{
            System.out.println("Enter a valid choice.");
            backToMenu();
        }
    }

    public void infixToPostfix(){
        choiceBase = 1;
        Stack<Character> stackLet = new Stack<>();
        StringBuilder strTemp = new StringBuilder();

        // INFIX TO POSTFIX
        String str = "";
        do{
            System.out.print("Enter Valid Expression: ");
            str = scanner.nextLine();
        }while (!isValidInfix(str));

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
                while(stackLet.peek() == '*' || stackLet.peek() == '/'){
                    strTemp.append(stackLet.pop());
                    if(stackLet.isEmpty()){
                        break;
                    }
                }
                stackLet.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                while(stackLet.peek() == '*' || stackLet.peek() == '/' ||
                        stackLet.peek() == '+' || stackLet.peek() == '-'){
                    strTemp.append(stackLet.pop());
                    if(stackLet.isEmpty()){
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
        str = str.replace('(', ' ').replace(')',' ').replace(" ","");
        System.out.println(str);

            backToMenu();
    }
        public void infixToPrefix() {
            Stack<Character> stackLet = new Stack<>();
            StringBuilder strTemp = new StringBuilder();
            //INFIX TO PREFIX
            String str = "";
            do{
                System.out.print("Enter Valid Expression: ");
                str = scanner.nextLine();
            }while (!isValidInfix(str));

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
            str = str.replace('(', ' ').replace(')',' ').replace(" ","");
        System.out.println(str);

        backToMenu();
    }
    public void postfixToInfix(){
        choiceBase = 3;
        Stack<String> stackLet = new Stack<>();

        while(true){
            System.out.print("Enter the PostFix Expression: ");
            String str = scanner.nextLine();
            // STACK IMPLEMENTATION
            // INFIX: A / B * C + D * E
            // POSTFIX: AB/C*DE*+
            //String str = "AB/C*DE*+";
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
            str = strTemp;
            System.out.println(str);

            backToMenu();
        }

    }

    public void openMenu(){

        while(true){
            Scanner in = new Scanner(System.in);
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
        }


    }
    public static void main(String[] args){
        Menu menu = new Menu();
        menu.openMenu();
    }
}
