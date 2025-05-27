package com.kiko.app.repository;

import com.kiko.app.entity.Curador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuradorRepository extends JpaRepository<Curador, Long> {

    Optional<Curador> findByNombre(String nombre);

    List<Curador> findByExposicionesIsEmpty();

    @Query("SELECT c.nombre, c.sede.direccion FROM Curador c WHERE c.sede.capacidad < 100")
    List<Object[]> findCuradoresConSedePequena();
}
