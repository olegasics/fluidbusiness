package ru.basics.server.entity;

import java.io.Serializable;

public class PositinUser implements Serializable {

    private static final long serialVersionUID = -4190693986701147617L;

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
