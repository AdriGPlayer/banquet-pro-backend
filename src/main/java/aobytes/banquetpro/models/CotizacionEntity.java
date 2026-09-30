package aobytes.banquetpro.models;

import java.util.Date;

import aobytes.banquetpro.models.enums.EstatoCotizacion;
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
@Table (name = "cotizaciones")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CotizacionEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne 
    @JoinColumn (name = "id_cliente")
    private ClienteEntity cliente;
    
    @OneToOne 
    @JoinColumn (name = "id_evento")
    private EvetoEntity evento;

    @Column (name = "fecha_evento")
    private Date fechaEvento;

    @Enumerated (EnumType.STRING)
    private EstatoCotizacion estatus;

    private Double total;

    @Column (name = "presupuesto_cliente")
    private Double presupuestoCliente;
}
