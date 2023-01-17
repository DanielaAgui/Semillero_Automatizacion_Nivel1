package clase3;

import com.opencsv.bean.CsvBindByPosition;

public class Participante {

    //Tambien podemos estblecer la posicion que queramos en la clase a usar
    @CsvBindByPosition(position = 0)
    private String nombre;

    @CsvBindByPosition(position = 1)
    private String fechaAsistencia;

    @CsvBindByPosition(position = 2)
    private String area;

    public Participante(String nombre, String fecha, String area) {
        this.nombre = nombre;
        this.fechaAsistencia = fecha;
        this.area = area;
    }

    public Participante() {}

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

