package com.example.MobileShop.Phones;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProductRepository;
import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.Phones.Request.PhoneRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private CommonDetailProductRepository commonDetailProductRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Phones createNewPhone(PhoneRequest phone){
        System.out.println(phone.getCommonDetailProduct());
        CommonDetailProduct commonDetailProduct = commonDetailProductRepository.findById(phone.getCommonDetailProduct()).orElseThrow();
        Phones phones = modelMapper.map(phone,Phones.class);
        phones.setCommonDetailProduct(commonDetailProduct);
        return phoneRepository.save(phones);
    }

    public List<Phones> getAllPhone(){
        List<Phones> phones = phoneRepository.findAll();
        return phones;
    }


    public Phones getPhoneById(UUID id){
        Phones phones = phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not have phone id "+ id));
        return phones;
    }


    public boolean deletePhone(UUID id){
        Phones phones = phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not have phone id "+ id));
        phoneRepository.delete(phones);
        return true;
    }

    public Phones updatePhone(UUID id,PhoneRequest phone){
        System.out.println("UUUU "+id);
        Phones existingPhone = phoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Phone ID not found: " + id));

        // Map the fields from phoneRequest to existingPhone
        modelMapper.map(phone, existingPhone);

        // Save the updated phone object
        return phoneRepository.save(existingPhone);
    }

}
