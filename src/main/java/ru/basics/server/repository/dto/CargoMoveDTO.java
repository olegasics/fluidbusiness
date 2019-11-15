package ru.basics.server.repository.dto;

import ru.basics.server.entity.CargoMove;
import ru.basics.server.entity.Waybill;


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
