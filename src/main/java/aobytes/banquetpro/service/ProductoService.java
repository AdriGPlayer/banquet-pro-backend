package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.ProductoDTO;
import aobytes.banquetpro.models.CategoriaEntity;
import aobytes.banquetpro.models.ProductoEntity;
import aobytes.banquetpro.repositories.CategoriaRepository;
import aobytes.banquetpro.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public ProductoEntity saveProducto(ProductoDTO dto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setConcepto(dto.getConcepto());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        entity.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        if (dto.getIdCategoria() != null) {
            CategoriaEntity cat = categoriaRepository.findById(dto.getIdCategoria()).orElse(null);
            entity.setCategoria(cat);
        }
        return productoRepository.save(entity);
    }

    public List<ProductoEntity> getAllProductos() {
        return productoRepository.findAll();
    }

    public ProductoEntity getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Transactional
    public ProductoEntity updateProducto(Long id, ProductoDTO dto) {
        ProductoEntity entity = productoRepository.findById(id).orElse(null);
        if (entity == null) return null;
        entity.setConcepto(dto.getConcepto());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());
        if (dto.getIdCategoria() != null) {
            CategoriaEntity cat = categoriaRepository.findById(dto.getIdCategoria()).orElse(null);
            entity.setCategoria(cat);
        }
        return productoRepository.save(entity);
    }

    @Transactional
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
