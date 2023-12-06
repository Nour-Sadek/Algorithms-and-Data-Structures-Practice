package lineardatastructures;

public class LinkedList {
    
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public String removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }

    public static boolean swapNodes(LinkedList list, String data1, String data2) {
        Node node1Prev = null;
        Node node2Prev = null;
        Node node1 = list.head;
        Node node2 = list.head;

        // No swap is needed if both nodes hold the same data
        if (data1.equals(data2)) return false;

        // Loop to find node1
        while (node1 != null) {
            if (node1.data.equals(data1)) {
                break;
            }
            node1Prev = node1;
            node1 = node1.getNextNode();
        }

        // Loop to find node2
        while (node2 != null) {
            if (node2.data.equals(data2)) {
                break;
            }
            node2Prev = node2;
            node2 = node2.getNextNode();
        }

        // Either node1 or node2 don't exist in the linked list
        if (node1 == null || node2 == null) return false;

        // If node1Prev is null, then node1 was found to be at the head of the linked list
        if (node1Prev == null) list.head = node2;
        else node1Prev.setNextNode(node2);

        // If node2Prev is null. then node2 was found to be at the head of the linked list
        if (node2Prev == null) list.head = node1;
        else node2Prev.setNextNode(node1);

        Node temp = node1.getNextNode();
        node1.setNextNode(node2.getNextNode());
        node2.setNextNode(temp);

        return true;
    }

    public String printList() {
        String output = "<head> ";
        Node currentNode = this.head;
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }

}
