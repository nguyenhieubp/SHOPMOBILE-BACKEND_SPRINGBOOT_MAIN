package com.example.MobileShop.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public AddressDto createAddress(@RequestBody AddressDto addressDto){
        return addressService.createAddressDto(addressDto);
    }


    @GetMapping("/user/{id}")
    public List<Address> getAllAddressByUser(@PathVariable UUID id){
        return addressService.getAllAddressByUser(id);
    }

    @PutMapping("/update/{id}")
    public Address updateAddress(@PathVariable UUID id,@RequestBody AddressDto addressDto){
        return addressService.updateAddress(id,addressDto);
    }


    @DeleteMapping("/delete/{id}")
    public boolean deleteAddress(@PathVariable UUID id){
        return addressService.deleteAddress(id);
    }

    @GetMapping("/item/{id}")
    public Address getById(@PathVariable UUID id){
        return addressService.getById(id);
    }
}
