package aobytes.banquetpro.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MovimientoDTO {
    private String concepto;
    private String tipo;
    private Double monto;
    private Date fecha;
}
