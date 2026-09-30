package aobytes.banquetpro.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String apellidoM;
    private String apellidoP;
    private String correo;
}
