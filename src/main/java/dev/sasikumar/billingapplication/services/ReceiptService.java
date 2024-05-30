package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.models.Receipt;

public interface ReceiptService {
    Receipt createReceipt();
    Receipt getReceipt();
    Receipt updateReceipt();
    String deleteReceipt();
}
