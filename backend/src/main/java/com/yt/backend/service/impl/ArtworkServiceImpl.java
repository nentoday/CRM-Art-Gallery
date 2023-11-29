package com.yt.backend.service.impl;

import com.yt.backend.model.ArtWork;
import com.yt.backend.repository.ArtworksRepository;
import com.yt.backend.service.ArtworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkServiceImpl implements ArtworksService {
    @Autowired
    private ArtworksRepository artworksRepository;

    @Override
    public ArtWork addArtwork(ArtWork artWork) {
        return artworksRepository.save(artWork);
    }

    @Override
    public ArtWork getArtworkById(long id) {
        return artworksRepository.findById(id).get();
    }

    @Override
    public List<ArtWork> getArtworks() {
        return (List<ArtWork>) artworksRepository.findAll();
    }

    @Override
    public void deleteArtwork(long id) {
        artworksRepository.deleteById(id);
    }
    @Override
    public ArtWork updateArtwork(ArtWork artWork) {
        return artworksRepository.save(artWork);
    }

    @Override
    public List<ArtWork> findByTitle(String title) {
        return artworksRepository.findByTitle(title);
    }
}
