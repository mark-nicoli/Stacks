public class Link_List {
    public static void main (String[]args) {
        linklist lk = new linklist();
        lk.push(2); //you can pass in any value you want as a parameter
        lk.pop(); //for Stacks
        lk.push(2);
        lk.poll(); //for Queues
        lk.add(2);
        lk.poll(); //for Priority Queue
    }

    public static class node {
        int data;
        node next;

        public node(int n) {
            data = n;
        }
    }

    public static class linklist {
        node head;

        public void push(int n) { //add to end of linklist
            if(head == null) { //if list is empty
                head = new node(n); //make new node called head
            }
            else { //loop to end of list
                node temp = head; // temp help carry to the eend value
                while(temp.next != null) { // loop until we reach the end of list
                    temp = temp.next;
                }
                temp.next = new node(n);
            }
        }

        public boolean isEmpty() {
            return (head==null);
        }

        public int poll() { //this gets the first value in the list, for queues
            if(head.next == null) { // if there is only one value in the list just return that value
                node old_head = head;
                head = null;
                return old_head.data;
            }
            else {
                node old_head = head;
                head = head.next;
                return old_head.data;
            }
        }
        public int pop() { // pops the last value in the list , for stacks
            if(head.next == null) {
                node old_head = head;
                head = null;
                return old_head.data;
            }
            else { // this points the previous value of the value that was just popped to null
                node temp = head;
                node prev = head;
                while(temp.next != null) {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next=null;
                return temp.data;
            }
        }

        public void add(int n) { // only for priority queues
            if(head == null) {
                head = new node(n);
            }
            else if(n> head.data) {
                node old_head = head;
                head = new node(n);
                head.next = old_head;
            }
            else {
                node temp = head;
                node prev = head;
                node insert = new node(n);
                while(temp.next != null && temp.data < n) {
                    prev = temp;
                    temp = temp.next;
                }
                if(temp.next == null) {
                    temp.next = insert;
                }
                else {
                    prev.next = insert;
                    insert.next = temp;
                }
            }
        }
    }
}