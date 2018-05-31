package tatun.lesson4;

public class RelatedListIterator {
    private Node current;
    private Node previous;
    private RelatedList list;

    public RelatedListIterator(RelatedList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getBegin();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Node getCurrent() {
        return current;
    }

    public void insertAfter(String name, int age) {
        if (list.isEmpty()) {
            list.push(name, age);
            reset();
        } else {
            Node newNode = new Node(name, age);
            newNode.next = current.next;
            current.next = newNode;
            nextLink();
        }
    }

    public void insertBefore(String name, int age) {
        Node newNode = new Node(name, age);
        if (previous == null) {
            newNode.next = list.getBegin();
            list.setBegin(newNode);
            reset();
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
            current = newNode;
        }
    }

    public Node deleteCurrent() {
        Node result = current;
        if (previous == null) {
            list.setBegin(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) reset();
            else current = current.next;
        }
        return result;
    }
}
