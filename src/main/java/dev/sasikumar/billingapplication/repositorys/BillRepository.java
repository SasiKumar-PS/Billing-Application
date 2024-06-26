package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository <Bill, Integer> {
    //HQL query
    @Query("select b from Bill b where b.customer.businessName = :businessName and b.date = :date")
    Bill getBillByBusinessNameAndByDate(String businessName, LocalDate date);
    List<Bill> getAllByCustomer_BusinessName(String businessName);
    List<Bill> getAllByDate(LocalDate date);
    List<Bill> getBillsByDateGreaterThanEqualAndDateLessThanEqual(LocalDate fromDate, LocalDate toDate);
}

