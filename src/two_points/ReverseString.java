package two_points;

/**
 * 反转字符串
 */
public class ReverseString {
    public static void main(String[] args) {

        String test = "123456789";
        System.out.println(reverseStr(test));
    }

    public static String reverseStr(String str) {
        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);

    }
}
