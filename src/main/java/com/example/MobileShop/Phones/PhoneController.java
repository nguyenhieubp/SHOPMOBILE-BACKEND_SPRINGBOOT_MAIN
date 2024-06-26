package com.example.MobileShop.Phones;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.Phones.Request.PhoneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public  List<Phones> getAllPhone(){
        return phoneService.getAllPhone();
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

}
