package dev.sasikumar.billingapplication.converter;

import dev.sasikumar.billingapplication.DTOs.ReceiptDto;
import dev.sasikumar.billingapplication.models.Receipt;

public class ReceiptConverter {

    public static Receipt toReceipt(ReceiptDto receiptDto) {
        Receipt receipt = new Receipt();

        receipt.setId(receiptDto.getId());
        receipt.setDate(receiptDto.getDate());
        receipt.setAmount(receiptDto.getAmount());
        // can't store customer details! need to do this in service!

        return receipt;
    }

    public static ReceiptDto toReceiptDto (Receipt receipt) {
        ReceiptDto receiptDto = new ReceiptDto();

        receiptDto.setId(receipt.getId());
        receiptDto.setBusinessName(receipt.getCustomer().getBusinessName());
        receiptDto.setDate(receipt.getDate());
        receiptDto.setAmount(receipt.getAmount());

        return receiptDto;
    }
    
    public static void updateValues(Receipt updatedReceipt, Receipt receiptFromDB) {
        if(updatedReceipt.getId() == null) updatedReceipt.setId(receiptFromDB.getId());
        if(updatedReceipt.getCustomer() == null) updatedReceipt.setCustomer(receiptFromDB.getCustomer());
        if(updatedReceipt.getDate() == null) updatedReceipt.setDate(receiptFromDB.getDate());
        if(updatedReceipt.getAmount() == 0) updatedReceipt.setAmount(receiptFromDB.getAmount());
        // discount shouldn't copy from the old receipt
    }
}
