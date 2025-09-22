package dslabs;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        String postfix = "35 29 14 + *";
        String infix = postfixToInfix(postfix);
        System.out.println(postfix);
        System.out.println(infix);
    }

    // O(n^2)
    static String postfixToInfix(String postfix) {
        String[] tokens = postfix.split("\\s+"); // O(n)
       
        var st = new Stack<StackThings>(); // O(1)

        for (int ii = 0; ii < tokens.length; ++ii) { // O(n)
            String tt = tokens[ii]; // O(1)

            if (isOperator(tt)) {  // O(1)
                // one thing
                var a1 = st.pop(); // O(1)
                var a2 = st.pop(); // O(1)
                st.push(new ApplyOp(a1, tt, a2));
            }
            else {
                // number
                st.push(new Num(tt)); // O(1)
            }
        }
        
        return st.pop().toString(); // O(...)
    }

    static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/");
    }


    static boolean isNumber(String token) {
        return !isOperator(token);
    }
}

interface StackThing {
    boolean isOperator(); 
    String toString();
}

record Num(String val) implements StackThing {

}

record Op(String op) implements StackThing {

}

record ApplyOp(ArithExpr a1, String op, ArithExpr a2) implements StackThing {
    public String toString() {
        var sb = new StringBuilder(); // O(1)
        sb.add("("); // O(1)
        sb.add(a1.toString()); // ??
        sb.add(op);  // O(1)
        sb.add(a2.toString()); // ??
        sb.add(")");  // O(1)
        return sb.toString();
    }
}


