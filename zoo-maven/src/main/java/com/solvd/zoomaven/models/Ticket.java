package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.VisitorStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Ticket {

    private static final Logger LOGGER = LogManager.getLogger(Ticket.class);
    private static int ticketsSold;
    private Person person;
    private final int id;
    private VisitorStatus visitorStatus;

    static {
        LOGGER.info("This print is from a static block in Ticket class");
    }
    public Ticket(Person person, VisitorStatus visitorStatus) {
        ++ticketsSold;
        this.person = person;
        this.visitorStatus = visitorStatus;
        id = ticketsSold;
    }

    public static int getTicketsSold() {
        return ticketsSold;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public VisitorStatus getVisitorStatus() {
        return visitorStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "person=" + person +
                ", id=" + id +
                '}';
    }
}
