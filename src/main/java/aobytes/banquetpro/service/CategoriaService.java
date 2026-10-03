package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.CategoriaDTO;
import aobytes.banquetpro.models.CategoriaEntity;
import aobytes.banquetpro.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public CategoriaEntity saveCategoria(CategoriaDTO dto) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNombre(dto.getNombre());
        return categoriaRepository.save(entity);
    }

    public List<CategoriaEntity> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaEntity getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Transactional
    public CategoriaEntity updateCategoria(Long id, CategoriaDTO dto) {
        CategoriaEntity entity = categoriaRepository.findById(id).orElse(null);
        if (entity == null) return null;
        entity.setNombre(dto.getNombre());
        return categoriaRepository.save(entity);
    }

    @Transactional
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
