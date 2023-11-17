package org.example.service;

import org.example.model.DeliveryPerson;
import org.example.model.Slot;

public interface DeliveryPersonService {
    DeliveryPerson getDeliveryPerson(Slot slot);
}
