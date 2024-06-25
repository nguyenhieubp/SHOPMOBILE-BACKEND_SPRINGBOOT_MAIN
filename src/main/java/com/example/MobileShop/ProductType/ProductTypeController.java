package com.example.MobileShop.ProductType;

import com.example.MobileShop.Config.FormatResponse.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product-type")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProductType(){
        ApiResponse<List<ProductType>> response = new ApiResponse<>(HttpStatus.OK.value(),"success",productTypeService.getAllProductType());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductTypeById(@PathVariable UUID id) {
        ProductType productType = productTypeService.getProductTypeById(id);
        ApiResponse<ProductType> response = new ApiResponse<>(HttpStatus.OK.value(), "success", productType);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createProductType(@RequestBody ProductType productType) {
        ProductType createdProductType = productTypeService.createProductType(productType);
        ApiResponse<ProductType> response = new ApiResponse<>(HttpStatus.CREATED.value(), "Product type created successfully", createdProductType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProductType(@PathVariable UUID id, @Valid @RequestBody ProductType productTypeDetails) {
        ProductType updatedProductType = productTypeService.updateProductType(id, productTypeDetails);
        ApiResponse<ProductType> response = new ApiResponse<>(HttpStatus.OK.value(), "Product type updated successfully", updatedProductType);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductType(@PathVariable UUID id) {
        productTypeService.deleteProductType(id);
        ApiResponse<Boolean> response = new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Product type deleted successfully", true);
        return ResponseEntity.ok().body(response);
    }


}
