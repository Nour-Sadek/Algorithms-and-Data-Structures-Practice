package lineardatastructures;

public class HashMap {

    public HashMapLinkedList[] hashmap;

    public HashMap(int size) {
        this.hashmap = new HashMapLinkedList[size];
        for (int i = 0; i < size; i++) {
            this.hashmap[i] = new HashMapLinkedList();
        }
    }

    public int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode + Character.codePointAt(key, i);
        }
        hashCode = hashCode % this.hashmap.length;
        return hashCode;
    }

    public void assign(String key, String value) {
        int arrayIndex = this.hash(key);
        HashMapLinkedList list = this.hashmap[arrayIndex];
        if (list.head == null) {
            list.addToHead(key, value);
            return;
        }
        HashMapNode current = list.head;
        while (current != null) {
            if (current.key == key) {
                current.setKeyValue(key, value);
            }
            if (current.getNextNode() == null) {
                current.setNextNode(new HashMapNode(key, value));
                break;
            }
            current = current.getNextNode();
        }
    }

    public String retrieve(String key) {
        int arrayIndex = this.hash(key);
        HashMapNode current = this.hashmap[arrayIndex].head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.getNextNode();
        }
        return null;
    }

}
