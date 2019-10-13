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

        String token = AuthUtils.signIn(new User("Kek", "chebuk"));
        System.out.println(token);

    }
}
