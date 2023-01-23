package clase5;

public class Empleado {

    private int id;
    private String nombre;
    private int edad;
    private String perfil;
    private int salario;

    public Empleado() {}

    public Empleado(int id, String nombre, int edad, String perfil, int salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.perfil = perfil;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", perfil='" + perfil + '\'' +
                ", salario=" + salario +
                '}';
    }
}
