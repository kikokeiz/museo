package com.ejemplo.museo;

import com.ejemplo.museo.model.*;
import com.ejemplo.museo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CuradorRepository curadorRepo;
    private final SedeRepository sedeRepo;
    private final ExposicionRepository expoRepo;

    public DataLoader(CuradorRepository curadorRepo, SedeRepository sedeRepo, ExposicionRepository expoRepo) {
        this.curadorRepo = curadorRepo;
        this.sedeRepo = sedeRepo;
        this.expoRepo = expoRepo;
    }

    @Override
    public void run(String... args) {
        Curador c1 = new Curador();
        c1.setNombre("Ana Torres");
        c1.setNumeroEmpleado("C001");

        Sede s1 = new Sede();
        s1.setDireccion("Av. Reforma 123");
        s1.setCapacidad(800);
        s1.setCurador(c1);
        c1.setSede(s1);

        Exposicion e1 = new Exposicion();
        e1.setTitulo("Arte Moderno");
        e1.setDescripcion("Una visión contemporánea");
        e1.setCurador(c1);
        c1.setExposiciones(List.of(e1));

        curadorRepo.save(c1);

        Curador c2 = new Curador();
        c2.setNombre("Luis Gómez");
        c2.setNumeroEmpleado("C002");

        Sede s2 = new Sede();
        s2.setDireccion("Calle Hidalgo 55");
        s2.setCapacidad(60);
        s2.setCurador(c2);
        c2.setSede(s2);

        curadorRepo.save(c2);

        // Consultas
        System.out.println("🔍 Curadores sin exposiciones:");
        curadorRepo.findByExposicionesIsEmpty().forEach(c ->
                System.out.println(" - " + c.getNombre())
        );

        System.out.println("🔍 Exposiciones con sede > 500:");
        expoRepo.findExposicionesConCuradorConSedeGrande().forEach(row ->
                System.out.println(" - " + row[0] + ": " + row[1])
        );

        System.out.println("🔍 Curadores con sede < 100:");
        curadorRepo.findCuradoresConSedePequena().forEach(row ->
                System.out.println(" - " + row[0] + " (" + row[1] + ")")
        );
    }
}
