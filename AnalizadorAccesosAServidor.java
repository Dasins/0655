import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Creo objetos capaces de comprobar el log de accesos al servidor.
 *
 * @author d4s1ns
 * @version 2018/02/21
 */
public class AnalizadorAccesosAServidor{
    HashMap<Integer,ArrayList<Acceso>> registro;
    
    /* CONSTRUCTORES */
    /**
     * Construye objetos AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor(){
        registro = new HashMap<>();
    }
    
    /* METODOS GENERALES */
    /**
     * Analiza el contenido de un archivo de log.
     * @param ruta La ruta del archivo de log. Admite rutas realtivas y absolutas.
     */
    public void analizarArchivoDeLog(String ruta)
    {
        registro = new HashMap<>();
        try {
            File archivo = new File(ruta);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                int[] datos = toInt(sc.nextLine().split(" "));
                Integer key = datos[3];
                Acceso acceso = new Acceso(datos[0],datos[1],datos[2],key,datos[4]);
                if(registro.containsKey(key)) {
                    registro.get(key).add(acceso);
                }
                else {
                    ArrayList<Acceso> coleccion = new ArrayList<>();
                    coleccion.add(acceso);
                    registro.put(key, coleccion);
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Devuelve la hora con mas accesos, en caso de empate devuelve la ultima.
     * @return Devuelve la hora con mas accesos, en caso de empate devuelve la ultima. 
     * Si no existen accesos, devuelve -1.
     */
    public int obtenerHoraMasAccesos() {
        int maxNumAccesos = 0;
        int horaMasAccesos = -1;
        for(ArrayList<Acceso> coleccionActual : registro.values()) {
            int numAccesosActuales = coleccionActual.size();
            int horaAccesosActuales = coleccionActual.get(0).getHora();
            if(numAccesosActuales >= maxNumAccesos && horaAccesosActuales > horaMasAccesos) {
                maxNumAccesos = coleccionActual.size();
                horaMasAccesos = coleccionActual.get(0).getHora();
            }
        }    
        return horaMasAccesos;
    }
    
    /**
     * Devuelve un coleccion de int a partir de una coleccion de numeros en formato String.
     * @param coleccionCadenas Una cadena de String que contiene numeros en formato texto.
     * @return Devuelve un coleccion de int a partir de una coleccion de numeros en formato String.
     */
    private int[]toInt(String[] coleccionCadenas){
        int[] numeros = new int[coleccionCadenas.length];
        for(int i = 0; i < coleccionCadenas.length; i++){
            numeros[i] = Integer.parseInt(coleccionCadenas[i]);
        }
        return numeros;
    }
}
