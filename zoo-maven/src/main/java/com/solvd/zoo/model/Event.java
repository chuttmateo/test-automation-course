package com.solvd.zoo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.solvd.zoo.model.parser.Jaxb.LocalDateTimeAdapter;
import com.solvd.zoo.model.parser.jackson.CustomLocalDateTimeDeserializer;
import com.solvd.zoo.model.parser.jackson.CustomLocalDateTimeSerializer;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@XmlRootElement(name = "event")
@XmlType(propOrder = {"id", "name", "date", "tickets"})
public class Event {
    private Long id;
    private String name;
    private LocalDateTime date;
    private List<Ticket> tickets;

    public Event() {
    }

    public Event(Long id, String name, LocalDateTime date, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }
    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @XmlElement(name = "date")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    @XmlElementWrapper(name = "tickets")
    @XmlElement(name = "ticket")
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(name, event.name) && Objects.equals(date, event.date) && Objects.equals(tickets, event.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, tickets);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", tickets=" + tickets +
                '}';
    }
}
