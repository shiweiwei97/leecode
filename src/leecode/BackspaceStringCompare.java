package leecode;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return finalString(S).equals(finalString(T));
    }

    private String finalString(String s) {
        char[] arr = s.toCharArray();
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '#') {
                if (end > 0) end--;
            } else {
                arr[end++] = arr[i];
            }
        }

        return new String(arr).substring(0, end);
    }

    public static void main(String[] args) {
        BackspaceStringCompare c = new BackspaceStringCompare();

        System.out.println(c.backspaceCompare("ab#c", "ad#c"));
        System.out.println(c.backspaceCompare("ab##", "c#d#"));
        System.out.println(c.backspaceCompare("a##c", "#a#c"));
        System.out.println(c.backspaceCompare("a#c", "b"));

    }

}
