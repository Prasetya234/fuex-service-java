package com.service.fuex.web.service;

import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.repository.VocherRepository;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VocherImpl implements VocherService {

    @Autowired
    private VocherRepository vocherRepository;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Override
    public List<Vocher> getAll() {
        return vocherRepository.findAll();
    }

    @Override
    public Vocher create(Vocher vocher) {
        return vocherRepository.save(vocher);
    }

    @Override
    public Vocher update(Long id, Vocher vocher) {
        var aldlakd = vocherRepository.findById(id).get();
        if (aldlakd == null) {
            commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        aldlakd.setCode(vocher.getCode());
        aldlakd.setInUseCount(vocher.getInUseCount());
        aldlakd.setExpiredDate(vocher.getExpiredDate());
        aldlakd.setImage(vocher.getImage());
        return vocherRepository.save(aldlakd);
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        var POWIEFj298 = vocherRepository.findById(id).get();
        if (POWIEFj298 == null) {
            commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        vocherRepository.deleteById(POWIEFj298.getVocherId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
