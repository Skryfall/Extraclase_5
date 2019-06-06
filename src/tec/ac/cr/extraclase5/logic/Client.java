package tec.ac.cr.extraclase5.logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    private static String ip = "192.168.99.100";

    /**
     * Envia un lapicero al server para ser insertado
     * @param json con el lapicero a insertar
     */
    public static void insertLapicero(String json){
        try {
            URL url = new URL("http://" + ip + ":9080/app/extraclase/insert");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes(json);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            con.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Envia el id de un lapicero a eliminar
     * @param json con el id del lapicero a eliminar
     */
    public static void deleteLapicero(String json){
        try {
            URL url = new URL("http://" + ip + ":9080/app/extraclase/delete");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes(json);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            con.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Recibe todos los lapiceros de la tabla
     * @return string con todos los lapiceros
     */
    public static String getAllLapicero(){
        try{
            URL url = new URL("http://" + ip + ":9080/app/extraclase/select/all");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream inputStream = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            char[] buffer = new char[1024];
            int leidos = 0;
            StringBuilder builder = new StringBuilder();
            while ((leidos = reader.read(buffer))>0){
                builder.append(new String(buffer,0,leidos));
            }
            reader.close();
            con.disconnect();

            return builder.toString();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retorna un lapicero especifico
     * @param json con la id del lapicero buscado
     * @return string con los datos del lapicero
     */
    public static String getLapicero(String json){
        try {
            URL url = new URL("http://" + ip + ":9080/app/extraclase/select");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes(json);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            con.disconnect();
            return response.toString();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Actualiza la informacion de un lapicero en el server
     * @param json con los datos a actualizar del lapicero
     */
    public static void updateLapicero(String json){
        try {
            URL url = new URL("http://" + ip + ":9080/app/extraclase/update");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes(json);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            con.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la direccion ip de la base de datos para que el server sea capaz de conectarse
     * @param json con la ip de la base de datos
     */
    public static void setIp(String json){
        try {
            URL url = new URL("http://" + ip + ":9080/app/extraclase/setip");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes(json);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            con.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
