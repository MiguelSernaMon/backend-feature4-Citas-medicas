package com.feature4.consultingroom_service.service;

import com.feature4.consultingroom_service.model.TipoConsultorio;
import com.feature4.consultingroom_service.repository.TipoConsultorioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoConsultorioService {

    private final TipoConsultorioRepository tipoConsultorioRepository;

    public List<TipoConsultorio> getAllTiposConsultorio() {
        return tipoConsultorioRepository.findAll();
    }
}
