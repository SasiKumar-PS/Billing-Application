package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptRepository extends JpaRepository <Receipt, Integer> {
    Receipt getReceiptsByCustomer_BusinessNameAndDate(String businessName, LocalDate date);
    List<Receipt> getAllByDate(LocalDate date);
}
