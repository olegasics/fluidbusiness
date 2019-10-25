package ru.basics.server;

import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.dao.DocumentDAO;
import ru.basics.server.database.dao.DriverDataDAO;
import ru.basics.server.database.entity.Company;
import ru.basics.server.database.entity.Document;
import ru.basics.server.database.entity.DriverData;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();
        DriverDataDAO driverDataDAO = new DriverDataDAO();
        DocumentDAO documentDAO = new DocumentDAO();
//        Company fluidBusiness = new Company("ООО \"Флюид Бизнес\"", "Олег", "89038456869",
//                "omaslo@fluidbusiness.ru", "Москва, Сретенка 12",
//                null, null );
//        companyDAO.create(fluidBusiness);

        // Document invoice = new Document("438", fluidBusiness, new Date());

        Document document = documentDAO.findByField("name", "438").get(0);
        document.setStatus(true);
        documentDAO.update(document);


//
//        Company dl = new Company("Деловые линии", "Митина Елена",
//                "123", "info@delin.ru",
//                "СПБ", " ", " ");
//
//        Company pec = new Company("ПЭК", "Михаил", "89992212",
//                "info@pecom.ru", "Moscow", null, null);
//
//        DriverData driverDataPec = new DriverData("Владимир", "У178УЛ178", "Ford Mustang",
//                "8922", pec);
//
//        DriverData driverDataDl = new DriverData("Олег", "К082СУ159", "Volvo",
//                "124", dl);
//
//        Company dl2 =  companyDAO.findByField("name", "Деловые линии").get(0);
//
//        DriverData driverDataDl2 = new DriverData("Сергей", "323242", "ававав",
//                "13423424", dl2);
//
//
//        driverDataDAO.create(driverDataDl2);
    }
}
