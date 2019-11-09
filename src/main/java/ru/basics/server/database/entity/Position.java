package ru.basics.server.database.entity;

import java.io.Serializable;

public enum Position implements Serializable {
    LOGIST,
    MANAGER,
    DIRECTOR,
    SECRETARY,
    INGENER;

    public String getPosition() {
        return this.name();
    }
}
