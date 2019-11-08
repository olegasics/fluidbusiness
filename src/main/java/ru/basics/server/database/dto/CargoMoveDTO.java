package ru.basics.server.database.dto;

import ru.basics.server.database.entity.CargoMove;
import ru.basics.server.database.entity.Waybill;

import java.io.Serializable;


public class CargoMoveDTO {
    CargoMove cargoMove;
    String nameCargo;
    Boolean status;
    Waybill waybill;

    public CargoMoveDTO(CargoMove cargoMove) {
        this.cargoMove = cargoMove;
    }

    public void getNameCargo(CargoMove cargoMove) {
        this.nameCargo = cargoMove.getNameCargo();
    }

    public void getStatus(CargoMove cargoMove) {
        this.status = cargoMove.isStatus();
    }

    public void getWaybill(CargoMove cargoMove) {
        this.waybill = cargoMove.getWaybill();
    }
}
