package com.example.MobileShop.Address;

import com.example.MobileShop.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressDto createAddressDto(AddressDto addressDto){
        System.out.println(addressDto);
        Address address = modelMapper.map(addressDto,Address.class);
        Address newAddress = addressRepository.save(address);
        return modelMapper.map(newAddress,AddressDto.class);
    }


    public List<Address> getAllAddressByUser(UUID userId){
        List<Address> address = addressRepository.findAddressByUserId(userId);
        return address;
    }


    public Address updateAddress(UUID userId, AddressDto addressDto) {
        // Retrieve the existing address entity by userId
        Address address = addressRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + userId));

        // Map the fields from addressDto to the existing address entity
        modelMapper.map(addressDto, address);

        // Save the updated address entity
        Address updatedAddress = addressRepository.save(address);

        return updatedAddress;
    }


    public boolean deleteAddress(UUID addressId){
        addressRepository.deleteById(addressId);
        return true;
    }

    public Address getById(UUID id){
        Address address = addressRepository.findById(id).orElseThrow();
        return  address;
    }

}
