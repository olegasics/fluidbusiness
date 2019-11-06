package ru.basics.server.database.entity;

import java.io.Serializable;

public class PositinUser implements Serializable {

    private static final long serialVersionUID = 2L;

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
