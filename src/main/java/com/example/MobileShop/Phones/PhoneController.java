package com.example.MobileShop.Phones;

import com.example.MobileShop.Phones.Request.SetShowPhoneRequest;
import com.example.MobileShop.Phones.Request.PhoneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @PostMapping("/add")
    public Phones createPhone(@RequestBody PhoneRequest phone){
        return phoneService.createNewPhone(phone);
    }


    @GetMapping("/getAll")
    public Page<Phones> getAllPhones(
            @RequestParam(required = false) String title ,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ) {
        String sortDirection = "ASC";
        if (sortBy != null && !sortBy.isEmpty()) {
            sortDirection = sortBy.equalsIgnoreCase("desc") ? "DESC" : "ASC";
        }
        return phoneService.getAllPhones(title, page, size, sortDirection);
    }


    @GetMapping("/item/{id}")
    public Phones getPhoneById(@PathVariable UUID id){
        return phoneService.getPhoneById(id);
    }


    @DeleteMapping("{id}")
    public boolean deletePhone(@PathVariable UUID id){
        return phoneService.deletePhone(id);
    }

    @PutMapping("/edit/{id}")
    public Phones updatePhone(@PathVariable UUID id,@RequestBody PhoneRequest phone){
        return phoneService.updatePhone(id,phone);
    }

    @PatchMapping("/setIsShow/{id}")
    public Phones setIsShow(@PathVariable UUID id,@RequestBody SetShowPhoneRequest setShow){
        return phoneService.setIsShow(id,setShow);
    }


}
