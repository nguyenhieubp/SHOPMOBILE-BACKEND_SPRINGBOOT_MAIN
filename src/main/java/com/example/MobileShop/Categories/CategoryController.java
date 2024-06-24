package com.example.MobileShop.Categories;

import com.example.MobileShop.Categories.Resquest.RequestCategoryChangeName;
import com.example.MobileShop.Categories.Resquest.RequestSetParentCategory;
import com.example.MobileShop.Config.FormatResponse.ApiResponse;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String helloworld(){
        return "Hello world";
    }

    @PostMapping("/add")
    public ResponseEntity<?> craeteCateegory(@Valid @RequestBody CategoryDto categoryDto){
        ApiResponse<Categories> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.createCategory(categoryDto));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategory(){
        ApiResponse<List<Categories>> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.getAllCategory());
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<?> updateName(@PathVariable UUID id,@RequestBody RequestCategoryChangeName name){
        ApiResponse<Categories> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.updateNameCategory(id,name));
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/getAll/category-parent")
    public ResponseEntity<?> getAllCategoryParent(){
        ApiResponse<List<Categories>> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.getAllCategoryParent());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getChildren/{parentId}")
    public ResponseEntity<?> getAllChildrenByParentId(@PathVariable UUID parentId){
        ApiResponse<List<Categories>> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.getAllChildrenByParentId(parentId));
        return ResponseEntity.ok().body(response);
    }


    @PatchMapping("/setNullParentCategory/{id}")
    public ResponseEntity<?> setNullParentCategoryById(@PathVariable UUID id){
        ApiResponse<Categories> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.setNullParentCategoryById(id));
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/setParentForCategory/{id}")
    public ResponseEntity<?> setParentCategory(@PathVariable UUID id,@RequestBody RequestSetParentCategory categoryParent){
        ApiResponse<Categories> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.setParentForCategory(id,categoryParent));
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id){
        ApiResponse<Boolean> response = new ApiResponse<>(HttpStatus.OK.value(),"success",categoryService.deleteCategory(id));
        return ResponseEntity.ok().body(response);
    }

}
