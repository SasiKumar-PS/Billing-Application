package dev.sasikumar.billingapplication.converter;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.models.Bill;

import java.util.List;

public class BillConverter {
    public static Bill toBill(BillDto billDto) {
        Bill bill = new Bill();

        bill.setId(billDto.getBillId());
        bill.setDate(billDto.getDate());
        bill.setAmount(billDto.getAmount());
        bill.setProducts(ProductConverter.toProductList(billDto.getProducts()));
        // can't store customer details! need to do this in service!

        return bill;
    }

    public static BillDto toBillDto (Bill bill) {
        BillDto billDto = new BillDto();

        billDto.setBillId(bill.getId());
        billDto.setBusinessName(bill.getCustomer().getBusinessName());
        billDto.setDate(bill.getDate());
        billDto.setProducts(ProductConverter.toProductDtoList(bill.getProducts()));
        billDto.setAmount(bill.getAmount());

        return billDto;
    }

    public static List<BillDto> toBillDtoList (List<Bill> bills) {
        return bills.stream().map(BillConverter::toBillDto).toList();
    }
    
    public static void updateValues(Bill updatedBill, Bill billFromDB) {
        if(updatedBill.getId() == null) updatedBill.setId(billFromDB.getId());
        if(updatedBill.getCustomer() == null) updatedBill.setCustomer(billFromDB.getCustomer());
        if(updatedBill.getDate() == null) updatedBill.setDate(billFromDB.getDate());
        if(updatedBill.getAmount() == 0) updatedBill.setAmount(billFromDB.getAmount());
        if(updatedBill.getProducts() == null) updatedBill.setProducts(billFromDB.getProducts());
    }
}