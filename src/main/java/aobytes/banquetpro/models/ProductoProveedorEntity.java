package aobytes.banquetpro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity 
@Table (name = "producto_proveedor")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ProductoProveedorEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private ProveedorEntity proveedor;
    private ProductoEntity producto;
    @Column (name = "precio_venta")
    private Double precioVenta;
    @Column (name="codigo_proveedor")
    private String codigoProveedor;
}
