public class Main {
    public static void main(String[] args) {
        //Đảo ngược mảng số nguyên
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int value : arr) {
            System.out.print(value + " ");
        }
        ReverseTheElement.reverseArray(arr);
        for(int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("");

        //Đảo ngược chuỗi
        String sentence = "The quick brown fox jumps over the lazy dog";
        System.out.println(sentence);
        ReverseTheElement.reverseWord(sentence);
        System.out.print(sentence);
    }
}
