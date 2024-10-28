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
        Stack<Character> stackLet = new Stack<>();
        // INFIX TO POSTFIX
        String str = "A+B*C-D";
        //ABC*+D-
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
                if (stackLet.isEmpty()) {
                    stackLet.push(str.charAt(i));
                    continue;
                }
                if (stackLet.peek() == '(') {
                    stackLet.push(str.charAt(i));
                    continue;
                }
                if (str.charAt(i) == '(') {
                    stackLet.push(str.charAt(i));
                    continue;
                }
                if (str.charAt(i) == ')') {
                    while (stackLet.peek() != '(') {
                        strTemp += stackLet.pop();
                    }
                    stackLet.pop();
                    continue;
                }
//                if(str.charAt(i) == stackLet.peek()){
//                    strTemp += stackLet.pop();
//                    stackLet.push(str.charAt(i));
//                    continue;
//                }

//                if ((str.charAt(i) == '*' || str.charAt(i) == '/') &&
//                (stackLet.peek() != '+' || stackLet.peek() != '-')) {
//                    stackLet.push(str.charAt(i));
//                    continue;
//                }
                if ((str.charAt(i) == '*' || str.charAt(i) == '/') &&
                        (stackLet.peek() == '+' || stackLet.peek() == '-')) {
                    stackLet.push(str.charAt(i));
                    continue;
                }else if((str.charAt(i) == '*' || str.charAt(i) == '/') &&
                        (stackLet.peek() != '+' || stackLet.peek() != '-')){
                    strTemp += stackLet.pop();
                    stackLet.push(str.charAt(i));
                    continue;
                }
                if ((str.charAt(i) == '+' || str.charAt(i) == '-') &&
                        (stackLet.peek() == '*' || stackLet.peek() == '/')) {
                    strTemp += stackLet.pop();
                    stackLet.push(str.charAt(i));
                }else if((str.charAt(i) == '+' || str.charAt(i) == '-') &&
                        (stackLet.peek() == str.charAt(i) || stackLet.peek() == str.charAt(i))) {
                    strTemp += stackLet.pop();
                    stackLet.push(str.charAt(i));
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
