package dev.sasikumar.billingapplication.controllers;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.DTOs.ProductDto;
import dev.sasikumar.billingapplication.converter.BillConverter;
import dev.sasikumar.billingapplication.models.Bill;
import dev.sasikumar.billingapplication.services.BillService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/")
    public Bill createBill(@RequestBody BillDto billDto) {
        return billService.createBill(billDto);
    }

    @PostMapping("/addProduct/{id}")
    public Bill addProductInBill (@PathVariable("id") int id,
                                @RequestBody ProductDto productDto) {

        // adding and removing product in a bill should be done via updateBill
        // But we can add product directly to product bill using JdbcTemplate
        return null;
    }

    @GetMapping("/{name}/{date}")
    public BillDto getBill (@PathVariable("name") String businessName,
                        @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return BillConverter.toBillDto(billService.getBill(businessName, localDate));
    }

    @PutMapping("/")
    public Bill updateBill (@RequestBody BillDto billDto) {

        return billService.updateBill(billDto);
    }

    @DeleteMapping("/{name}/{date}")
    public String deleteBill (@PathVariable("name") String businessName,
                           @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return billService.deleteBill(businessName, localDate);
    }

    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{name}")
    public List<Bill> getAllBillsByCustomer(@PathVariable("name") String businessName){
        return billService.getAllBillsByCustomer(businessName);
    }
}
