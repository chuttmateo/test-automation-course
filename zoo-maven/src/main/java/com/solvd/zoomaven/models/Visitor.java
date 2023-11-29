package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.VisitorStatus;
import com.solvd.zoomaven.exceptions.WrongNameException;

import java.util.Objects;

public class Visitor extends Person{
    private VisitorStatus visitorStatus;

    public Visitor(String firstName, String lastName, int phoneNumber, VisitorStatus visitorStatus) throws WrongNameException {
        super(firstName, lastName, phoneNumber);
        this.visitorStatus = visitorStatus;
    }

    public VisitorStatus getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(VisitorStatus visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return visitorStatus == visitor.visitorStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorStatus);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorStatus=" + visitorStatus +
                '}';
    }
}
