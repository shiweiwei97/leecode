package leecode;

import java.util.Stack;

/***
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * 
 * @author weiwei
 *
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int ret = 0, lastEnd = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastEnd = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        ret = Math.max(ret, i - lastEnd);
                    } else {
                        ret = Math.max(ret, i - stack.peek());
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        LongestValidParentheses c = new LongestValidParentheses();
        String s;

        s = "(()";
        System.out.println(c.longestValidParentheses(s));

        s = ")()())";
        System.out.println(c.longestValidParentheses(s));
    }
}
