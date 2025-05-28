public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Java");
        list.add("C++");
        list.add("Python");
        list.addFirst("HTML");
        list.addLast("CSS");
        list.add(2, "JavaScript");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        System.out.println("List size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Contains 'Python': " + list.contains("Python"));
        System.out.println("Index of 'C++': " + list.indexOf("C++"));

        list.remove(1);
        System.out.println("After removing index 1, size: " + list.size());

        list.remove("CSS");
        System.out.println("After removing 'CSS', size: " + list.size());

        MyLinkedList<String> cloned = (MyLinkedList<String>) list.clone();
        System.out.println("Cloned list size: " + cloned.size());

        list.clear();
        System.out.println("After clearing list, size: " + list.size());
    }
}
