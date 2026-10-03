package aobytes.banquetpro.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private String concepto;
    private String descripcion;
    private Long idCategoria;
    private Double precio;
    private Double stock;
    private Boolean activo;
}
