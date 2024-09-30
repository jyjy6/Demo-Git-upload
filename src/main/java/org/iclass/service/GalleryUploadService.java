package org.iclass.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iclass.dto.GalleryDTO;
import org.iclass.entity.GalleryEntity;
import org.iclass.repository.GalleryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class GalleryUploadService {
    private final GalleryRepository galleryRepository;

    public void uploadGallery(GalleryDTO dto) throws IOException {
        MultipartFile file = dto.getFile();
        String path = "c:\\upload";
        if(file.getSize() != 0){
            File pathFile = new File(path+"\\"+file.getOriginalFilename());
            file.transferTo(pathFile);
            dto.setFileNames(file.getOriginalFilename());
            galleryRepository.save(dto.toEntity());

        }

    }

    public GalleryDTO one(Long i) {
        GalleryEntity entity = galleryRepository.findById(i).orElseThrow(() -> new RuntimeException("Value not found!"));
        return GalleryDTO.of(entity);
    }
}
