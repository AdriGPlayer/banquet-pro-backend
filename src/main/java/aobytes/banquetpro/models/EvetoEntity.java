package aobytes.banquetpro.models;


import java.time.LocalTime;
import java.util.Date;

import aobytes.banquetpro.models.enums.EstadoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "eventos")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class EvetoEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "fecha_evento")
    private Date fechaEvento;
    private String nombre;
    private String descripcion;
    private String lugar;
    private String importe;
    private String notas;

    @Column (name = "hora_inicio")
    private LocalTime horaInicio;
    @Column (name = "hora_fin")
    private LocalTime horaFin;

    private Long invitados;

    @OneToOne 
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @Enumerated (EnumType.STRING)
    EstadoEvento estatus;
}
