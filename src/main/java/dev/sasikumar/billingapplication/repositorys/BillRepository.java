package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository <Bill, Integer> {
    //HQL query
    @Query("select b from Bill b where b.customer.businessName = :businessName and b.date = :date")
    Bill getBillByBusinessNameandByDate(String businessName, LocalDate date);

    // throwing Run-time error, delete query for this input!
    // @Query("delete from Bill b where b.customer.businessName = :businessName and b.date = :date")
    @Query(value = "DELETE from Bills b JOIN Customers c ON b.customer_id = c.id where c.business_name = :businessName AND b.date = :date", nativeQuery = true)
    void delete(@Param("businessName") String businessName, @Param("date") LocalDate date);

    // throwing compile-time error, delete query for this input!
    // void deleteBillByCustomer_BusinessNameAndDate(String businessName, LocalDate date);

    List<Bill> getAllByCustomer_BusinessName(String businessName);
}

