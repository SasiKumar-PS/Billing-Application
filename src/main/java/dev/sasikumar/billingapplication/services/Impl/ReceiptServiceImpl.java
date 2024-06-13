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
import java.util.List;

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

        Receipt receipt = ReceiptConverter.toReceipt(receiptDto);
        Customer customer = customerService.getCustomer(receiptDto.getBusinessName());
        if(customer == null) throw new IllegalArgumentException("customer business name is invalid \n 1. please check the business name and try again! \n 2. Create a customer and then try saving the receipt with this customer");
        receipt.setCustomer(customer);
        // reduce the customer balance by their receipt amount
        customer.setBalance(customer.getBalance() - receipt.getTotalAmount());

        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt getReceipt(String businessName, LocalDate date) {
        return receiptRepository.getReceiptsByCustomer_BusinessNameAndDate(businessName, date);
    }

    @Override
    public Receipt updateReceipt(ReceiptDto receiptDto) {
        Receipt updatedReceipt = ReceiptConverter.toReceipt(receiptDto);
        Receipt receiptFromDB = getReceipt(receiptDto.getBusinessName(), receiptDto.getDate());
        if(receiptFromDB == null) throw new IllegalArgumentException("customer business name is invalid or there is no Receipt in the mentioned date, please check and try again!");
        // updates non-changing values
        ReceiptConverter.updateValues(updatedReceipt, receiptFromDB);

        double oldReceipt = receiptFromDB.getTotalAmount();
        double newReceipt = updatedReceipt.getTotalAmount();
        // updating the customer balance with their new receipt amount while adding the old receipt amount
        updatedReceipt.getCustomer().setBalance(updatedReceipt.getCustomer().getBalance() - newReceipt + oldReceipt);

        return receiptRepository.save(updatedReceipt);
    }

    @Override
    public String deleteReceipt(String businessName, LocalDate date) {
        Receipt receipt = getReceipt(businessName, date);
        // adding the receipt amount to the customer balance
        receipt.getCustomer().setBalance(receipt.getCustomer().getBalance() + receipt.getTotalAmount());

        receiptRepository.deleteById(receipt.getId());
        return "receipt of " + businessName + " at " + date + " is deleted!";
    }

    @Override
    public List<Receipt> getAllReceiptByDate(LocalDate date) {
        return receiptRepository.getAllByDate(date);
    }
}
