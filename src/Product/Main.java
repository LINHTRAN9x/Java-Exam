package Product;

public class Main {
    public static void main(String[] agrs){
        Product productOne = new Product(1,"Iphone15",599.99f,90,"MobilePhone");
        Product productTwo = new Product(2,"Lenovo T470s",199.59f,10,"Laptop");
        Product productThree = new Product(3,"Casino r56 watch",39.11f,0,"Watch");


        ////
//        productOne.displayProductInfo();
//        productTwo.displayProductInfo();
//        productThree.displayProductInfo();

        productOne.UpQty(10);
        productOne.downQty(30);
        productOne.changePrice(89.21f);
        productOne.checkStockStatus();
        productOne.displayProductInfo();
    }
}
