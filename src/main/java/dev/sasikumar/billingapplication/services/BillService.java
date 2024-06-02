package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.models.Bill;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BillService {
    Bill createBill(BillDto billDto);
    Bill getBill(String businessName, LocalDate date);
    Bill updateBill(BillDto billDto);
    String deleteBill(String businessName, LocalDate date);
    List<Bill> getAllBills();
    List<Bill> getAllBillsByCustomer(String businessName);
}
