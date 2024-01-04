package java2.demo5.Ma_Hoa;

import org.mindrot.jbcrypt.BCrypt; //libraries ma hoa psw ,hash,

public class Main {
    public static void main(String[] args) {
        String psw = "123456A";
        String salt = BCrypt.gensalt(10);
        System.out.println("Salt: " + salt);
        String hashed = BCrypt.hashpw(psw,salt); //luu vao database gia tri nay cho psw
        System.out.println(hashed);

        //Login- compare password
        String inputPsw = "123456A";
        boolean check = BCrypt.checkpw(inputPsw,hashed);
        if (check) {
            System.out.println("Login successful");
        }else {
            System.out.println("Email or password not correct"); //Bao mat: Luon luon thong bao nhu nay de dam bao hacked k doan dc email.
        }
    }
}
