package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.converter.BillConverter;
import dev.sasikumar.billingapplication.models.Bill;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.repositorys.BillRepository;
import dev.sasikumar.billingapplication.services.BillService;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final CustomerService customerService;

    public BillServiceImpl(BillRepository billRepository, CustomerService customerService) {
        this.billRepository = billRepository;
        this.customerService = customerService;
    }

    @Override
    public Bill createBill(BillDto billDto) {
        Bill bill = BillConverter.toBill(billDto);

        Customer customer = customerService.getCustomer(billDto.getBusinessName());
        if(customer == null) throw new IllegalArgumentException("customer business name is invalid \n 1. please check the business name and try again! \n 2. Create a customer and then try saving the bill with this customer");
        bill.setCustomer(customer);

        return billRepository.save(bill);
    }

    @Override
    public Bill getBill(String businessName, LocalDate date) {
        // fetch bill with businessName and date
        // just return the billDto
        return billRepository.getBillByBusinessNameandByDate(businessName, date);
        // need to check this!
    }

    @Override
    public Bill updateBill(BillDto billDto) {
        // To Do:
        // fetch the bill and store the old bill amount
        // after modification store the new bill amount
        // now modify the customer balance with the difference (new-old)
        // return billDto

        Bill updatedBill = BillConverter.toBill(billDto);
        Bill bill = getBill(billDto.getBusinessName(), billDto.getDate());
        if(bill == null) throw new IllegalArgumentException("customer business name is invalid or there is no bill in the mentioned date, please check and try again!");

        if(updatedBill.getId() == null) updatedBill.setId(bill.getId());
        if(updatedBill.getCustomer() == null) updatedBill.setCustomer(bill.getCustomer());
        if(updatedBill.getDate() == null) updatedBill.setDate(bill.getDate());
        if(updatedBill.getAmount() == 0) updatedBill.setAmount(bill.getAmount());
        if(updatedBill.getProducts() == null) updatedBill.setProducts(bill.getProducts());

        return billRepository.save(updatedBill);
    }

    @Override
    public String deleteBill(String businessName, LocalDate date) {

        // before deleting the bill reduce the amount to the customer balance
        // and delete the bill
        // return bill date + bill amount + new balance of customer

        billRepository.delete(businessName, date);
        return businessName + "'s bill at date " + date + " is deleted!";
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> getAllBillsByCustomer(String businessName) {
        return billRepository.getAllByCustomer_BusinessName(businessName);
    }
}
