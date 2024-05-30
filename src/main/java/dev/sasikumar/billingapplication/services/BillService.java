package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.models.Bill;

public interface BillService {
    Bill createBill();
    Bill getBill();
    Bill updateBill();
    String deleteBill();
}
