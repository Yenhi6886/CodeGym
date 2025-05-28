public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>(10); // Khởi tạo với phần tử đầu là 10
        myList.add(20);
        myList.add(30);
        myList.addFirst(5); // Thêm 5 vào đầu

        myList.printList(); // In ra danh sách

        // Test get
        System.out.println("Phần tử ở vị trí 0: " + myList.get(0)); // 5
        System.out.println("Phần tử ở vị trí 2: " + myList.get(2)); // 20
    }
}

