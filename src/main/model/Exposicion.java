// Exposicion.java
import jakarta.persistence.*;

@Entity
public class Exposicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "curador_id")
    private Curador curador;

    // Getters y setters
}
