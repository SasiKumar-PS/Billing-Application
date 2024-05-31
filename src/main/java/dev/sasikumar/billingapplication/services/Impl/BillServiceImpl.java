package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.Enums.ProductType;
import dev.sasikumar.billingapplication.models.Bill;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.models.Product;
import dev.sasikumar.billingapplication.repositorys.BillRepository;
import dev.sasikumar.billingapplication.services.BillService;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
        Bill bill = new Bill();

        Customer customer = customerService.getCustomer(billDto.getBusinessName());
        if(customer == null) throw new RuntimeException("customer business name is invalid \n 1. please check the business name and try again! \n2. Create a customer and then try saving the bill with this customer");

        bill.setCustomer(customer);
        bill.setDate(billDto.getDate());
        bill.setProducts(billDto.getProducts());

        // Need to find, can we compute these values at object creation
        int billAmount = 0;
        for(Product product : bill.getProducts()) {
            int productAmount = 0;

            if(product.getProductType().equals(ProductType.BAG)){
                productAmount = product.getQuantity() * product.getPrice();
            }
            else if(product.getProductType().equals(ProductType.WEIGHT)){
                productAmount = product.getWeight() * product.getPrice();
            }

            product.setAmount(productAmount);
            billAmount += productAmount;
        }
        bill.setAmount(billAmount);

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

        // fetch the bill and store the old bill amount
        // after modification store the new bill amount
        // now modify the customer balance with the difference (new-old)
        // return billDto

        Bill bill = getBill(billDto.getBusinessName(), billDto.getDate());
        if(bill == null) throw new RuntimeException("customer business name is invalid or there is no bill in the mentioned date");

        bill.setProducts(billDto.getProducts());
        bill.setAmount(bill.getAmount());

        return billRepository.save(bill);
    }

    @Override
    public String deleteBill(String businessName, LocalDate date) {

        // before deleting the bill reduce the amount to the customer balance
        // and delete the bill
        // return bill date + bill amount + new balance of customer

        billRepository.delete(businessName, date);
        return businessName + "'s bill at date " + date + " is deleted!";
    }
}
