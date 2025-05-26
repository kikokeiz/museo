// Sede.java
import jakarta.persistence.*;

@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private int capacidad;

    @OneToOne
    @JoinColumn(name = "curador_id")
    private Curador curador;

    // Getters y setters

}
