package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface BillRepository extends JpaRepository <Bill, Integer> {
    //HQL query
    @Query("select b from Bill b where b.customer.businessName = :businessName and b.date = :date")
    Bill getBillByBusinessNameandByDate(String businessName, LocalDate date);

    @Query("delete from Bill b where b.customer.businessName = :businessName and b.date = :date")
    void delete(String businessName, LocalDate date);

    Bill getBillByCustomer_BusinessNameAndDate(String businessName, LocalDate date);
}

