import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException {
        //bienvenida
        System.out.println("Buenos dias, vamos a crear ficheros");
        //nombre del fichero
        System.out.println("como se llamara el fichero?.recuerde poner .txt");
        Scanner entrada=new Scanner(System.in);
        String nombrefichero=entrada.next();
        Bautizo(nombrefichero);
        ArrayList<String>nombres=new ArrayList<>();
        ArrayList<String>codigo=new ArrayList<>();
        for(int i =0; i<2;i++){
            System.out.println("ingrese un nombre");
            nombres.add(entrada.next());
            System.out.println("ingrese un codigo");
            codigo.add(entrada.next());
        }
        try {
            FileWriter escribo=new FileWriter(Bautizo(nombrefichero).getPath());

                escribo.write(nombres.toString());
                escribo.append(codigo.toString());
            escribo.close();
            System.out.println(nombres.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("desea leer un fichero?");
        System.out.println("¿cual?");
        String buscaficheros=entrada.next();
        Busqueda(buscaficheros);
        if(Busqueda(buscaficheros).exists()) {
            System.out.println("fichero encontrado");
            System.out.println("este es el contenido");
            try {
                FileReader milectura = new FileReader(Busqueda(buscaficheros).getPath());
                int a = milectura.read();
                while (a != -1) {
                    System.out.print((char) a);
                    a = milectura.read();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("fichero no encontrado");
        }




    }public static File Bautizo(String nombrefichero)throws IOException {
        File miarchivo=new File("D:/misficheros/"+ nombrefichero);

            if(miarchivo.createNewFile()){
                System.out.println("hemos creado un archivo");
            }else{
                System.out.println("topota");
            }



            return miarchivo;
    }



    public static File Busqueda(String buscaficheros){
        File miarchivo2=new File("D:/misficheros/"+buscaficheros);
        return miarchivo2;
    }
}
