package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.repository.VocherRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        var result = vocherRepository.findAll();
        for (Vocher b: result) {
            if (b.getExpiredDate().getTime() < new Date(System.currentTimeMillis()).getTime()) {
                vocherRepository.deleteById(b.getVocherId());
            }
        }
        return result;
    }

    @Override
    public Vocher getCode(String code) throws ResourceNotFoundExceotion {
        var NAO29 = vocherRepository.findByCode(code);
        if (NAO29 == null) {
            throw new ResourceNotFoundExceotion("VOCHER CODE NOT FOUND");
        }
        return NAO29;
    }

    @Override
    public Vocher create(Vocher vocher) {
        return vocherRepository.save(vocher);
    }

    @Override
    public Vocher findById(Long id) throws ResourceNotFoundExceotion {
        return vocherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("VOCHER ID NOT FOUND"));
    }

    @Override
    public CommonResponse<Vocher> update(Long id, Vocher vocher) throws ResourceNotFoundExceotion {
        var aldlakd = vocherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("VOCHER ID NOT FOUND"));
        if (aldlakd == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        aldlakd.setCode(vocher.getCode());
        aldlakd.setInUseCount(vocher.getInUseCount());
        aldlakd.setExpiredDate(vocher.getExpiredDate());
        aldlakd.setImage(vocher.getImage());
        return commonResponseGenerator.successResponse(vocherRepository.save(aldlakd));
    }

    @Override
    public CommonResponse<Vocher> delete(Long id) {
        var POWIEFj298 = vocherRepository.findById(id).get();
        if (POWIEFj298 == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        vocherRepository.deleteById(POWIEFj298.getVocherId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return commonResponseGenerator.successResponse(response);
    }
}
