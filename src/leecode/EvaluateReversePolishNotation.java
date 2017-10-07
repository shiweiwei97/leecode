package leecode;

import java.util.Stack;

/***
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * 
 * @author weiwei
 *
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
            case "+":
                stack.push(stack.pop() + stack.pop());
                break;
            case "-":
                stack.push(-stack.pop() + stack.pop());
                break;
            case "*":
                stack.push(stack.pop() * stack.pop());
                break;
            case "/":
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
                break;
            default:
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation c = new EvaluateReversePolishNotation();
        System.out.println(c.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        System.out.println(c.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
    }
}
