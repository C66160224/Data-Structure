import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Input;

        while (true) {
            Input = scanner.nextLine();
            if (Input.equals("exit")) {
                break;
            }
            try {
                checkBracket(Input);
                String postfix = Final(Input);
                System.out.println(postfix);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void checkBracket(String i) {
        StackLink stack = new StackLink();

        for (char ch : i.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    throw new RuntimeException("not found " + checkOpen(ch));
                }

                char openBracket = (char) stack.pop();
                if (!check(openBracket, ch)) {
                    throw new RuntimeException("not found " + checkOpen(ch));
                }
            }
        }

        if (!stack.isEmpty()) {

            char unmatch_Bracket = (char) stack.pop();
            throw new RuntimeException("not found " + checkClose(unmatch_Bracket));
        }
    }

    static boolean check(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    static char checkOpen(char close) {
        switch (close) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default: throw new IllegalArgumentException("not found " +  close);
        }
    }

    static char checkClose(char open) {
        switch (open) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default: throw new IllegalArgumentException("not found " +  open);
        }
    }

    static int checkTheImportance(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String Final(String i) {
        String text = "";
        StackLink stack = new StackLink();

        for (char ch : i.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                text += ch;

            } else if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']') {
                while (!stack.isEmpty() && !check((char) stack.peek(), ch)) {
                    text+=stack.pop();
                }

                stack.pop();

            } else {

                while (!stack.isEmpty() && checkTheImportance(ch) <= checkTheImportance((char) stack.peek())) {
                    text += stack.pop();
                }
                stack.push(ch);
            }

        }
        while (!stack.isEmpty()) {
            text += stack.pop();
        }

        return text.toString();
    }
}