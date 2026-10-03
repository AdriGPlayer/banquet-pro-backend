package aobytes.banquetpro.dto;

import lombok.Data;

/*Create evento */
@Data 
public class CEventoDTO {
    
    private EventoDTO evento;
    private ClienteDTO cliente;
}
