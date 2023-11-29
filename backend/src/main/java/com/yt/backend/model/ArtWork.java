package com.yt.backend.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="artworks")
public class ArtWork {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int creation_year;
    private String description;
    private String technique;

    private String artist;
}
