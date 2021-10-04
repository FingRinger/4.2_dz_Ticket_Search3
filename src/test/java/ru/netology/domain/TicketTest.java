package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

private Ticket ticket1 = new Ticket(1, 3000, "DME", "EGO", 85);
private Ticket ticket2 = new Ticket(2, 2000, "DME", "LED", 90);
private Ticket ticket3 = new Ticket(3, 10000, "LED", "CDG", 325);

@Test
    public void shouldSortByPrice(){
    Ticket[] expected = new Ticket[]{ticket2, ticket1, ticket3};
    Ticket[] actual = new Ticket[]{ticket1,ticket2,ticket3};

    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
}
}