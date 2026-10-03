package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.ClienteDTO;
import aobytes.banquetpro.models.ClienteEntity;
import aobytes.banquetpro.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity saveCliente(ClienteDTO dto) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(dto.getNombre());
        entity.setApellidoM(dto.getApellidoM());
        entity.setApellidoP(dto.getApellidoP());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        return clienteRepository.save(entity);
    }

    public List<ClienteEntity> getAllClientes() {
        return clienteRepository.findAll();
    }

    public ClienteEntity getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Transactional
    public ClienteEntity updateCliente(Long id, ClienteDTO dto) {
        ClienteEntity entity = clienteRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        entity.setNombre(dto.getNombre());
        entity.setApellidoM(dto.getApellidoM());
        entity.setApellidoP(dto.getApellidoP());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        return clienteRepository.save(entity);
    }

    @Transactional
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
