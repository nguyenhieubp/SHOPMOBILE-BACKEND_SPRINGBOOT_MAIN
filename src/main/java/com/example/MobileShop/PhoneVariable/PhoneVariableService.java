package com.example.MobileShop.PhoneVariable;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProductRepository;
import com.example.MobileShop.PhoneVariable.response.ResponsePhoneVariable;
import com.example.MobileShop.Phones.PhoneRepository;
import com.example.MobileShop.Phones.Phones;
import jakarta.transaction.Transactional;
import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PhoneVariableService {
    @Autowired
    private PhoneVariableRepository phoneVariableRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonDetailProductRepository commonDetailProductRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public Page<ResponsePhoneVariable> getAllPhoneVariables(int page, int pageSize) {
        Pageable paging = PageRequest.of(page - 1, pageSize); // page - 1 để chuyển từ 1-based index sang 0-based index
        Page<PhoneVariable> pagedResult = phoneVariableRepository.findAll(paging);

        // Chuyển đổi Page<PhoneVariable> sang Page<ResponsePhoneVariable>
        return new PageImpl<>(pagedResult.getContent().stream()
                .map(this::mapToResponsePhoneVariable)
                .collect(Collectors.toList()), paging, pagedResult.getTotalElements());
    }

    private ResponsePhoneVariable mapToResponsePhoneVariable(PhoneVariable phoneVariable) {
        CommonDetailProduct commonDetailProduct = commonDetailProductRepository.findById(phoneVariable.getCommonDetailProduct())
                .orElseThrow(() -> new RuntimeException("CommonDetailProduct not found"));

        return new ResponsePhoneVariable(phoneVariable, commonDetailProduct);
    }


    public ResponsePhoneVariable getPhoneVariableById(UUID id) {
        PhoneVariable phoneVariable = phoneVariableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PhoneVariable not found with id: " + id));

        CommonDetailProduct commonDetailProduct = commonDetailProductRepository.findById(phoneVariable.getCommonDetailProduct())
                .orElseThrow(() -> new RuntimeException("CommonDetailProduct not found"));

        return new ResponsePhoneVariable(phoneVariable, commonDetailProduct);
        //        return convertToDto(phoneVariable);
    }

    @Transactional
    public PhoneVariableDTO createPhoneVariable(PhoneVariableDTO phoneVariableDTO) {
        try {
            PhoneVariable phoneVariable = convertToEntity(phoneVariableDTO);

            PhoneVariable savedPhoneVariable = phoneVariableRepository.save(phoneVariable);
            // Map entity back to DTO
            PhoneVariableDTO savedPhoneVariableDTO = convertToDto(savedPhoneVariable);
            return savedPhoneVariableDTO;
        } catch (Exception e) {
            // Handle exceptions and wrap them in a meaningful response
            throw new RuntimeException("Failed to create phone variable", e);
        }
    }


    @Transactional
    public PhoneVariableDTO updatePhoneVariable(UUID id, PhoneVariableDTO phoneVariableDTO) {
        PhoneVariable existingPhoneVariable = phoneVariableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PhoneVariable not found with id: " + id));

        // Update fields manually or use ModelMapper
        modelMapper.map(phoneVariableDTO, existingPhoneVariable);

        PhoneVariable updatedPhoneVariable = phoneVariableRepository.save(existingPhoneVariable);
        return convertToDto(updatedPhoneVariable);
    }

    @Transactional
    public boolean deletePhoneVariable(UUID id) {
        PhoneVariable phoneVariable = phoneVariableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PhoneVariable not found with id: " + id));
        System.out.println("FFF "+phoneVariable);
        phoneVariableRepository.delete(phoneVariable);
        return true;
    }

    private PhoneVariableDTO convertToDto(PhoneVariable phoneVariable) {
        return modelMapper.map(phoneVariable, PhoneVariableDTO.class);
    }

    private PhoneVariable convertToEntity(PhoneVariableDTO phoneVariableDTO) {
        return modelMapper.map(phoneVariableDTO, PhoneVariable.class);
    }

    public List<ResponsePhoneVariable> getAllPhoneChildrenByPhoneMain(UUID id) {
        List<PhoneVariable> phoneVariables = phoneVariableRepository.getAllPhoneChildrenByPhoneMainId(id);

        // Chuyển đổi List<PhoneVariable> sang List<ResponsePhoneVariable>
        return phoneVariables.stream()
                .map(this::mapToResponsePhoneVariable)
                .collect(Collectors.toList());
    }


    public Page<ResponsePhoneVariable> findAllFilteredAndPaged(
            Pageable pageable, String color, String ram, String internal_storage, Double battery_capacity) {

        Page<PhoneVariable> pagedResult = phoneVariableRepository.findAllByFilters(
                color, ram, internal_storage, battery_capacity, pageable);

        // Chuyển đổi Page<PhoneVariable> sang Page<ResponsePhoneVariable>
        List<ResponsePhoneVariable> responsePhoneVariables = pagedResult.getContent().stream()
                .map(this::mapToResponsePhoneVariable)
                .collect(Collectors.toList());

        return new PageImpl<>(responsePhoneVariables, pageable, pagedResult.getTotalElements());
    }


}
