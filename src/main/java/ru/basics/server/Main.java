package ru.basics.server;

import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.entity.cargo.cargoMove.AddNewCargo;
import ru.basics.server.utils.AuthUtils;

public class Main {
    public static void main(String[] args) {
//        Registration reg = new Registration();
//        AddNewCargo addNewCargo = new AddNewCargo();
        // Contractor contractor = new Contractor("ЯМЦ", "111", "Ярославль");
        //Contractor fb = new Contractor("Флюид Бизнес", "222222", "Москва");
        //CargoMove cargoMove = new CargoMove();

        //     Forwarders DL = new Forwarders("Деловые линии", "222", "Санкт-Петербург", "info@delin.ru");
//        addNewCargo.add("В пути", "DPO", "RU08259", "ЯМЦ",
//                "переходы", "Синерго, Обнинск", "ЯМЦ, Ярославль", "30.09.2019", "31.09.2019",
//                "Деловые Линии", "Флюид Бизнес", "счет №1", "00000", 123, true);

        // reg.newAddUser("Oleg", "test", "edcvfr12!", "896722", "Москва");
        // reg.newAddUser("Nikita", "Nikita11Rus", "12!", "21233", "Москва");
//        Auth auth = new Auth();
//        auth.AuthyByLogin("Nikita11Rus", "12!");
        //System.out.println(auth.AuthyByLogin("omaslo", "edcvfr12!"));
        //        System.out.println(auth.Authy("ealekseeva"));






        AuthUtils.signUp(new User("Kek", "cheburek", "1234"));
        String token = AuthUtils.signIn(new User("Kek", "cheburek"));
        System.out.println(token);

    }
}
