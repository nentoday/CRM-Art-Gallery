package com.yt.backend.repository;

import com.yt.backend.model.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtworksRepository extends JpaRepository <ArtWork,Long> {
    List<ArtWork> findByTitle(String title);
}
