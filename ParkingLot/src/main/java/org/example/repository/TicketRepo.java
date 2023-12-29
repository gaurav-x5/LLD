package org.example.repository;

import org.example.models.ParkingTicket;

import java.util.HashMap;

public class TicketRepo {
    public static HashMap<String, ParkingTicket> activeTicket = new HashMap<>();
    public static HashMap<String, ParkingTicket> historyTicket = new HashMap<>();

    private TicketRepo(){
    }
}
