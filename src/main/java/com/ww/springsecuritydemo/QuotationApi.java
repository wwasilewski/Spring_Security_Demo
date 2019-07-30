package com.ww.springsecuritydemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wojciech Wasilewski
 * @date Created on 30.07.2019
 */
@RestController
public class QuotationApi {

    private List<Quotation> quotations;

    public QuotationApi() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("Those who dare to fail miserably can achieve greatly.", "John F. Kennedy"));
        quotations.add(new Quotation("Get busy living or get busy dying.", "Stephen King"));
        quotations.add(new Quotation("It is hard to fail, but it is worse never to have tried to succeed.", "Theodore Roosevelt"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotation() {
        return quotations;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);
    }

    @DeleteMapping("/api")
    public void deleteQuotation(@RequestParam int index) {
        quotations.remove(index);
    }
}
