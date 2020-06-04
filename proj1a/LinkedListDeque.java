public class LinkedListDeque<type> {
    private static int size;
    private StuffNode sentinel;

    public class StuffNode {
        public type item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(type i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            prev = p;

        }
    }
    //create empty linked list deque
    public  LinkedListDeque() {
        sentinel = new StuffNode(null, null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        int size = 0;
    }

    public int size() {
        return size;
    }


    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null,sentinel,sentinel);
        size = 0;
        for (int i =0; i< other.size(); i++) {
            addLast((type) other.get(i) );
        }

    }

    public  LinkedListDeque(type T) {
        sentinel = new StuffNode(null,sentinel,sentinel);
        size = 1;
        sentinel.next = new StuffNode(T, sentinel, sentinel);
        sentinel.next.next.prev = sentinel.next;
    }

    public void addFirst (type T) {
        sentinel.next = new StuffNode(T, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }


    public void addLast (type T) {
        sentinel.prev = new StuffNode(T, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public type getFirst () {
        return sentinel.next.item;
    }

    public type getLast() {
        return sentinel.prev.item;
    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        StuffNode p = sentinel.next;
        while ( p != sentinel) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public type removeFirst() {
        if (size == 1) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        return sentinel.next.item;
    }
    public type removeLast() {
        if (size == 1) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        return sentinel.prev.item;
    }
    public type get(int n) {
        StuffNode p = sentinel;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        return p.item;
    }

    public type getRecursive (int n) {
        StuffNode x = sentinel.next;
        int i = 1;
        if (x == sentinel) {
            return null;
        }
        if (i == n) {
            return x.item;
        }
        i += 1;
        return getRecursive(n-1);
    }

    public static void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque<>("yes");
        L.addFirst("cool");
        L.addLast("ok");
        System.out.println("the first item is " + L.getFirst());
        System.out.println(size);
        System.out.println("the last item is " + L.getLast());
        L.printDeque();
        System.out.println("the second item is " + L.removeFirst());
        System.out.println("the second to last item is " + L.removeLast());
        System.out.println("the third item is " + L.getRecursive(3));
    }
}
