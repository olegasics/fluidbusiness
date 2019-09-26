package ru.basics.server;

import ru.basics.server.user.Auth;
import ru.basics.server.user.Registration;

public class TestServer {

    public static void main(String[] args) {
     Registration reg = new Registration();

//        reg.newAddUser("Олег", 1, "Масло", "omaslo", "edcvfr12!", "89038456869", "Москва");
        //reg.newAddUser("Test", "test", "12!", "123", "Москва");
        Auth auth = new Auth();
       //auth.Authy("omaslo");
      System.out.println(auth.Authy("omaslo", "edcvfr"));
//        System.out.println(auth.Authy("ealekseeva"));



    }
}
