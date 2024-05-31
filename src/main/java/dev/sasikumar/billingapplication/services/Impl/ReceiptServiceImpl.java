package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.ReceiptDto;
import dev.sasikumar.billingapplication.models.Receipt;
import dev.sasikumar.billingapplication.services.ReceiptService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public Receipt createReceipt(ReceiptDto createReceiptDto) {
        return null;
    }

    @Override
    public Receipt getReceipt(String businessName, LocalDate date) {
        return null;
    }

    @Override
    public Receipt updateReceipt(String businessName, LocalDate date) {
        return null;
    }

    @Override
    public String deleteReceipt(String businessName, LocalDate date) {
        return null;
    }
}
