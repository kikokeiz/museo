package com.ejemplo.museo.repository;

import com.ejemplo.museo.model.Curador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CuradorRepository extends JpaRepository<Curador, Long> {
    List<Curador> findByExposicionesIsEmpty();

    @Query("SELECT c.nombre, c.sede.direccion FROM Curador c WHERE c.sede.capacidad < 100")
    List<Object[]> findCuradoresConSedePequena();
}
