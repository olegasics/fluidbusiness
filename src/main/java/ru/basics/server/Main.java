package ru.basics.server;

import ru.basics.server.database.dao.*;
import ru.basics.server.database.entity.*;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();
        DriverDataDAO driverDataDAO = new DriverDataDAO();
        DocumentDAO documentDAO = new DocumentDAO();
        UserDAO userDAO = new UserDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        WayBillDAO wayBillDAO = new WayBillDAO();
        //Waybill waybill = new Waybill(383, 2, 1.5, 3.14);
//        waybill.addItems("Болт");
//        waybill.addItems("Гайка");
//        waybill.addItems("Шпилька");

//        Company fb = new Company("Флюид Бизнес", "Олег",
//                "89038456869", "omaslo@fluidbusiness.ru",
//                "Сретенка 12", null, null);
//        Company dl = new Company("Деловые линии", "Елена", "8999323432321",
//                "info@delin.ru", "Санкт-Петербург", null, null);
//        Company sinergo = new Company("ООО Синерго", "Михаил", "893232474301",
//                "mih@sinergo.ru", "Самара",
//                "Самара, песчаная 3", "Самара, песчаная 3" );
//        Company russianPump = new Company("ООО КБ Русские насосы", "Евгений Соколов", "89223409832", "asokolov@fluid.ru",
//                "Москва, шоссе фрезе 2 стр 1",
//                "Москва, шоссе фрезе 2 стр 1", "Москва, шоссе фрезе 2 стр 1");
//        companyDAO.create(fb);
//        companyDAO.create(dl);
//        companyDAO.create(sinergo);
//        companyDAO.create(russianPump);
//        waybill.setSendCompany(sinergo);
//        waybill.setForwarder(dl);
//        waybill.setDeliveryCompany(russianPump);
//
//
        Project projectRU06297 = projectDAO.findById(77L);
//        Document document = new Document("77 от 28.10.2019", projectRU06297);
//        document.setCompany(fb);
//        waybill.addInvoice(document);
//        projectDAO.update(projectRU06297);
//        documentDAO.create(document);
//        wayBillDAO.create(waybill);
        Company sinergo = companyDAO.findById(73L);
        sinergo.addProject(projectRU06297);
        projectRU06297.setEndCustomer(companyDAO.findById(84L));
        companyDAO.update(sinergo);
        projectDAO.update(projectRU06297);

        // Waybill waybill1 = wayBillDAO.findById(86L);







//        User user = new User("Олег", "omaslo", "Edc",
//                "omaslo@fluid", "Москва", "89038456869" );
//
//        User userElena = new User("Елена", "ealekseeva", "Edc",
//                "el@fluid", "Москва", "8985" );
//
//        userDAO.create(userElena);
//        projectRU06297.addUser(userElena);
//        projectDAO.update(projectRU06297);
//        Set<User> pro = projectRU06297.getTeam();
//        for(User user : pro) {
//            System.out.println(user.getName());
//        }
//        List<User> users = userDAO.findAllField();
//       for(User user : users) {
//           System.out.println(user.getProjects());
//       }

        //System.out.println(users);

//        projectRU06297.addUser(userOleg);
//        userOleg.addProject(projectRU06297);
//        projectDAO.update(projectRU06297);

//        List<User> users = new ArrayList<>();
//        users.add(userDAO.findById(75L));
//        for(User user : users) {
//            System.out.println(user.getProject().get(0).getNumber());
//        }

        //System.out.println(testProject.getTeam().get(1).getName());

//        Company fluidBusiness = new Company("ООО \"Флюид Бизнес\"", "Олег", "89038456869",
//                "omaslo@fluidbusiness.ru", "Москва, Сретенка 12",
//                null, null );
//        companyDAO.create(fluidBusiness);

        // Document invoice = new Document("438", fluidBusiness, new Date());

//        Document document = documentDAO.findByField("name", "438").get(0);
//        document.setStatus(true);
//        documentDAO.update(document);


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
