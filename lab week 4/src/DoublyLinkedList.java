public class DoublyLinkedList implements Collection {

    class node {
        Object data;
        node link;
        node plink;

        node(Object d, node l, node pl) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private node head;
    private node tail;
    private int count;

    public DoublyLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    @Override
    public void add(Object value) {
        node newnode = new node(value, null, tail);
        if (tail != null) {
            tail.link = newnode;
        }
        tail = newnode;
        if (head == null) {
            head = newnode;
        }
        count++;
    }


    @Override
    public void add(int index, Object value) {
        if (index > size() || index < 0){
            throw new IndexOutOfBoundsException("out");
        }
        if (index == count + 1) {
            add(value);

        }else if(index == 0){
            node newnode = new node(value , head , null);
            head.plink = newnode ;
            head = newnode ;
            count++;

        }else {
            node current = head;
            for (int i = 0; i < index; i++) {
                current = current.link ;

            }
            node newnode = new node(value , current , current.plink);
            current.plink.link = newnode;
            current.plink = newnode ;
            count++;

        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        node current = head;
        for (int i = 0 ; i < index ; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        node current = head;
        for (int i = 0 ; i < index ; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current.plink != null) {
                    current.plink.link = current.link;
                } else {
                    head = current.link;
                }
                if (current.link != null) {
                    current.link.plink = current.plink;
                } else {
                    tail = current.plink;
                }
                count--;
            }
            current = current.link;
        }
    }

    @Override
    public boolean find(Object value) {
        node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.link;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        node current = head ;

        System.out.print("[");
        while (current != null){
            System.out.print(current.data);
            if(current.link != null){
                System.out.print(", ");
            }
            current = current.link ;
        }

        System.out.println("]");
    }


    public void show_backward() {
        node current = tail ;
        System.out.print("[");
        while (current != null){
            System.out.print(current.data);
            if (current.plink != null){
                System.out.print(", ");
            }
            current = current.plink ;
        }
        System.out.println("]");
    }
}