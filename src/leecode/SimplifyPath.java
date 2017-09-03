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
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String p = arr[i];
            if (p.equals("") || p.equals(".")) continue;
            else if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        return "/" + String.join("/", stack.toArray(new String[] {}));
    }

    public static void main(String[] args) {
        SimplifyPath c = new SimplifyPath();

        System.out.println(c.simplifyPath("/a/./b/../../c/"));
        System.out.println(c.simplifyPath("/home/"));
        System.out.println(c.simplifyPath("/home//foo/"));
        System.out.println(c.simplifyPath("/../"));
    }
}
