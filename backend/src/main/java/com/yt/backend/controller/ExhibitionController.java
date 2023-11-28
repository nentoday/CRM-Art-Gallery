package com.yt.backend.controller;

import com.yt.backend.model.Exhibition;
import com.yt.backend.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ExhibitionController {

    @Autowired
    private ExhibitionService exhibitionService;

    @PostMapping("/exhibition/add")
    public String addExhibition(@RequestBody Exhibition exhibition){
        exhibitionService.addExhibition(exhibition);
        return "Exhibition added successfully";
    }
    @RequestMapping("/exhibition/{id}")
    public Exhibition getExhibitionById(@PathVariable("id") long id){return exhibitionService.getExhibitionById(id);}

    @RequestMapping("/exhibition")
    public List<Exhibition> getExhibition(){return exhibitionService.getExhibition();}

    @PutMapping("/exhibition")
    public Exhibition updateExhibition(@RequestBody Exhibition exhibition){return exhibitionService.updateExhibition(exhibition);}
    @DeleteMapping("/exhibition/{id}")
    public String deleteExhibition(@PathVariable("id") long id){
        exhibitionService.deleteExhibition(id);
        return "Exhibition Successfully Deleted";
    }

}
