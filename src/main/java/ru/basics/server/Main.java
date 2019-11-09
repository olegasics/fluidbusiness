package ru.basics.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.database.dao.WayBillDAO;
import ru.basics.server.database.entity.CargoMove;
import ru.basics.server.database.entity.Waybill;

@ComponentScan
@SpringBootApplication
@EntityScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}
