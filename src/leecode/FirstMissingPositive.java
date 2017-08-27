package leecode;

/***
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * @author weiwei
 *
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int N = nums.length;
        for (int i = 0; i < N; i++) {
            // ignore negative numbers, ignore too large numbers
            // if current number is not the right position, switch it
            while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // second pass to find the first number that is not in the right position
        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        // the array happens to be [1..N]
        return N + 1;
    }

    public static void main(String[] args) {

        FirstMissingPositive c = new FirstMissingPositive();

        System.out.println(c.firstMissingPositive(new int[] { 1, 2, 0 }));
        System.out.println(c.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
    }

}
