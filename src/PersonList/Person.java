package PersonList;

import java.util.Scanner;

public class Person {
    private String name;
    private String sex;
    private String brithday;
    private String address;

    public Person(){}
    public Person(String name, String sex, String brithday, String address) {
        this.name = name;
        this.sex = sex;
        this.brithday = brithday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scan.nextLine();
        System.out.println("Enter sex: ");
        this.sex = scan.nextLine();
        System.out.println("Enter brithday: ");
        this.brithday = scan.nextLine();
        System.out.println("Enter address: ");
        this.address = scan.nextLine();

    }
    public void printInfo(){
        System.out.println(
                "(Name:" + name + ") (Sex:" +sex + ") (Brithday:" + brithday + ") Address:"+ address
        );
    }

}
