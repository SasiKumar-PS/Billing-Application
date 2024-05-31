package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository <Receipt, Integer> {
}
