package Clases;

public class Ciudad {
    private String nombre;
    private Boolean alojamiento;
    private Boolean esCede;

// Constructor
    public Ciudad(String nombre, Boolean alojamiento, Boolean esCede) {
        this.nombre = nombre;
        this.alojamiento = alojamiento;
        this.esCede = esCede;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Boolean getEsCede() {
        return esCede;
    }

    public void setEsCede(Boolean esCede) {
        this.esCede = esCede;
    }
}