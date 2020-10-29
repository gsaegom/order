package com.switchfully.guillermo.order.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean isValidUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isValidAmount(int amount) {
        return amount >= 1;
    }
}
