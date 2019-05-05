package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import leecode.common.TreeNode;

/***
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * 
 * @author weiweish
 *
 */
public class MostFrequentSubtreeSum {

    private Map<Integer, Integer> map = new HashMap<>();

    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        max = 0;

        dfs(root);

        List<Integer> res = new ArrayList<>();
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);

        if (!map.containsKey(node.val)) {
            map.put(node.val, 1);
        } else {
            map.put(node.val, map.get(node.val) + 1);
        }

        max = Math.max(max, map.get(node.val));

        return node.val;
    }

    public static void main(String[] args) {

        MostFrequentSubtreeSum c = new MostFrequentSubtreeSum();

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-5);

        root.left = node1;
        root.right = node2;

        System.out.print(Arrays.toString(c.findFrequentTreeSum(root)));
    }
}
