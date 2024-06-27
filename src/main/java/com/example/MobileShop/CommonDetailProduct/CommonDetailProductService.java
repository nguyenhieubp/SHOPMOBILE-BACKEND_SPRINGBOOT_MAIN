package com.example.MobileShop.CommonDetailProduct;


import com.example.MobileShop.Categories.Categories;
import com.example.MobileShop.Categories.CategoriesRepository;
import com.example.MobileShop.CommonDetailProduct.Request.ChangeQuantityOfGoods;
import com.example.MobileShop.CommonDetailProduct.Request.CommonDetailProductRequest;
import com.example.MobileShop.CommonDetailProduct.Response.CommonDetailProductResponse;
import com.example.MobileShop.CommonDetailProduct.Response.CommonDetailProductResponseWrapper;
import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.Images.ImageRepository;
import com.example.MobileShop.Images.Images;
import com.example.MobileShop.ProductType.ProductType;
import com.example.MobileShop.ProductType.ProductTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommonDetailProductService {
    @Autowired
    private CommonDetailProductRepository commonDetailProductRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;


    @Autowired
    private ModelMapper modelMapper;

    public CommonDetailProductResponseWrapper getAllCommonDetailProducts(Integer pageNo,Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<CommonDetailProduct> listCommonDetail = commonDetailProductRepository.findAll(paging);
        Page<CommonDetailProductResponse> products = mapToResponsePage(listCommonDetail);
        long count = products.stream().count();
        return new CommonDetailProductResponseWrapper(count, products);
    }

    public CommonDetailProductResponse getCommonDetailProductById(UUID itemId) {
        CommonDetailProduct commonDetailProduct = findCommonDetailProductById(itemId);
        return modelMapper.map(commonDetailProduct, CommonDetailProductResponse.class);
    }

    public CommonDetailProductResponse createCommonDetailProduct(CommonDetailProductRequest newCommonDetailProduct) {
        // Ánh xạ các thuộc tính từ request thành đối tượng CommonDetailProduct
        CommonDetailProduct commonDetailProduct = modelMapper.map(newCommonDetailProduct, CommonDetailProduct.class);

        // Lấy đối tượng Images từ imageId và set vào CommonDetailProduct
        Images image = imageRepository.findById(newCommonDetailProduct.getImageId())
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + newCommonDetailProduct.getImageId()));
        commonDetailProduct.setImages(image);

        // Lấy đối tượng Categories từ categoryId và set vào CommonDetailProduct
        Categories category = categoriesRepository.findById(newCommonDetailProduct.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + newCommonDetailProduct.getCategoryId()));
        commonDetailProduct.setCategory(category);

        // Lấy đối tượng ProductType từ productTypeId và set vào CommonDetailProduct
        ProductType productType = productTypeRepository.findById(newCommonDetailProduct.getProductTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("ProductType not found with id: " + newCommonDetailProduct.getProductTypeId()));
        commonDetailProduct.setType(productType);

        // Lưu CommonDetailProduct đã được cập nhật vào cơ sở dữ liệu
        CommonDetailProduct savedProduct = commonDetailProductRepository.save(commonDetailProduct);

        // Ánh xạ lại savedProduct thành CommonDetailProductResponse và trả về
        return modelMapper.map(savedProduct, CommonDetailProductResponse.class);
    }


    public CommonDetailProductResponse updateCommonDetailProduct(UUID itemId, CommonDetailProductRequest updatedCommonDetailProduct) {
        CommonDetailProduct existingProduct = findCommonDetailProductById(itemId);

        // Update basic fields
        existingProduct.setTitle(updatedCommonDetailProduct.getTitle());
        existingProduct.setPrice(updatedCommonDetailProduct.getPrice());
        existingProduct.setDescription(updatedCommonDetailProduct.getDescription());
        existingProduct.setQuantity_of_goods(updatedCommonDetailProduct.getQuantity_of_goods());
        existingProduct.setWarranty(updatedCommonDetailProduct.getWarranty());

        // Update image if provided in updatedCommonDetailProduct
        if (updatedCommonDetailProduct.getImageId() != null) {
            Images image = imageRepository.findById(updatedCommonDetailProduct.getImageId()).orElse(null);
            existingProduct.setImages(image);
        }

        // Update category if provided in updatedCommonDetailProduct
        if (updatedCommonDetailProduct.getCategoryId() != null) {
            Categories category = categoriesRepository.findById(updatedCommonDetailProduct.getCategoryId()).orElse(null);
            existingProduct.setCategory(category);
        }

        // Update product type if provided in updatedCommonDetailProduct
        if (updatedCommonDetailProduct.getProductTypeId() != null) {
            ProductType productType = productTypeRepository.findById(updatedCommonDetailProduct.getProductTypeId()).orElse(null);
            existingProduct.setType(productType);
        }

        CommonDetailProduct updatedProduct = commonDetailProductRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, CommonDetailProductResponse.class);
    }

    public boolean deleteCommonDetailProduct(double itemId) {
        try {
            commonDetailProductRepository.deleteCommonDetail(itemId);
            return true; // Xóa thành công
        } catch (Exception e) {
            return false; // Xóa thất bại
        }
    };

    private CommonDetailProduct findCommonDetailProductById(UUID itemId) {
        return commonDetailProductRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("CommonDetailProduct not found with id: " + itemId));
    }

    private List<CommonDetailProductResponse> mapToResponseList(List<CommonDetailProduct> products) {
        return products.stream()
                .map(product -> modelMapper.map(product, CommonDetailProductResponse.class))
                .collect(Collectors.toList());
    }

    private Page<CommonDetailProductResponse> mapToResponsePage(Page<CommonDetailProduct> products) {
        List<CommonDetailProductResponse> responseList = products.stream()
                .map(product -> modelMapper.map(product, CommonDetailProductResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(responseList, products.getPageable(), products.getTotalElements());
    }

    public List<CommonDetailProductResponse> searchProducts(String category, String type, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), "price");
        return mapToResponseList((commonDetailProductRepository.searchProducts(sort,category, type)));
    }


    public List<CommonDetailProductResponse> getForMobile() {
        List<CommonDetailProduct> commonDetailProductResponses = commonDetailProductRepository.findProductsWithNonEmptySubs();
        return  mapToResponseList(commonDetailProductResponses);
    }


    public List<CommonDetailProductResponse> getAllProductSub() {
        List<CommonDetailProduct> commonDetailProductResponses = commonDetailProductRepository.findProductsSub();
        return  mapToResponseList(commonDetailProductResponses);
    }


    public Object changeQuantityOfGoods(UUID id,ChangeQuantityOfGoods changeQuantityOfGoods) {
        CommonDetailProduct commonDetailProduct =  findCommonDetailProductById(id);
        if(changeQuantityOfGoods.getCalc().equals("increment")){
            commonDetailProduct.setQuantity_of_goods(commonDetailProduct.getQuantity_of_goods() + changeQuantityOfGoods.getQuantity());
        }
        else if(changeQuantityOfGoods.getCalc().equals("decrement")){
            if(commonDetailProduct.getQuantity_of_goods() - changeQuantityOfGoods.getQuantity() < 0){
                return "Không đủ sản phẩm";
            }
            commonDetailProduct.setQuantity_of_goods(commonDetailProduct.getQuantity_of_goods() - changeQuantityOfGoods.getQuantity());
        }

        CommonDetailProduct commonDetail = commonDetailProductRepository.save(commonDetailProduct);
        return modelMapper.map(commonDetail,CommonDetailProductResponse.class);
    }


}
