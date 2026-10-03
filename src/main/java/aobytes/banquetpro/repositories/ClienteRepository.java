package aobytes.banquetpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.ClienteEntity;

public interface ClienteRepository extends JpaRepository <ClienteEntity, Long>{
    
}
