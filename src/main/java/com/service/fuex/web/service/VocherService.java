package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.response.CommonResponse;

import java.util.List;

public interface VocherService {

    List<Vocher> getAll();

    Vocher getCode(String code) throws ResourceNotFoundExceotion;

    Vocher create(Vocher vocher);

    CommonResponse<Vocher> update(Long id, Vocher vocher) throws ResourceNotFoundExceotion;

    CommonResponse<Vocher> delete(Long id);
}
