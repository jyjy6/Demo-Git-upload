package org.iclass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iclass.entity.GalleryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GalleryDTO {

    private long idx;
    private String title;
    private String fileNames;
    private String writer;
    private LocalDateTime createdAt;


    private MultipartFile file;


    public static GalleryDTO of(GalleryEntity entity){
        return GalleryDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .fileNames(entity.getFileNames())
                .writer(entity.getWriter())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public GalleryEntity toEntity(){
        return GalleryEntity.builder()
                .idx(this.idx)
                .title(this.title)
                .fileNames(this.fileNames)
                .writer(this.writer)
                .build();
    }


}
