package aobytes.banquetpro.dto;

import java.time.LocalTime;
import java.util.Date;


import aobytes.banquetpro.models.enums.EstadoEvento;
import lombok.Data;
@Data 
public class EventoDTO {
     
    private Date fechaEvento;
    private String nombre;
    private String descripcion;
    private String lugar;
    private String importe;
    private String notas;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long invitados;
    EstadoEvento estatus;
}
