package aobytes.banquetpro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "detalle_cotizacion")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class DetalleCotizacion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne 
    @JoinColumn (name = "id_evento")
    private EvetoEntity evento;

    private Double cantidad;
    @Column (name = "precio_unitario")
    private Double precioUnitario;
    private Double subtotal;
    
    @ManyToOne 
    @JoinColumn (name = "id_producto")
    private ProductoEntity producto;

}
