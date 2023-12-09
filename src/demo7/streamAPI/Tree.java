package demo7.streamAPI;

public class Tree {
    private int yearOld;

    public Tree(int yearOld) {
        this.yearOld = yearOld;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    public Tree grownUp(){
        System.out.println("Tree grown up..");
        return this;
    }

    public Tree die(){
        System.out.println("Tree ...");
        return this;
    }
}

//Stream - pipeline(xu ly song song),khong thay doi mang goc.
//Collection cau truc du lieu.
