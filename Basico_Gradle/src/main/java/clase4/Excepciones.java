package clase4;

public class Excepciones {
    public static void main(String[] args) {

        String[] arreglo = {"1", "2", "3"};

        //Cuando sabemos que el codigo tendra excepciones, podemos capturarlas para evitar que el programe falle
        try{
            //Ponemos la ejecucion que causa la excepcion
            System.out.println(arreglo[3]);
            //Ponemos la excepcion que saldra, podemos poner una existente
            //Con 'Exception' podemos personalizar la excepcion
        } catch (Exception e) {
            //Imprimimos el mensaje predeterminado de la excepcion
            e.printStackTrace();
            //O podemos imprimir un mensaje personalizado para la excepcion
            System.out.println("Error");
        }
    }
}
