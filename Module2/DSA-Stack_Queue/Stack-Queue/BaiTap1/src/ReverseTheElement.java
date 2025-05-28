import java.util.Stack;

public class ReverseTheElement {

    // Đảo ngược mảng số nguyên sử dụng Stack
    public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
            stack.push(value);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    //Đảo từ trong chuỗi
    public static String reverseWord(String sentence) {
        Stack<String> stack = new Stack<>();
        String[] words = sentence.trim().split("\\s+");
        for(String word : words) {
            stack.push(word);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString().trim();
    }

}
