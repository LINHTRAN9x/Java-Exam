package demo5.Interface.INewsTets;

public class Main {
    public static void main(String[] args) {

        News n = new News(1,"h1","date","author","content");

        n.inputRate(5);
        n.inputRate(4);
        n.inputRate(4);
        n.inputRate(3);
        n.inputRate(2);

        n.Calculate();

        n.Display();
    }
}
