package org.iclass.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GalleryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;
    @Column(nullable = false)
    private String title;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private String fileNames;
    private String writer;

}
