package ru.basics.server.entity;

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
