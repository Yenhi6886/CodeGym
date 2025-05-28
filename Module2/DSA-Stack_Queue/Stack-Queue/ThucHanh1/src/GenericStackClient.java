public class GenericStackClient {

    private static void stackOfStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        stack.push("Five");
        System.out.println("Kích thước ngắn xếp sau hàng loạt hành động thêm: " + stack.size());
        System.out.println("Các phần tử 'pop' từ ngăn xếp: ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n Kích thước ngăn xếp sau hoạt động pop: " + stack.size());
    }

    private static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Kích thước sau khi thêm: " + stack.size());
        System.out.println("Các phân tử pop: ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n Kích thước sau khi hoat động pop: " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("Stack of integers: ");
        stackOfIntegers();
        System.out.println("\nStack of strings: ");
        stackOfStrings();
    }


}
