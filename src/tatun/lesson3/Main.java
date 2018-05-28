package tatun.lesson3;

import java.util.Scanner;

public class Main {

    public static String invert(String string) {
        Stack stack = new Stack<Character>(string.length());
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input end for exit.");
            String string = scanner.nextLine();
            if (string.equals("end")) break;

            System.out.println(invert(string));
        }
    }

    public static void testDeque() {
        Deque<Integer> deque = new Deque<>(10);
        deque.insertBegin(1);
        deque.insertBegin(2);
        deque.insertBegin(3);
        deque.insertEnd(4);
        System.out.println(deque);
        System.out.println(deque.getBegin());
        System.out.println(deque.getEnd());
    }

    public static void testPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(5);
        priorityQueue.insert(2);
        priorityQueue.insert(4);
        priorityQueue.insert(3);
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
    }

    public static void main (String[] args) {
        testPriorityQueue();
    }
}
