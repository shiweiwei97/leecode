package leecode;

public class ConvertNumberHexadecimal {

    public String toHex(int num) {

        if (num == 0) return "0";

        char[] bs = new char[8];
        int s = 0;
        for (int i = 7; i >= 0; i--) {
            int n = num & 15;
            bs[i] = n < 10 ? (char) (n + '0') : (char) ((n - 10) + 'a');
            if (n > 0) s = i;
            num >>= 4;
        }

        return new String(bs).substring(s);
    }

    public static void main(String[] args) {

        ConvertNumberHexadecimal c = new ConvertNumberHexadecimal();

        for (int i = -100; i <= 100; i++) {
            System.out.println(c.toHex(i));
        }
    }
}
