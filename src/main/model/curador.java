// Curador.java
import jakarta.persistence.*;
import java.util.List;

@Entity
public class curador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String numeroEmpleado;

    @OneToOne(mappedBy = "curador", cascade = CascadeType.ALL)
    private Sede sede;

    @OneToMany(mappedBy = "curador", cascade = CascadeType.ALL)
    private List<Exposicion> exposiciones;


    // Getters y setters




}
