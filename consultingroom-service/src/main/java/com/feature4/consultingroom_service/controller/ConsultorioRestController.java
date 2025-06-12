package com.feature4.consultingroom_service.controller;


import com.feature4.consultingroom_service.dto.ConsultorioResponseDTO;
import com.feature4.consultingroom_service.dto.CreateConsultorioDto;
import com.feature4.consultingroom_service.service.ConsultorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultorio")
@AllArgsConstructor
public class ConsultorioRestController {
    private final ConsultorioService consultorioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultorioResponseDTO createConsultorio(@RequestBody CreateConsultorioDto consultorio) {
        return consultorioService.createConsultorio(consultorio);
    }

    @PutMapping("/{id}")
    public String updateConsultorio(@PathVariable("id") Long id, @RequestBody CreateConsultorioDto consultorio) {
        return consultorioService.updateConsultorio(id, consultorio);
    }

    @DeleteMapping("/{id}")
    public String deleteConsultorio(@PathVariable("id") Long id) {
        return consultorioService.deleteConsultorio(id);
    }
}
