package ru.basics.server;

public class TestServer {

    public static void main(String[] args) {
     Registration reg = new Registration();
//        reg.newAddUser("Олег", 1, "Масло", "omaslo", "edcvfr12!", "89038456869", "Москва");
        reg.newAddUser("Елена", 2, "ealekseeva", "edcvfr12!", "89855661313", "Москва");
        Auth auth = new Auth();
       //auth.Authy("omaslo");
        System.out.println(auth.Authy("omaslo"));
        System.out.println(auth.Authy("ealekseeva"));

    }
}
