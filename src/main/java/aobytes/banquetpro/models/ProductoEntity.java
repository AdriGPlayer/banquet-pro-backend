package aobytes.banquetpro.models;



import jakarta.persistence.Entity;
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
@Table (name = "productos")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ProductoEntity {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String concepto;
    private String descripcion;

    @OneToOne 
    @JoinColumn (name = "id_categoria")
    private CategoriaEntity categoria;

    private Double precio;
    private Double stock;
    private Boolean activo;
}
