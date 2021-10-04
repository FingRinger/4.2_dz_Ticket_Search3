package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);
    private Ticket ticket1 = new Ticket(1, 3000, "DME", "EGO", 85);
    private Ticket ticket2 = new Ticket(2, 2000, "DME", "LED", 90);
    private Ticket ticket3 = new Ticket(3, 10000, "LED", "CDG", 325);//Шарль-де-Голль - Аэропорт; Париж
    private Ticket ticket4 = new Ticket(4, 9600, "LED", "CDG", 560);
    private Ticket ticket5 = new Ticket(5, 3500, "DME", "LED", 80);
    private Ticket ticket6 = new Ticket(6, 2600, "DME", "EGO", 95);

    @BeforeEach
    public void setUp() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
    }

    @Test
    public void shouldFindDMEtoLEDbyTime(){
        Ticket[] expected = new Ticket[]{ticket5, ticket2};
        Ticket[] actual = manager.searchBy("DME", "LED");
        assertArrayEquals(expected,actual);
    }
}