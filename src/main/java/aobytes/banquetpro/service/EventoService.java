package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.CEventoDTO;
import aobytes.banquetpro.models.ClienteEntity;
import aobytes.banquetpro.models.EvetoEntity;
import aobytes.banquetpro.models.enums.EstadoEvento;
import aobytes.banquetpro.repositories.ClienteRepository;
import aobytes.banquetpro.repositories.EventoRepository;

@Service 
public class EventoService {

    @Autowired 
    private EventoRepository eventoRepository;
    @Autowired 
    private ClienteRepository clienteRepository;

   
    @Transactional
    public void saveEvento(CEventoDTO dto){
        EvetoEntity evento = new EvetoEntity();
        ClienteEntity cliente = new ClienteEntity();
        evento.setNombre(dto.getEvento().getNombre());
        evento.setDescripcion(dto.getEvento().getDescripcion());
        evento.setEstatus(dto.getEvento().getEstatus());
        evento.setFechaEvento(dto.getEvento().getFechaEvento());
        evento.setHoraFin(dto.getEvento().getHoraFin());
        evento.setHoraInicio(dto.getEvento().getHoraInicio());
        evento.setImporte(dto.getEvento().getImporte());
        evento.setInvitados(dto.getEvento().getInvitados());
        evento.setLugar(dto.getEvento().getLugar());
        evento.setNotas(dto.getEvento().getNotas());

        cliente.setNombre(dto.getCliente().getNombre());
        cliente.setApellidoM(dto.getCliente().getApellidoM());
        cliente.setApellidoP(dto.getCliente().getApellidoP());
        cliente.setEmail(dto.getCliente().getEmail());
        cliente.setTelefono(dto.getCliente().getTelefono());

        ClienteEntity savedCliente = clienteRepository.save(cliente);
        evento.setCliente(savedCliente);
        eventoRepository.save(evento);
    }

    public List<EvetoEntity> getEventosPendientes() {
        return eventoRepository.findByEstatus(EstadoEvento.PENDIENTE);
    }

    
}
