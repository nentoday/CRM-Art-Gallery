package com.yt.backend.service;

import com.yt.backend.model.Exhibition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExhibitionService {

    Exhibition addExhibition(Exhibition exhibition);

    Exhibition getExhibitionById(long id);

    List<Exhibition> getExhibition();

    Exhibition updateExhibition(Exhibition exhibition);

    void deleteExhibition(long id);


}
