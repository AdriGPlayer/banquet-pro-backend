package aobytes.banquetpro.dto;

import lombok.Data;

@Data
public class DetalleCotizacionDTO {
    private Long idEvento;
    private Long idProducto;
    private Double cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
