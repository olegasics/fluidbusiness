package ru.basics.server;

import ru.basics.server.entity.cargo.cargoMove.AddNewCargo;
import ru.basics.server.entity.contractor.Contractor;
import ru.basics.server.entity.contractor.forwarders.Forwarders;
import ru.basics.server.entity.user.Auth;
import ru.basics.server.entity.user.Registration;

public class TestServer {

    public static void main(String[] args) {
     Registration reg = new Registration();
        AddNewCargo addNewCargo = new AddNewCargo();
     Contractor contractor = new Contractor("ЯМЦ", "111", "Ярославль");
     Contractor fb = new Contractor("Флюид Бизнес", "222222", "Москва");

     Forwarders DL = new Forwarders("Деловые линии", "222", "Санкт-Петербург", "info@delin.ru");
     addNewCargo.add("В пути", "DPO", "RU08259", contractor,
             "переходы", "Синерго, Обнинск", "ЯМЦ, Ярославль", "30.09.2019", "31.09.2019",
            DL, fb, "счет №1", "00000", 123, true);

       // reg.newAddUser("Oleg", "test", "edcvfr12!", "896722", "Москва");
       // reg.newAddUser("null", "null", "12!", "233232", "Москва");
        Auth auth = new Auth();
      //auth.AuthyByLogin("null", "12!");
      //System.out.println(auth.AuthyByLogin("omaslo", "edcvfr12!"));
//        System.out.println(auth.Authy("ealekseeva"));

    }
}
