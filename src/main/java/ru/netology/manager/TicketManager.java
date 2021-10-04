package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repo.findAll(from, to)) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                Arrays.sort(tmp);
                result = tmp;
            }
        }
        return result;
    }
        public boolean matches(Ticket ticket, String from, String to) {
            if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
                return true;
            }
            return false;
        }
    }


