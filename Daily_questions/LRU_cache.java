import java.util.HashMap;

public class LRU_cache {
    class LRUCache {
        class Node{
            int key;
            int val;
            Node prev;
            Node next;
            Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        int capacity;
        HashMap<Integer, Node> map = new HashMap<>();
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.next = head;
        }
        
        public int get(int key) {
            int res = -1;
            if (map.containsKey(key)){
                Node temp = map.get(key);
                res = temp.val;
                map.remove(key);
                delete(temp);
                add(temp);
                map.put(key, head.next); 
            }
            return res;
        }
        
        public void put(int key, int value) {
            if (map.containsKey(key)){
                Node curr = map.get(key);
                map.remove(key);
                delete(curr);
            }
            if (map.size() == capacity){
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            add(new Node(key, value));
            map.put(key, head.next);
        }
        private void add(Node node){
            Node temp = head.next;
    
            node.next = temp;
            node.prev = head;
    
            head.next = node;
            temp.prev = node;
        }
        private void delete(Node node){
            Node prevNode = node.prev;
            Node nextNode = node.next;
    
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }
}
