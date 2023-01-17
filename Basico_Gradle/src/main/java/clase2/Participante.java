package clase2;

import com.opencsv.bean.CsvBindByName;

public class Participante {

    //Se usan con la clase 'CsvToBeanBuilder' para indicar la compatibilidad de nombres de la clase con el archivo csv
    //El nombre de la variables es compatible con una columna del archivo
    @CsvBindByName
    private String nombre;

    //El nombre de la variable de la clase equivale a una columna con otro nombre en el archivo csv
    @CsvBindByName (column = "fecha_asistencia")
    private String fechaAsistencia;

    @CsvBindByName
    private String area;

    public Participante(String nombre, String fecha, String area) {
        this.nombre = nombre;
        this.fechaAsistencia = fecha;
        this.area = area;
    }

    //Contructor vacio OBLIGATORIO para usar 'CsvToBeanBuilder'
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
