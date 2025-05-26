package com.ejemplo.museo.repository;

import com.ejemplo.museo.model.Exposicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ExposicionRepository extends JpaRepository<Exposicion, Long> {
    @Query("SELECT e.titulo, e.descripcion FROM Exposicion e WHERE e.curador.sede.capacidad > 500")
    List<Object[]> findExposicionesConCuradorConSedeGrande();
}
