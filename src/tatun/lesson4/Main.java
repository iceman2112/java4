package tatun.lesson4;

public class Main {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.push("ivan1", 30);
        rl.push("ivan2", 40);
        rl.push("ivan3", 50);
        rl.push("ivan4", 60);
        System.out.println(rl.toString());
        System.out.println(rl.find("ivan2", 50));
        System.out.println(rl.delete("ivan3", 50));
        //System.out.println(rl.toString());

        RelatedListIterator iterator = rl.getIterator();
       //System.out.println(iterator.getCurrent());
        for (iterator.reset(); !iterator.atEnd(); iterator.nextLink()) {
            System.out.println(iterator.getCurrent());
        }
    }
}
