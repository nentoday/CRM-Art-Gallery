package com.yt.backend.repository;

import com.yt.backend.model.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworksRepository extends JpaRepository <ArtWork,Long> {
}
