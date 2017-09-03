package leecode;

import java.util.Stack;

/***
 * https://leetcode.com/problems/simplify-path/description/
 * 
 * @author weiwei
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String p : path.split("/")) {
            if (p.equals("..") && !stack.isEmpty()) stack.pop();
            else if (p.equals("") || p.equals(".") || p.equals("..")) continue;
            else stack.push(p);
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        SimplifyPath c = new SimplifyPath();

        System.out.println(c.simplifyPath("/a/./b/../../c/"));
        System.out.println(c.simplifyPath("/home/"));
        System.out.println(c.simplifyPath("/home//foo/"));
        System.out.println(c.simplifyPath("/../"));
    }
}
