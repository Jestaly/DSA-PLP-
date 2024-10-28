package DSAPLP5;

import java.util.*;
public class Menu {
    Scanner scanner = new Scanner(System.in);

    private int choiceBase;

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
                case 4:
                    prefixToInfix();
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
        Stack<Character> stack = new Stack<>();

        // INFIX TO POSTFIX
        String str = "A+B*C";
        String strTemp = "";
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '(' || str.charAt(i) == ')')) {
                strTemp += str.charAt(i);
                continue;
            }
            if (str.charAt(i) == '*' || str.charAt(i) == '/' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(i));
                    continue;
                }
                if (stack.peek() == '(') {
                    stack.push(str.charAt(i));
                    continue;
                }
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                    continue;
                }
                if (str.charAt(i) == ')') {
                    while (stack.peek() != '(') {
                        strTemp += stack.pop();
                    }
                    stack.pop();
                    continue;
                }
                if (str.charAt(i) == stack.peek()) {
                    strTemp += stack.pop();
                    stack.push(str.charAt(i));
                    continue;
                }
                if ((str.charAt(i) == '*' || str.charAt(i) == '/') &&
                        (stack.peek() == '+' || stack.peek() == '-')) {
                    stack.push(str.charAt(i));
                    continue;
                }
                if ((str.charAt(i) == '+' || str.charAt(i) == '-') &&
                        (stack.peek() == '*' || stack.peek() == '/')) {
                    strTemp += stack.pop();
                    stack.push(str.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            strTemp += stack.pop();
        }
        str = strTemp;
        System.out.println(str);

        backToMenu();
    }
    public void infixToPrefix(){
        choiceBase = 2;

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
    public void prefixToInfix(){
        choiceBase = 4;

    }
    public void openMenu(){

        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("[1] Infix to Postfix");
            System.out.println("[2] Infix to Prefix");
            System.out.println("[3] Postfix to Infix");
            System.out.println("[4] Prefix to Infix");
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
                case 4:
                    prefixToInfix();
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