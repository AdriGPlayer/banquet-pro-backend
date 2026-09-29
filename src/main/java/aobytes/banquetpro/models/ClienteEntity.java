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
@Table (name = "clientes")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column (name = "apellido_materno")
    private String apellidoM;
    @Column (name = "apellido_paterno")
    private String apellidoP;
    private String email;
    private String telefono;


}
