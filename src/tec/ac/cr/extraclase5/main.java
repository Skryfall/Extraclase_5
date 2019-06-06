package tec.ac.cr.extraclase5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tec.ac.cr.extraclase5.logic.Client;
import tec.ac.cr.extraclase5.logic.Lapicero;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String args[]) throws IOException {
        System.out.println("Bienvenido al menu de base de datos: ");
        Scanner scanner = new Scanner(System.in);
        boolean activado = true;
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Inserte la ip de la base de datos Microsoft SQL");
        Lapicero lapicerot = new Lapicero();
        lapicerot.setMarca(new Scanner(System.in).nextLine());
        lapicerot.setId(1);
        lapicerot.setPrecio(1);
        String jsont = objectMapper.writeValueAsString(lapicerot);
        Client.setIp(jsont);
        System.out.println("Listo");
        while (activado){
            System.out.println("Presione 1 para hacer un insert, 2 para delete, 3 para select y 4 para update, otro número para terminar");
            int i = scanner.nextInt();
            if (i == 1){
                System.out.println("Creación del lapicero a almacenar:");
                Lapicero lapicero = new Lapicero();
                System.out.println("Id del Lapicero:");
                lapicero.setId(scanner.nextInt());
                System.out.println("Marca del Lapicero:");
                lapicero.setMarca(new Scanner(System.in).nextLine());
                System.out.println("Precio del Lapicero:");
                lapicero.setPrecio(scanner.nextInt());
                String json = objectMapper.writeValueAsString(lapicero);
                Client.insertLapicero(json);
                System.out.println("Agregado");
            }else if (i == 2){
                System.out.println("Eliminación de un lapicero:");
                Lapicero lapicero = new Lapicero();
                System.out.println("Id del Lapicero:");
                lapicero.setId(scanner.nextInt());
                lapicero.setMarca("Dummy");
                lapicero.setPrecio(1);
                String json = objectMapper.writeValueAsString(lapicero);
                Client.deleteLapicero(json);
                System.out.println("Eliminado");
            }else if (i == 3){
                System.out.println("Presione 1 para obtener todos los lapiceros o 2 para uno en específico");
                i = scanner.nextInt();
                if (i == 1){
                    String json = Client.getAllLapicero();
                    List<Lapicero> lapiceros = objectMapper.readValue(json, new TypeReference<List<Lapicero>>(){});
                    for (i = 0; i < lapiceros.size(); i++){
                        Lapicero lapicero = lapiceros.get(i);
                        System.out.println("ID: " + lapicero.getId() + ", Marca: " + lapicero.getMarca() + ", Precio: " + lapicero.getPrecio());
                    }
                    System.out.println("Listo");
                }
                else if (i == 2){
                    System.out.println("Selección de un lapicero:");
                    Lapicero lapicero = new Lapicero();
                    System.out.println("Id del Lapicero:");
                    lapicero.setId(scanner.nextInt());
                    lapicero.setMarca("Dummy");
                    lapicero.setPrecio(1);
                    String json = objectMapper.writeValueAsString(lapicero);
                    json = Client.getLapicero(json);
                    lapicero = objectMapper.readValue(json, Lapicero.class);
                    System.out.println("ID: " + lapicero.getId() + ", Marca: " + lapicero.getMarca() + ", Precio: " + lapicero.getPrecio());
                    System.out.println("Listo");
                }else{
                    System.out.println("Error");
                }
            }else if (i == 4){
                System.out.println("Actualización del lapicero:");
                Lapicero lapicero = new Lapicero();
                System.out.println("Id del Lapicero:");
                lapicero.setId(scanner.nextInt());
                System.out.println("Marca del Lapicero:");
                lapicero.setMarca(new Scanner(System.in).nextLine());
                System.out.println("Precio del Lapicero:");
                lapicero.setPrecio(scanner.nextInt());
                String json = objectMapper.writeValueAsString(lapicero);
                Client.updateLapicero(json);
                System.out.println("Actualizado");
            }else{
                activado = false;
            }
        }
    }

}
