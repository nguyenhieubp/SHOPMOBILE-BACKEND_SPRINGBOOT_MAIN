package com.example.MobileShop.Images;

import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.Images.Response.ResponseItemImage;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ModelMapper modelMapper;


    private Storage getStorage() throws IOException {
        InputStream inputStream = ImageService.class.getClassLoader().getResourceAsStream("firebase-private-key.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("mobile-shop-spring.appspot.com", fileName); // Replace with your bucker name
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = ImageService.class.getClassLoader().getResourceAsStream("firebase-private-key.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));

        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/mobile-shop-spring.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private void deleteFile(String fileName) throws IOException {
        BlobId blobId = BlobId.of("mobile-shop-spring.appspot.com", fileName); // Replace with your bucket name
        Storage storage = getStorage();
        storage.delete(blobId);
    }


    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String URL = this.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();

            Images image = new Images();
            image.setUrl(URL);
            imageRepository.save(image);

            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }


    public List<ResponseItemImage> getAll(){
        List<Images> images = imageRepository.findAll();
        Type listType = new TypeToken<List<ResponseItemImage>>() {}.getType();
        List<ResponseItemImage> responseItemImages = modelMapper.map(images, listType);
        return responseItemImages;
    }


    public ResponseItemImage getItemImage(UUID id){
        Images image = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not have image id"+id));
        ResponseItemImage imageResponse = modelMapper.map(image,ResponseItemImage.class);
        return imageResponse;
    }

    public String deleteImage(UUID id) {
        try {
            Images image = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not have image id " + id));
            String fileName = image.getUrl().substring(image.getUrl().lastIndexOf("/") + 1, image.getUrl().indexOf("?alt=media"));

            // Delete the file from Firebase
            deleteFile(fileName);

            // Delete the record from the database
            imageRepository.deleteById(id);

            return "Image deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't delete, Something went wrong";
        }
    }

    public String updateImage(UUID id, MultipartFile multipartFile) {
        try {
            Images image = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not have image id " + id));
            String oldFileName = image.getUrl().substring(image.getUrl().lastIndexOf("/") + 1, image.getUrl().indexOf("?alt=media"));

            // Delete the old file
            deleteFile(oldFileName);

            // Upload the new file
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

            File file = this.convertToFile(multipartFile, fileName);
            String URL = this.uploadFile(file, fileName);
            file.delete();

            // Update the image record in the database
            image.setUrl(URL);
            imageRepository.save(image);

            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't update, Something went wrong";
        }
    }
}
