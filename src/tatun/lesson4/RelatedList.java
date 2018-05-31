package tatun.lesson4;

public class RelatedList {
    private Node begin;
    private Node end;
    public int size;

    // reset() - to start
    // hasNext()
    // next() - to next elem
    // getCurrent()
    // atEnd() - is at the end
    // insertAfter() - new node after current
    // insertBefore()
    // deleteCurrent()

    RelatedList() {
        begin = null; // add elements
        end = null; // remove elements
        size = 0;

    }

    public boolean isEmpty() {
        return begin == null || end == null;
    }

    public Node getBegin() {
        return begin;
    }

    public void setBegin(Node node) {
        this.begin = node;
    }

    public void push(String name, int age) {
        Node newNode = new Node(name, age);
        newNode.next = begin;

        if (begin == null)
            end = newNode;
        else
            begin.prev = newNode;

        begin = newNode;
        size++;
    }

    public Node pop() {
        if (isEmpty()) return null;
        Node temp = end;
        end.prev.next = null;
        end = end.prev;
        size--;
        return temp;
    }

    public Node find(String name, int age) {
        Node n = new Node(name, age);
        Node current = begin;
        while (!current.equals(n)) {
            if (current.next == null) return null;
            else current = current.next;
        }
        size--;
        return current;
    }

    public Node delete(String name, int age) {
        Node n = new Node(name, age);
        Node current = begin;
        Node previous = begin;
        while (!current.equals(n)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == begin)
            begin = begin.next;
        else
            previous.next = current.next;

        size--;
        return current;
    }

    @Override
    public String toString() {
        Node current = begin;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current.toString());
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public RelatedListIterator getIterator() {
        return new RelatedListIterator(this);
    }
}