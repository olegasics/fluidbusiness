package ru.basics.server.entity.cargo.cargoMove;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import ru.basics.server.DAO.DAO;
import ru.basics.server.DAO.cargoMove.CargoMoveDAO;
import ru.basics.server.connection.SessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchCargo {
    SessionFactory sessionFactory = null;
    CargoMove cargoMove = null;
    List<CargoMove> cargoMovesResult = new ArrayList<>();

    public List<CargoMove> search(String numberProject) {
        try {
            sessionFactory = SessionFactoryUtil.getInstance();

            DAO<CargoMove, String> cargoDAO = new CargoMoveDAO(sessionFactory);
            //как получить количество совпадений в БД
            cargoMove = cargoDAO.read(numberProject);
            while(cargoMove.getNumberProject() != null) {
                System.out.println(cargoMove);
                cargoMovesResult.add(cargoMove);
                cargoMove = cargoDAO.read(numberProject);

            }
        } catch (HibernateException e ) {
            System.out.println("Ошибка при поиске записи по номеру проекта в движении груза" + e);
        } finally {
            sessionFactory.close();
        }
        return cargoMovesResult;
    }
}
