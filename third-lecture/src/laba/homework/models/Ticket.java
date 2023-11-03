package laba.homework.models;

public final class Ticket {

    private static int ticketsSold;
    private Person person;
    private int ticketNumber;

    static {
        System.out.println("This print is from a static block in Ticket class");
    }
    public Ticket(Person person) {
        ++ticketsSold;
        this.person = person;
        ticketNumber = ticketsSold;
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

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "person=" + person +
                ", ticketNumber=" + ticketNumber +
                '}';
    }
}
