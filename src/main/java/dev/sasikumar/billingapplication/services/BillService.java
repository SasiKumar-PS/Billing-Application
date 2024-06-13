package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.models.Bill;

import java.time.LocalDate;
import java.util.List;

public interface BillService {
    Bill createBill(BillDto billDto);
    Bill getBill(String businessName, LocalDate date);
    Bill updateBill(BillDto billDto);
    String deleteBill(String businessName, LocalDate date);
    List<Bill> getAllBills();
    List<Bill> getAllBillsByCustomer(String businessName);
    List<Bill> getAllBillsByDate(LocalDate date);
    public List<Bill> getBillsFromRange(LocalDate fromDate, LocalDate toDate);
}
