
/**
 * Write a description of class Acceso here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Acceso{
    // La fecha y la hora del acceso.
    int ano, mes, dia, hora, minuto;
    
    /**
     * Construye un objeto Acceso.
     * @param ano El ano en el que se produce el acceso.
     * @param mes El mes en el que se produce el acceso.
     * @param dia El dia en el que se produce el acceso.
     * @param hora La hora en la que se produce el acceso.
     * @param minuto El minuto en el que se produce el acceso
     */
    public Acceso(int ano, int mes, int dia, int hora, int minuto) {
       this.ano = ano;
       this.mes = mes;
       this.dia = dia;
       this.hora = hora;
       this.minuto = minuto;
    }
    
    /**
     * Devuelve la hora en la que se produce el acceso.
     * @return Devuelve la hora en la que se produce el acceso.
     */
    public int getHora() {
        return hora;
    }
    
}
