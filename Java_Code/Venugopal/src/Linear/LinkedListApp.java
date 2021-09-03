package Linear;

public class LinkedListApp {

    public static void main(String[] args) {
        LinkedList<Integer> intLL = new LinkedList<>();
        intLL.addFront(5); // 5 is auto-boxed to Integer 5

        LinkedList<String> strLL = new LinkedList<>();
        strLL.addFront("5");
    }
}
