package com.feature4.consultingroom_service.dto;

public record ConsultorioResponseDTO(
        Long id_consultorio,
        String numero_consultorio,
        String tipo,
        String estado,
        String sede,
        String ciudad
) {

}
