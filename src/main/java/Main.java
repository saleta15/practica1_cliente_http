import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * Created by saleta on 5/22/2016.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite una URL válida:");
        Scanner scanner = new Scanner(System.in);
        String urlDigitada = scanner.next();
        try {

            Document documento = Jsoup.connect(urlDigitada).get();
            int cantLineasHtml = documento.html().split("\n").length;
            int cantParrafos = documento.select("p").size();
            int cantImagenes = documento.select("img").size();
            Elements formularios = documento.select("form");
            int cantForm = formularios.size();

            System.out.println("Cantidad de lineas del HTML: " + cantLineasHtml);
            System.out.println("Cantidad de parrafos(p): " + cantParrafos);
            System.out.println("Cantidad de imagenes(img): " + cantImagenes);
            System.out.println("Cantidad de formularios(form): " + cantForm + "\n");

            int i = 1;
            for(Element form : formularios)
            {
                System.out.println("Formulario #" + i + ":");
                for(Element input : form.select("input"))
                    System.out.println("\tInput de tipo: " + input.attr("type"));
                i++;
            }

        } catch (IllegalArgumentException e) {
            System.out.print("La URL digitada no es válida.");
        } catch (Exception e){
            System.out.print("Ha ocurrido un error obteniendo el recurso.");
        }


    }


}