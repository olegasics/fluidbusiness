package ru.basics.server;

import ru.basics.server.entity.user.Auth;
import ru.basics.server.entity.user.Registration;

public class TestServer {

    public static void main(String[] args) {
     Registration reg = new Registration();

        reg.newAddUser("Алёна", "фыф", "edcvfr12!", "89672908461", "Москва");
        //reg.newAddUser("Test", "test", "12!", "123", "Москва");
        Auth auth = new Auth();
       //auth.Authy("omaslo");
      System.out.println(auth.Authy("omaslo", "edcvfr12!"));
//        System.out.println(auth.Authy("ealekseeva"));



    }
}
