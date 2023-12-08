package lineardatastructures;

public class HashMapLinkedList {
    public HashMapNode head;

    public HashMapLinkedList() {
        this.head = null;
    }

    public void addToHead(String key, String value) {
        HashMapNode newHead = new HashMapNode(key, value);
        HashMapNode currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String key, String value) {
        HashMapNode tail = this.head;
        if (tail == null) {
            this.head = new HashMapNode(key, value);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new HashMapNode(key, value));
        }
    }

    public void removeHead() {
        HashMapNode removedHead = this.head;
        if (removedHead == null) {
            return;
        }
        this.head = removedHead.getNextNode();
    }
}
