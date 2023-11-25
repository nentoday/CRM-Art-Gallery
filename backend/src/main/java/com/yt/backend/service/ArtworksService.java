package com.yt.backend.service;

import com.yt.backend.model.ArtWork;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtworksService {
    ArtWork addArtwork(ArtWork artWork);
    ArtWork getArtworkById(long id);
    List<ArtWork> getArtworks();
    void deleteArtwork(long id);
    ArtWork updateArtwork(ArtWork artWork);
}
