package leecode;

/***
 * http://oj.leetcode.com/problems/jump-game/
 * 
 * @author weiwei
 * 
 */
public class JumpGame {

    public boolean canJump(int[] A) {

        int reach = 1;

        for (int i = 0; i < reach && reach < A.length; i++) {
            reach = Math.max(reach, i + 1 + A[i]);
        }

        return reach >= A.length;
    }

    public static void main(String[] args) {

        JumpGame c = new JumpGame();

        boolean ret = c.canJump(new int[] { 2, 3, 1, 1, 4 });
        System.out.println(ret);

        ret = c.canJump(new int[] { 3, 2, 1, 0, 4 });
        System.out.println(ret);
    }

}
