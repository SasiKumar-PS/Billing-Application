package dev.sasikumar.billingapplication.controllers;

import dev.sasikumar.billingapplication.DTOs.BillDto;
import dev.sasikumar.billingapplication.converter.BillConverter;
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
    public BillDto createBill(@RequestBody BillDto billDto) {
        return BillConverter.toBillDto(billService.createBill(billDto));
    }

    @GetMapping("/{name}/{date}")
    public BillDto getBill (@PathVariable("name") String businessName,
                        @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return BillConverter.toBillDto(billService.getBill(businessName, localDate));
    }

    @PutMapping("/")
    public BillDto updateBill (@RequestBody BillDto billDto) {

        return BillConverter.toBillDto(billService.updateBill(billDto));
    }

    @DeleteMapping("/{name}/{date}")
    public String deleteBill (@PathVariable("name") String businessName,
                           @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return billService.deleteBill(businessName, localDate);
    }

    @GetMapping("/all")
    public List<BillDto> getAllBills() {
        return BillConverter.toBillDtoList(billService.getAllBills());
    }

    @GetMapping("/name/{name}")
    public List<BillDto> getAllBillsByCustomer(@PathVariable("name") String businessName){
        return BillConverter.toBillDtoList(billService.getAllBillsByCustomer(businessName));
    }

    @GetMapping("/date/{date}")
    public List<BillDto> getAllBillsByDate(@PathVariable("date") String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return BillConverter.toBillDtoList(billService.getAllBillsByDate(localDate));
    }

    @GetMapping("/from/{fromDate}/to/{toDate}")
    public List<BillDto> getBillsFromRange(@PathVariable("fromDate") String fromDate,
                                           @PathVariable("toDate") String toDate) {
        LocalDate localDateFrom = LocalDate.parse(fromDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate localDateTo = LocalDate.parse(toDate, DateTimeFormatter.ISO_LOCAL_DATE);

        return BillConverter.toBillDtoList(billService.getBillsFromRange(localDateFrom, localDateTo));
    }
}
