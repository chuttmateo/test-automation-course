package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.VisitorStatus;
import com.solvd.zoomaven.exceptions.WrongNameException;

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
}
