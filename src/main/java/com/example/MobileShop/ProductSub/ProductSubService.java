package com.example.MobileShop.ProductSub;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProductRepository;
import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.ProductSub.Request.ProductSubDto;
import com.example.MobileShop.ProductSub.Request.RequestIdProductDetail;
import com.example.MobileShop.ProductSub.Response.ResponseProductSub;
import com.google.api.gax.rpc.NotFoundException;
import com.google.common.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductSubService {
    @Autowired
    private ProductSubRepository productSubRepository;

    @Autowired
    private CommonDetailProductRepository commonDetailProductRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductSubDto addProductSub(ProductSubDto productSubDto){
        ProductSub productSub = modelMapper.map(productSubDto,ProductSub.class);
        ProductSub newProduct = productSubRepository.save(productSub);
        return modelMapper.map(newProduct,ProductSubDto.class);
    }

    public List<ProductSubDto> getAllProductSubs() {
        List<ProductSub> productSubs = productSubRepository.findAll();
        Type listType = new TypeToken<List<ProductSubDto>>(){}.getType();
        List<ProductSubDto> postDtoList = modelMapper.map(productSubs,listType);
        return postDtoList;
    }

    public ProductSubDto getProductSubById(UUID id) {
        ProductSub productSub =  productSubRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not have "+id));
        return modelMapper.map(productSub,ProductSubDto.class);
    }

    public ProductSubDto editProductSubById(UUID id,ProductSubDto productSubDto) {
        ProductSub productSub =  productSubRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not have "+id));
        // Ánh xạ các thuộc tính từ productSubDto vào productSub đã tìm thấy
        productSubDto.setProductSubId(productSub.getProductSubId());
        modelMapper.map(productSubDto, productSub);

        // Lưu productSub đã cập nhật vào cơ sở dữ liệu
        productSub = productSubRepository.save(productSub);

        // Ánh xạ lại productSub thành ProductSubDto và trả về
        return modelMapper.map(productSub, ProductSubDto.class);
    }


    public boolean deleteProductSubById(UUID id) {
        ProductSub productSub =  productSubRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not have "+id));
        productSubRepository.delete(productSub);
        return true;
    }


    public ResponseProductSub setProductDetailForProductSub(UUID id, RequestIdProductDetail productDetail) {
        ProductSub productSub =  productSubRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not have "+id));
        CommonDetailProduct commonDetailProduct = commonDetailProductRepository.findById(productDetail.getProductDetailId()).orElseThrow();
        productSub.setCommonDetailProduct(commonDetailProduct);
        productSubRepository.save(productSub);
        return modelMapper.map(productSub,ResponseProductSub.class);
    }


    public List<ProductSubDto> getAllProductSubByDetailProduct(UUID id) {
        List<ProductSub> productSubs  = productSubRepository.getAllProductSubByDetailProduct(id);
        Type listType = new TypeToken<List<ProductSubDto>>(){}.getType();
        List<ProductSubDto> postDtoList = modelMapper.map(productSubs,listType);
        return postDtoList;
    }


}
