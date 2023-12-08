package lineardatastructures;

public class HashMapNode {

    public String key;
    public String value;
    private HashMapNode next;

    public HashMapNode(String key, String value) {
        this.key  = key;
        this.value = value;
        this.next = null;
    }

    public void setNextNode(HashMapNode node) {
        this.next = node;
    }

    public HashMapNode getNextNode() {
        return this.next;
    }

    public void setKeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
