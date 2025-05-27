package com.kiko.app.repository;


import com.kiko.app.entity.Exposicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExposicionRepository extends JpaRepository<Exposicion, Long> {
    @Query("SELECT e.titulo, e.descripcion FROM Exposicion e WHERE e.curador.sede.capacidad > 500")
    List<Object[]> findExposicionesConCuradorConSedeGrande();
}
