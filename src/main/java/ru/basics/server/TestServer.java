package ru.basics.server;

import ru.basics.server.entity.cargo.cargoMove.AddNewCargo;
import ru.basics.server.entity.contractor.Contractor;
import ru.basics.server.entity.user.Auth;
import ru.basics.server.entity.user.Registration;

public class TestServer {

    public static void main(String[] args) {
     Registration reg = new Registration();
        AddNewCargo addNewCargo = new AddNewCargo();
//        Contractor contractor = new Contractor();
//        addNewCargo.add("В пути", "DPO", "RU08259", contractor,
//                "переходы", "Синерго, Обнинск");

        reg.newAddUser("Алёна", "kk", "edcvfr12!", "89672908461222", "Москва");
        //reg.newAddUser("Test", "test", "12!", "123", "Москва");
        Auth auth = new Auth();
       //auth.Authy("omaslo");
      //System.out.println(auth.AuthyByLogin("omaslo", "edcvfr12!"));
//        System.out.println(auth.Authy("ealekseeva"));



    }
}
