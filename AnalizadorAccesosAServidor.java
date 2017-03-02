import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> numeroAccesos;

    public AnalizadorAccesosAServidor(){
        numeroAccesos = new ArrayList<Acceso>();
    }

    public void analizarArchivoDeLog(String logAleer)
    {
        numeroAccesos.clear();
        try {
            File archivo = new File(logAleer);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String entrada[]=sc.nextLine().split(" ");
                Acceso entradaActual=new Acceso(Integer.parseInt(entrada[0]),
                    Integer.parseInt(entrada[1]),Integer.parseInt(entrada[2]),
                    Integer.parseInt(entrada[3]),Integer.parseInt(entrada[4]));
                numeroAccesos.add(entradaActual);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public int obtenerHoraMasAccesos()
    {
        int horaActual = 0;
        int contActual = 0;
        int horaMasAccesos = -1;
        int contMasAccesos = 0;
        if(numeroAccesos.size()!=0){
            //int[] horasAcceso = new int[listaDeAccesos.size()];
            for (int cont = 0; cont < 24; cont++){
                horaActual = cont;
                for (Acceso acceso : numeroAccesos){
                    if (acceso.getHora() == horaActual){
                        contActual++;
                    }
                }

                if (contActual >= contMasAccesos){
                    contMasAccesos = contActual;
                    horaMasAccesos = horaActual;
                }

                contActual = 0;
            }
        }

        if (horaMasAccesos == -1) {
            System.out.println("No tengo datos.");
        }
        else {
            System.out.println("La hora con mas accesos es: " + horaMasAccesos); 
        }
        return horaMasAccesos;
    }

}

