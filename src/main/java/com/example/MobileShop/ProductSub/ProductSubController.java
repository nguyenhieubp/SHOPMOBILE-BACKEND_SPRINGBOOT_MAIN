package com.example.MobileShop.ProductSub;

import com.example.MobileShop.Config.FormatResponse.ApiResponse;
import com.example.MobileShop.ProductSub.Request.ProductSubDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product-sub")
public class ProductSubController {

    @Autowired
    private ProductSubService productSubService;

    @PostMapping("/add")
    public ResponseEntity<?> addProductSub(@Valid  @RequestBody ProductSubDto productSub){
        ApiResponse<ProductSubDto> response = new ApiResponse<>(HttpStatus.OK.value(), "success",productSubService.addProductSub(productSub));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProductSubs(){
        ApiResponse<List<ProductSubDto>> response = new ApiResponse<>(HttpStatus.OK.value(), "success",productSubService.getAllProductSubs());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemProductSubs(@PathVariable UUID id){
        ApiResponse<ProductSubDto> response = new ApiResponse<>(HttpStatus.OK.value(), "success",productSubService.getProductSubById(id));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> getItemProductSubs(@PathVariable UUID id,@RequestBody ProductSubDto productDto){
        ApiResponse<ProductSubDto> response = new ApiResponse<>(HttpStatus.OK.value(), "success",productSubService.editProductSubById(id,productDto));
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteProductSubs(@PathVariable UUID id){
        ApiResponse<Boolean> response = new ApiResponse<>(HttpStatus.OK.value(), "success",productSubService.deleteProductSubById(id));
        return ResponseEntity.ok().body(response);
    }




}
