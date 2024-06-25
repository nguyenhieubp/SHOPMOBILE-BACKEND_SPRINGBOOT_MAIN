package com.example.MobileShop.Images;

import com.example.MobileShop.Categories.Categories;
import com.example.MobileShop.Config.FormatResponse.ApiResponse;
import com.example.MobileShop.Images.Response.ResponseItemImage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(),"success",imageService.upload(file));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllImage(){
        ApiResponse<List<ResponseItemImage>> response = new ApiResponse<>(HttpStatus.OK.value(),"success",imageService.getAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getItemImage(@PathVariable UUID id){
        ApiResponse<ResponseItemImage> response = new ApiResponse<>(HttpStatus.OK.value(),"success",imageService.getItemImage(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable UUID id) {
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(),"success",imageService.deleteImage(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImage(@PathVariable UUID id, @RequestParam("file") MultipartFile file) {
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(),"success",imageService.updateImage(id,file));
        return ResponseEntity.ok(response);
    }

}
