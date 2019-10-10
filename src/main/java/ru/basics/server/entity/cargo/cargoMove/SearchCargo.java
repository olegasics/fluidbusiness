package ru.basics.server.entity.cargo.cargoMove;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import ru.basics.server.database.dao.DAO;
import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.utils.SessionFactoryUtils;
import ru.basics.server.database.entity.CargoMove;

import java.util.ArrayList;
import java.util.List;

public class SearchCargo {
    CargoMoveDAO cargoMoveDAO = new CargoMoveDAO();
    CargoMove cargoMove;
    List<CargoMove> cargoMovesResult = new ArrayList<>();

    public List<CargoMove> search(String numberProject) {
        try {
           if(cargoMoveDAO.existsProject(numberProject)) {
               //как получить количество совпадений в БД
               while (cargoMove.getNumberProject() != null) {
                   cargoMove = cargoMoveDAO.readNumProject(numberProject);
                   cargoMovesResult.add(cargoMove);
               }
           }
        } catch (HibernateException e ) {
            System.out.println("Ошибка при поиске записи по номеру проекта в движении груза" + e);
        }
        return cargoMovesResult;
    }
}
