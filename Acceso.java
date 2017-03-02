
/**
 * 
 */
public class Acceso
{
    // instance variables - replace the example below with your own
    private int year;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;

    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int yearDeEntrada, int mesDeEntrada, int diaDeEntrada, int horaDeEntrada, int minutoDeEntrada)
    {
        year=yearDeEntrada;
        mes=mesDeEntrada;
        dia=diaDeEntrada;
        hora=horaDeEntrada;
        minuto=minutoDeEntrada;
    }

    /**
     *
     */
    public int getHora()
    {
         return hora;
    }
}

