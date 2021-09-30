package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0]; // new Ticket  - это мы используем конструктор
    public void save(Ticket unit) { // благодаря конструктору без параметров мы в тестах можем писать new Ticket
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = unit;
        tickets = tmp;
    }

    public Ticket[] findAll(String from, String to) {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket unit : tickets) {
            if (unit.getId() == id) {
                return unit;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket unit : tickets){
            if (unit.getId() != id) {
                tmp[index] = unit;
                index++;
            }
        }
        tickets = tmp;
    }
}
