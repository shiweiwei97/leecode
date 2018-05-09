package leecode;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {

        char[] arr = String.valueOf(N).toCharArray();

        int len = arr.length, p = arr.length;

        for (int i = len - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                p = i - 1;
                arr[i - 1]--;
            }
        }

        for (int i = p + 1; i < len; i++)
            arr[i] = '9';

        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits c = new MonotoneIncreasingDigits();

        System.out.println(c.monotoneIncreasingDigits(10));
        System.out.println(c.monotoneIncreasingDigits(1234));
        System.out.println(c.monotoneIncreasingDigits(332));
        System.out.println(c.monotoneIncreasingDigits(668841));
    }

}
