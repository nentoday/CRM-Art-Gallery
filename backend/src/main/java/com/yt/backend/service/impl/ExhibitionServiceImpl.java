package com.yt.backend.service.impl;

import com.yt.backend.model.Exhibition;
import com.yt.backend.repository.ExhibitionRepository;
import com.yt.backend.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExhibitionServiceImpl implements ExhibitionService {
    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @Override
    public Exhibition addExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    @Override
    public Exhibition getExhibitionById(long id) {
        return exhibitionRepository.findById(id).get();
    }

    @Override
    public List<Exhibition> getExhibitions() {
        return (List<Exhibition>) exhibitionRepository.findAll();
    }

    @Override
    public void deleteExhibition(long id) {
        exhibitionRepository.deleteById(id);

    }
    @Override
    public Exhibition updateExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }
}
