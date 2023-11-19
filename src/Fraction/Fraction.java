package Fraction;

import java.util.Scanner;

public class Fraction {
    private int tuSo;
    private int mauSo;

    public Fraction() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public Fraction(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }
    //methods
    // Phương thức nhập phân số
    public void inputFraction() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập tử số: ");
        this.tuSo = scan.nextInt();

        System.out.println("Nhập mẫu số: ");
        int checkMauSo = scan.nextInt();
        if(checkMauSo != 0) {
            this.mauSo = checkMauSo;
        } else{
            System.out.println("Mẫu số không thể là 0");
            return;
        }
    }
    public void inFraction(){
        System.out.println("tử số: "+tuSo + "/ " +"mẫu số: " +mauSo);
    }

    public void rutGonFraction() {
        int rgf = timUocChung(tuSo,mauSo);
        tuSo /= rgf;
        mauSo /= rgf;
    }
    public int timUocChung(int a, int b){
        if (b == 0) {
            return a;
        }
        return timUocChung( b ,a%b);
    }

    public void nghichDaoFraction(){
        int temp = tuSo;
        tuSo = mauSo;
        mauSo = temp;
    }

    public Fraction add(Fraction another){
        int resultTuSo = this.tuSo * another.mauSo + another.tuSo * this.mauSo;
        int resultMauSo = this.mauSo * another.mauSo;
        return new Fraction(resultTuSo,resultMauSo);
    }
    public Fraction sub(Fraction another){
        int resultTuSo = this.tuSo * another.mauSo - another.tuSo * this.mauSo;
        int resultMauSo = this.mauSo * another.mauSo;
        return new Fraction(resultTuSo,resultMauSo);
    }
    public Fraction mul(Fraction another){
        int resultTuSo = this.tuSo  * another.tuSo;
        int resultMauSo = this.mauSo * another.mauSo;
        return new Fraction(resultTuSo,resultMauSo);
    }
    public Fraction div(Fraction another){
        int resultTuSo = this.tuSo * another.mauSo;
        int resultMauSo = this.mauSo * another.tuSo;
        return new Fraction(resultTuSo,resultMauSo);
    }

}
