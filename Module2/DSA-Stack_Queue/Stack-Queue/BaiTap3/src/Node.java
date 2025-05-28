class Node {
    int data;      // Dữ liệu của nút
    Node link;     //  tham chiếu đến node kế tiếp (sử dụng để tạo danh sách liên kết vòng).

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}
