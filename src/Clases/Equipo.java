package Clases;
public class Equipo {
    private String nombre;
    private String tecnico;
    private String grupo;
    private int puntosGanados;
    private int golesAfavor;
    private int golesEnContra;

    // Getters y Setters existentes
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    // Nuevos Getters y Setters
    public int getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(int puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public int getGolesAfavor() {
        return golesAfavor;
    }

    public void setGolesAfavor(int golesAfavor) {
        this.golesAfavor = golesAfavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    // Método existente para cargar goles
    public void cargarGoles(int aFavor, int enContra) {
        golesAfavor += aFavor;
        golesEnContra += enContra;
        if (aFavor > enContra) {
            puntosGanados += 3; 
        } else if (aFavor == enContra) {
            puntosGanados += 1;
        }
    }
}
