package aobytes.banquetpro.dto;

import java.util.Date;
import java.util.List;

import aobytes.banquetpro.models.enums.EstatoCotizacion;
import lombok.Data;

@Data
public class CotizacionDTO {
    private Long idCliente;
    private Long idEvento;
    private Date fechaEvento;
    private EstatoCotizacion estatus;
    private Double total;
    private Double presupuestoCliente;
    private List<DetalleCotizacionDTO> detalles;
}
