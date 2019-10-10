package ru.basics.server;

import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.CargoMove;
import ru.basics.server.database.entity.User;
//import ru.basics.server.entity.cargo.cargoMove.AddCargo;
//import ru.basics.server.entity.cargo.cargoMove.SearchCargo;
import ru.basics.server.utils.AuthUtils;

public class Main {
    public static void main(String[] args) {

//        addCargo.add("В пути", "DPO", "RU06297", "ЯМЦ",
//               "переходы", "Синерго, Обнинск", "ЯМЦ, Ярославль", "30.09.2019", "31.09.2019",
//               "Деловые Линии", "Флюид Бизнес", "счет №1", "00000", 123, true);

        String token = AuthUtils.signIn(new User("Kek", "cheburek"));
        CargoMoveDAO cargoMoveDAO = new CargoMoveDAO();
        System.out.println(token);

    }
}
