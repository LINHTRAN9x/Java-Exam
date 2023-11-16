package Triangle;

import java.util.Scanner;

public class TamGiac {
    int canhA,canhB,canhC;

    //constructor
    public TamGiac(int canhA,int canhB,int canhC){
        this.canhA = canhA;
        this.canhB = canhB;
        this.canhC = canhC;
    }
    //check isTriangle
    public boolean isTriangle() {
        return (canhA + canhB > canhC) && (canhA + canhC > canhB) && (canhB + canhC > canhA);
    }

    //methods
    public int perimeter(){
            return canhA+canhB+canhC;
    }
    public double area(){
            double s = perimeter() / 2.0;
            return Math.sqrt(s * (s - canhA) * (s - canhB) * (s - canhC));
    }


}
