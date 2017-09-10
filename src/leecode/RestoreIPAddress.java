package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * 
 * @author weiwei
 *
 */
public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();

        dfs(res, s, "", 0, 0);

        return res;
    }

    /***
     * DFS to find all solutions
     * 
     * @param res
     *            list to collect solutions
     * @param ip
     *            input IP address
     * @param restored
     *            partial IP restored
     * @param index
     *            restored index
     * @param count
     *            count of restored segments
     */
    private void dfs(List<String> res, String ip, String restored, int index, int count) {
        if (count > 4) return;
        if (count == 4 && index == ip.length()) res.add(restored);

        for (int i = 1; i < 4; i++) {
            if (index + i > ip.length()) break;
            String newSeg = ip.substring(index, index + i);

            if (isValid(newSeg)) dfs(res, ip, restored + newSeg + (count == 3 ? "" : "."), index + i, count + 1);
        }
    }

    private boolean isValid(String seg) {
        int val = Integer.parseInt(seg);
        if (val > 255) return false;
        if (seg.length() == 3 && val < 100) return false;
        if (seg.length() == 2 && val < 10) return false;
        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddress c = new RestoreIPAddress();
        System.out.println(c.restoreIpAddresses("25525511135"));
    }
}
