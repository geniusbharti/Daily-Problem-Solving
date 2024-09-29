class Node{
        int f;
        Set<String> set = new HashSet<>();
        Node prev, next;
        Node(int f){
            this.f=f;
        }
    }
    
    class AllOne {
    Node head;
    Node tail;
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
        head = new Node(-1);
        tail = new Node(-1); 
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int f = node.f;
            node.set.remove(key);
            //adding new node scenario
            Node next  = node.next;
            if(next == tail || next.f != f+1){
                Node newNode = new Node(f+1);
                node.next = newNode;
                next.prev = newNode;
                newNode.prev = node;
                newNode.next = next;
                map.put(key, newNode);
                newNode.set.add(key);
            }else{//not adding new node
                next.set.add(key);
                map.put(key, next);
            }

            //what if it was the last key in node's set
            if(node.set.isEmpty()){
                deleteNode(node);
            }

        }else{
            Node first = head.next;
            if(first == tail || first.f>1){
                Node newNode = new Node(1);
                head.next = newNode;
                newNode.prev = head;
                first.prev = newNode;
                newNode.next = first;
                newNode.set.add(key);
                map.put(key, newNode);
            }else{
                first.set.add(key);
                map.put(key, first);
            }
        }
    }
    
    public void dec(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.set.remove(key);
            int f = node.f;

            Node prev = node.prev;
            if(f==1){
                map.remove(key); //cannot be -ve
            }
            else if(prev == head || prev.f != f-1){
                Node newNode = new Node(f-1);
                newNode.set.add(key);
                map.put(key, newNode);
                prev.next = newNode;
                newNode.prev = prev;
                node.prev = newNode;
                newNode.next = node;
            }else{
                prev.set.add(key);
                map.put(key, prev);
            }

            if(node.set.isEmpty()) {
                deleteNode(node);
            }
        }else{
            return;
        }
    }
    
    public String getMaxKey() {
        if(tail.prev == head) return "";
        return tail.prev.set.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == tail) return "";
        return head.next.set.iterator().next();
        
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
