package laba.homework.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Ticket {

    private static final Logger LOGGER = LogManager.getLogger(Ticket.class);
    private static int ticketsSold;
    private Person person;
    private final int id;

    static {
        LOGGER.info("This print is from a static block in Ticket class");
    }
    public Ticket(Person person) {
        ++ticketsSold;
        this.person = person;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "person=" + person +
                ", id=" + id +
                '}';
    }
}
