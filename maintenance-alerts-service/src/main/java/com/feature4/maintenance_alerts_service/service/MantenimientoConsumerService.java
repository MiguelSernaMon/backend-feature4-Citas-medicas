package com.feature4.maintenance_alerts_service.service;


import com.feature4.maintenance_alerts_service.model.MantenimientoCreatedEvent;
import com.feature4.maintenance_alerts_service.model.Notificacion;
import com.feature4.maintenance_alerts_service.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MantenimientoConsumerService {

    private final NotificacionRepository notificacionRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "mantenimiento-creado", groupId = "mantenimiento-group")
    public void consumirEventoMantenimiento(MantenimientoCreatedEvent evento) {
        // Convertir el evento en una notificación
        Notificacion notificacion = new Notificacion();
        notificacion.setConsultorioId(evento.getConsultorioId());
        notificacion.setCoordinadorUserId(evento.getCoordinadorUserId());
        notificacion.setFechaInicio(evento.getFechaInicio());
        notificacion.setFechaFin(evento.getFechaFin());
        notificacion.setMotivo(evento.getMotivo());
        notificacion.setLeida(false);

        // Guardar en base de datos
        notificacionRepository.save(notificacion);

        // Enviar notificación por WebSocket al coordinador específico
        messagingTemplate.convertAndSend(
                "/topic/notificaciones/",
                notificacion
        );
    }
}