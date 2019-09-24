package ru.basics.server;

public class TestServer {

    public static void main(String[] args) {
        Registration reg = new Registration();
        reg.newAddUser("Олег", 1, "Масло", "omaslo", "edcvfr12!", "89038456869", "Москва");
        Auth auth = new Auth();
       auth.Authy("omaslo");
    }
}
