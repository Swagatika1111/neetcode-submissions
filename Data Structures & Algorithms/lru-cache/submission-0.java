public class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity,count;
    private Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();

        head=new Node(0,0);
        tail=new Node(0,0);
        head.next = tail;
        tail.next = null;

        head.prev = null;
        tail.prev = head;
        count=0;
    }

    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(map.get(key)!=null){
            Node node = map.get(key);
            int result = node.value;

            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.get(key)!=null){
            Node node = map.get(key);
            node.value=value;

            deleteNode(node);
            addToHead(node);
        }
        else{
            Node node = new Node(key,value);
            map.put(key,node);
            if(count<capacity){
                count++;
                addToHead(node);
            }
            else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}

