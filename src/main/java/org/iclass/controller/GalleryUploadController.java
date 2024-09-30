package org.iclass.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iclass.dto.GalleryDTO;
import org.iclass.repository.GalleryRepository;
import org.iclass.service.GalleryUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GalleryUploadController {
    private final GalleryRepository galleryRepository;
    private final GalleryUploadService galleryUploadService;



    @GetMapping("/gallery")
    public String gallery(Model model){
        GalleryDTO dto = galleryUploadService.one(21L);
        model.addAttribute("dto", dto);
        return "gallery";
    }

    @PostMapping("/gallery")
    public String upload(GalleryDTO dto) throws IOException {
        MultipartFile file = dto.getFile();
        System.out.println("파일명:"+file.getOriginalFilename());
        System.out.println("파일사이즈:"+file.getSize());

        galleryUploadService.uploadGallery(dto);
        return "redirect:/gallery";
    }
}
