package ru.basics.server;

import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.dao.DriverDataDAO;
import ru.basics.server.database.entity.Company;
import ru.basics.server.database.entity.DriverData;

public class Main {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();
        DriverDataDAO driverDataDAO = new DriverDataDAO();

        Company dl = new Company("Деловые линии", "Митина Елена",
                "123", "info@delin.ru",
                "СПБ", " ", " ");

        Company pec = new Company("ПЭК", "Михаил", "89992212",
                "info@pecom.ru", "Moscow", null, null);

        DriverData driverDataPec = new DriverData("Владимир", "У178УЛ178", "Ford Mustang",
                "8922", pec);

        DriverData driverDataDl = new DriverData("Олег", "К082СУ159", "Volvo",
                "124", dl);

        companyDAO.create(dl);
        companyDAO.create(pec);
        driverDataDAO.create(driverDataDl);
        driverDataDAO.create(driverDataPec);
    }
}
