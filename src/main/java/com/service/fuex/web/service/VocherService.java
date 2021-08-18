package com.service.fuex.web.service;

import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.response.CommonResponse;

import java.util.List;

public interface VocherService {

    List<Vocher> getAll();

    Vocher create(Vocher vocher);

    CommonResponse<Vocher> update(Long id, Vocher vocher);

    CommonResponse<Vocher> delete(Long id);
}
