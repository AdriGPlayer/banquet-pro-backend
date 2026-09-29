package aobytes.banquetpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
