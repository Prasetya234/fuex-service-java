package com.service.fuex.web.service;

import com.service.fuex.web.model.Vocher;

import java.util.List;
import java.util.Map;

public interface VocherService {

    List<Vocher> getAll();

    Vocher create(Vocher vocher);

    Vocher update(Long id, Vocher vocher);

    Map<String, Boolean> delete(Long id);
}
