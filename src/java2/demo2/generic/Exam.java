package java2.demo2.generic;
//Generic : Tham số hóa Kiểu dữ liệu.
public class Exam <N> {
    String name;
    N mark;

    public Exam(String name, N mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public N getMark() {
        return mark;
    }

    public void setMark(N mark) {
        this.mark = mark;
    }

    public <XYZ> void display(XYZ d1,XYZ d2){
        System.out.println(d1+"-"+d2);
    }
}