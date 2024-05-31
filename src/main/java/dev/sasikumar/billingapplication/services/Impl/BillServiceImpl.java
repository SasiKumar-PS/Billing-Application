package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.Enums.ProductType;
import dev.sasikumar.billingapplication.models.Bill;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.models.Product;
import dev.sasikumar.billingapplication.services.BillService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillServiceImpl implements BillService {
    @Override
    public Bill createBill(BillDto billDto) {
        Bill bill = new Bill();
        bill.setCustomer(new Customer());
        bill.getCustomer().setBusinessName(billDto.getBusinessName());
        bill.setDate(billDto.getDate());
        bill.setProducts(billDto.getProducts());

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

        return bill;
    }

    @Override
    public Bill getBill(String businessName, LocalDate date) {
        // fetch bill with businessName and date
        // just return the billDto
        return null;
    }

    @Override
    public Bill updateBill(String businessName, LocalDate date) {

        // fetch the bill and store the old bill amount
        // after modification store the new bill amount
        // now modify the customer balance with the difference (new-old)
        // return billDto


        return null;
    }

    @Override
    public String deleteBill() {

        // before deleting the bill reduce the amount to the customer balance
        // and delete the bill
        // return bill date + bill amount + new balance of customer


        return null;
    }
}
