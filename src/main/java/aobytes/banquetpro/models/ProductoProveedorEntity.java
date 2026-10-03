package aobytes.banquetpro.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity producto;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "codigo_proveedor")
    private String codigoProveedor;
}