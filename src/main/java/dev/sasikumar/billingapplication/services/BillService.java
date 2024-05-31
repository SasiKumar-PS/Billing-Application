package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.models.Bill;

import java.time.LocalDate;

public interface BillService {
    Bill createBill(BillDto billDto);
    Bill getBill(String businessName, LocalDate date);
    Bill updateBill(BillDto billDto);
    String deleteBill(String businessName, LocalDate date);
}
