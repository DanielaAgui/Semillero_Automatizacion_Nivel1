package clase1.models;

public class Participante {

    private String nombre;
    private String fechaAsistencia;
    private String area;

    public Participante(String nombre, String fecha, String area) {
        this.nombre = nombre;
        this.fechaAsistencia = fecha;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(String fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fechaAsistencia + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
