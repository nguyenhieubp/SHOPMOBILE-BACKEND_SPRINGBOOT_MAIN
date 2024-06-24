package com.example.MobileShop.ProductType;

import com.example.MobileShop.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> getAllProductType(){
        return productTypeRepository.findAll();
    }

    public ProductType getProductTypeById(UUID id) {
        return productTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductType not found for this id :: " + id));
    }

    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public ProductType updateProductType(UUID id, ProductType productTypeDetails) {
        ProductType productType = productTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductType not found for this id :: " + id));

        productType.setTag(productTypeDetails.getTag());
        return productTypeRepository.save(productType);
    }

    public boolean deleteProductType(UUID id) {
        ProductType productType = productTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductType not found for this id :: " + id));
        productTypeRepository.delete(productType);

        return true;
    }
}
