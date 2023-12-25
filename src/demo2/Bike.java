package demo2;

public class Bike {
    //public: Use every package
    // default: Use local package
    // protected: Use local package(pakage khác có thể kế thừa được.extends)
    // private: Use only in Class
    private String brand;

    private int year;
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    ////////get & set :truy cap vao ham da set private,tưởng tượng là đã quyền private rồi nhưng tôi sẽ cho phép bạn truy cập vào đc nếu bạn có key get...set thì vẫn vào đc .
    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void showInfo() {
        System.out.println("Brand: "+ brand);
        System.out.println("Year: "+year);
    }

}
