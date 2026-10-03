package aobytes.banquetpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aobytes.banquetpro.dto.CEventoDTO;
import aobytes.banquetpro.service.EventoService;

@RestController 
@RequestMapping ("/banquetpro/api/event")
@CrossOrigin (origins = "http://localhost:5173")
public class EventoController {

    @Autowired 
    private EventoService eventoService;


    @PostMapping ("/saveEvent")
    public ResponseEntity<String> saveEvent(@RequestBody CEventoDTO dto){
        eventoService.saveEvento(dto);
        return ResponseEntity.ok("Event Saved Succesfully");
    }
    
}
