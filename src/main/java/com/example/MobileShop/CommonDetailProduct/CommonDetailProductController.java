package com.example.MobileShop.CommonDetailProduct;

import com.example.MobileShop.CommonDetailProduct.Request.ChangeQuantityOfGoods;
import com.example.MobileShop.CommonDetailProduct.Request.CommonDetailProductRequest;
import com.example.MobileShop.CommonDetailProduct.Response.CommonDetailProductResponse;
import com.example.MobileShop.CommonDetailProduct.Response.CommonDetailProductResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/common-detail-products")
public class CommonDetailProductController {
    @Autowired
    private CommonDetailProductService commonDetailProductService;

    // Lấy danh sách tất cả sản phẩm chi tiết thông chung
    @GetMapping("/all")
    public ResponseEntity<CommonDetailProductResponseWrapper> getAllCommonDetailProducts() {
        CommonDetailProductResponseWrapper products  = commonDetailProductService.getAllCommonDetailProducts();
        return ResponseEntity.ok().body(products);
    }

    // Lấy chi tiết sản phẩm dựa trên ID
    @GetMapping("/{itemId}")
    public ResponseEntity<CommonDetailProductResponse> getCommonDetailProductById(@PathVariable UUID itemId) {
        CommonDetailProductResponse product = commonDetailProductService.getCommonDetailProductById(itemId);
        return ResponseEntity.ok().body(product);
    }

    // Tạo mới một sản phẩm chi tiết thông chung
    @PostMapping("/add")
    public ResponseEntity<CommonDetailProductResponse> createCommonDetailProduct(@RequestBody CommonDetailProductRequest request) {
        CommonDetailProductResponse response = commonDetailProductService.createCommonDetailProduct(request);
        return ResponseEntity.ok().body(response);
    }

    // Cập nhật thông tin sản phẩm dựa trên ID
    @PutMapping("/{itemId}")
    public ResponseEntity<CommonDetailProductResponse> updateCommonDetailProduct(
            @PathVariable UUID itemId,
            @RequestBody CommonDetailProductRequest updatedCommonDetailProduct) {
        CommonDetailProductResponse updatedProduct = commonDetailProductService.updateCommonDetailProduct(itemId, updatedCommonDetailProduct);
        return ResponseEntity.ok().body(updatedProduct);
    }

    // Xóa sản phẩm dựa trên ID
    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCommonDetailProduct(@PathVariable double code) {
        commonDetailProductService.deleteCommonDetailProduct(code);
        return ResponseEntity.ok("DELETE SUCCESS");
    }


    @GetMapping("/search")
    public List<CommonDetailProductResponse> searchProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type,
            @RequestParam(required = false, defaultValue = "asc") String sort) {
        String sortDirection = sort.equalsIgnoreCase("desc") ? "DESC" : "ASC";
        List<CommonDetailProductResponse> products = commonDetailProductService.searchProducts(category, type, sortDirection);
        return products;
    }


    @GetMapping("/getForMobile")
    public List<CommonDetailProductResponse> getAllForMobile (){
       return commonDetailProductService.getForMobile();
    }


    @GetMapping("/getAllProductSub")
    public List<CommonDetailProductResponse> getAllProductSub(){
        return commonDetailProductService.getAllProductSub();
    }

    @PatchMapping("/change-quantity-of-goods/{id}")
    public Object changeQuantityOfGoods(@PathVariable UUID id,@RequestBody ChangeQuantityOfGoods changeQuantityOfGoods){
        return commonDetailProductService.changeQuantityOfGoods(id,changeQuantityOfGoods);
    }

}
