package ru.basics.server.entity.cargo.cargoMove;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import ru.basics.server.database.dao.DAO;
import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.utils.SessionFactoryUtils;
import ru.basics.server.database.entity.CargoMove;

public class AddNewCargo {
    private SessionFactory sessionFactory;

    public void add(String status, String RP, String numberProject, String endCustomer, String nameCargo,
                    String placeLoading, String placeUnloading, String dateSend, String dateDelivery,
                    String forwarder, String payerForCargo, String invoce, String trackNumber,
                    int TTNNumber, boolean upd) {
        try {
            sessionFactory = SessionFactoryUtils.getInstance();
            DAO<CargoMove, String> newAddCargo = new CargoMoveDAO(sessionFactory);
            CargoMove cargoMove = new CargoMove();

            cargoMove.setStatusMove(status);
            cargoMove.setManager(RP);
            cargoMove.setNumberProject(numberProject);
            cargoMove.setEndCustomer(endCustomer);
            cargoMove.setNameCargo(nameCargo);
            cargoMove.setPlaceLoading(placeLoading);
            cargoMove.setPlaceUnloading(placeUnloading);
            cargoMove.setDateSend(dateSend);
            cargoMove.setDateDelivery(dateDelivery);
            cargoMove.setForwarder(forwarder);
            cargoMove.setContractor(payerForCargo);
            cargoMove.setInvoce(invoce);
            cargoMove.setTrackNumber(trackNumber);
            cargoMove.setTTNNumber(TTNNumber);
            cargoMove.setUpd(upd);
            newAddCargo.create(cargoMove);
        } catch (HibernateException e) {
            System.out.println("Ошибка при записи новой перевозки в движение груза" + e);
        }

    }
}
