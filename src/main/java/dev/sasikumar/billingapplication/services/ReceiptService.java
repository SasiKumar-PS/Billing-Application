package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.DTOs.ReceiptDto;
import dev.sasikumar.billingapplication.models.Receipt;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptService {
    Receipt createReceipt(ReceiptDto createReceiptDto);
    Receipt getReceipt(String businessName, LocalDate date);
    Receipt updateReceipt(ReceiptDto receiptDto);
    String deleteReceipt(String businessName, LocalDate date);
    List<Receipt> getAllReceiptByDate(LocalDate date);
}
