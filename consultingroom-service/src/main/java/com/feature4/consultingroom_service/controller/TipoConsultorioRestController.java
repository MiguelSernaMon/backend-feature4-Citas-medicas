package com.feature4.consultingroom_service.controller;

import com.feature4.consultingroom_service.model.TipoConsultorio;
import com.feature4.consultingroom_service.repository.TipoConsultorioRepository;
import com.feature4.consultingroom_service.service.TipoConsultorioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TipoConsultorioRestController {

    private final TipoConsultorioService tipoConsultorioService;

    @GetMapping("/tipo-consultorio")
    public List<TipoConsultorio> getTipoConsultorio() {
        return tipoConsultorioService.getAllTiposConsultorio() ;
    }
}
