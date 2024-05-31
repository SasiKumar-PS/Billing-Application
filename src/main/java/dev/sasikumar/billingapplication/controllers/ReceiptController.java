package dev.sasikumar.billingapplication.controllers;

import dev.sasikumar.billingapplication.DTOs.ReceiptDto;
import dev.sasikumar.billingapplication.models.Receipt;
import dev.sasikumar.billingapplication.services.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/")
    public Receipt createReceipt(@RequestBody ReceiptDto createReceiptDto) {
        return receiptService.createReceipt(createReceiptDto);
    }

    @GetMapping("/{name}/{date}")
    public Receipt getReceipt(@PathVariable("name") String businessName,
                                 @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return receiptService.getReceipt(businessName, localDate);
    }

    @PutMapping("/{name}/{date}")
    public Receipt updateReceipt(@PathVariable("name") String businessName,
                                 @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return receiptService.updateReceipt(businessName, localDate);
    }

    @DeleteMapping("/{name}/{date}")
    public String deleteReceipt(@PathVariable("name") String businessName,
                                 @PathVariable("date") String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return receiptService.deleteReceipt(businessName, localDate);
    }
}
