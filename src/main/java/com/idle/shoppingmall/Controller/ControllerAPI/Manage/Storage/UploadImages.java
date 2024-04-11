package com.idle.shoppingmall.Controller.ControllerAPI.Manage.Storage;

import com.idle.shoppingmall.Entity.Product.ProductImg;
import com.idle.shoppingmall.Service.Storage.NCPObjectStorageService;
import com.idle.shoppingmall.Service.Storage.UploadProductImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UploadImages {
    private final UploadProductImgService uploadService;
    private final NCPObjectStorageService ncpObjectStorageService;

    private String bucketName = "miniidle";

    public void productUploadImages(List<MultipartFile> images, Long id){
        String imageFileName = "";
        String imageOriginalName = "";

        List<ProductImg> productImgList = new ArrayList<>();

        for(MultipartFile img : images){
            imageOriginalName = img.getOriginalFilename();
            imageFileName = ncpObjectStorageService.uploadFile(bucketName, "storage/", img);

            ProductImg productImg = ProductImg.builder()
                    .product_id(id)
                    .img_url(imageFileName)
                    .img_name(imageOriginalName)
                    .created_who(1L)
                    .created_at(LocalDateTime.now())
                    .build();
            productImgList.add(productImg);
        }
        uploadService.upload(productImgList);
    }
}
