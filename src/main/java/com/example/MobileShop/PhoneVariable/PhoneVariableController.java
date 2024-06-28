package com.example.MobileShop.PhoneVariable;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.PhoneVariable.response.ResponsePhoneVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/phonevariables")
public class PhoneVariableController {

    @Autowired
    private PhoneVariableService phoneVariableService;

    @GetMapping
    public Page<ResponsePhoneVariable> getAllPhoneVariables(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return phoneVariableService.getAllPhoneVariables(page,pageSize);
    }

    @GetMapping("/{id}")
    public ResponsePhoneVariable getPhoneVariableById(@PathVariable UUID id) {
        return phoneVariableService.getPhoneVariableById(id);
    }

    @PostMapping
    public PhoneVariableDTO createPhoneVariable(@RequestBody PhoneVariableDTO phoneVariableDTO) {
        return phoneVariableService.createPhoneVariable(phoneVariableDTO);
    }

    @PutMapping("/{id}")
    public PhoneVariableDTO updatePhoneVariable(@PathVariable UUID id, @RequestBody PhoneVariableDTO phoneVariableDTO) {
        return phoneVariableService.updatePhoneVariable(id, phoneVariableDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deletePhoneVariable(@PathVariable UUID id) {
        return phoneVariableService.deletePhoneVariable(id);
    }

    @GetMapping("/phone-main/{id}")
    public List<ResponsePhoneVariable>  getAllPhoneChildrenByPhoneMain(@PathVariable UUID id){
        return phoneVariableService.getAllPhoneChildrenByPhoneMain(id);
    }

    @GetMapping("/search")
    public Page<ResponsePhoneVariable> getAllPhoneVariables(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String ram,
            @RequestParam(required = false) String internal_storage,
            @RequestParam(required = false) Double battery_capacity) {

        return phoneVariableService.findAllFilteredAndPaged(
                pageable, color, ram, internal_storage, battery_capacity);
    }

}
