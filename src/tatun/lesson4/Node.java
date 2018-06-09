package tatun.lesson4;

import java.util.Objects;

public class Node {
    // payload
    public String name;
    public int age;

    // links
    public Node next;
    public Node prev;

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("(Name: %s, age: %d)", name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return age == node.age && name.equals(node.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}