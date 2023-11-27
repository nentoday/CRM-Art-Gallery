package com.yt.backend.controller;

import com.yt.backend.model.ArtWork;
import com.yt.backend.service.ArtworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class ArtworkController {
    @Autowired
    private ArtworksService artworksService;
    //add artwork
    @PostMapping("/artwork/add")
    public String addArtwork(@RequestBody ArtWork artWork){
        artworksService.addArtwork(artWork);
        return "Artwork Added Successfully..";
    }
    //get artwork
    @RequestMapping("/artwork/{id}")
    public ArtWork getArtWorkById(@PathVariable("id") long id){return artworksService.getArtworkById(id);}

    //get all artworks
    @RequestMapping("/artworks")
    public List<ArtWork> getArtworks(){return artworksService.getArtworks();}

    //update artwork detail
    @PutMapping("/artwork")
    public ArtWork updateArtwork(@RequestBody ArtWork artWork){return artworksService.updateArtwork(artWork);}
    //delete
    @DeleteMapping("/artwork/{id}")
    public String deleteArtwork(@PathVariable("id") long id){
        artworksService.deleteArtwork(id);
        return "Artwork Successfully Deleted";
    }
    @GetMapping
    public List<ArtWork> searchArtworks(@RequestParam(name = "title", required = false) String title) {
        if (title != null) {
            return artworksService.findByTitle(title);
        } else {
            return artworksService.getArtworks();
        }
    }
}
