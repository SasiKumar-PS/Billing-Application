package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.ReceiptDto;
import dev.sasikumar.billingapplication.converter.ReceiptConverter;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.models.Receipt;
import dev.sasikumar.billingapplication.repositorys.ReceiptRepository;
import dev.sasikumar.billingapplication.services.CustomerService;
import dev.sasikumar.billingapplication.services.ReceiptService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    
    private final ReceiptRepository receiptRepository;
    private final CustomerService customerService;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, CustomerService customerService) {
        this.receiptRepository = receiptRepository;
        this.customerService = customerService;
    }

    @Override
    public Receipt createReceipt(ReceiptDto receiptDto) {
        
        // Need to implement business logic 
        Receipt receipt = ReceiptConverter.toReceipt(receiptDto);
        Customer customer = customerService.getCustomer(receiptDto.getBusinessName());
        if(customer == null) throw new IllegalArgumentException("customer business name is invalid \n 1. please check the business name and try again! \n 2. Create a customer and then try saving the receipt with this customer");
        receipt.setCustomer(customer);

        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt getReceipt(String businessName, LocalDate date) {
        return receiptRepository.getReceiptsByCustomer_BusinessNameAndDate(businessName, date);
    }

    @Override
    public Receipt updateReceipt(ReceiptDto receiptDto) {
        Receipt updatedReceipt = ReceiptConverter.toReceipt(receiptDto);
        Receipt receipt = getReceipt(receiptDto.getBusinessName(), receiptDto.getDate());
        if(receipt == null) throw new IllegalArgumentException("customer business name is invalid or there is no Receipt in the mentioned date, please check and try again!");

        if(updatedReceipt.getId() == null) updatedReceipt.setId(receipt.getId());
        if(updatedReceipt.getCustomer() == null) updatedReceipt.setCustomer(receipt.getCustomer());
        if(updatedReceipt.getDate() == null) updatedReceipt.setDate(receipt.getDate());
        if(updatedReceipt.getAmount() == null) updatedReceipt.setAmount(receipt.getAmount());

        return receiptRepository.save(updatedReceipt);
    }

    @Override
    public String deleteReceipt(String businessName, LocalDate date) {
        receiptRepository.deleteReceiptByCustomer_BusinessNameAndDate(businessName, date);
        return "receipt of " + businessName + " at " + date + " is deleted!";
    }
}
