package tec.ac.cr.extraclase5.server;

import tec.ac.cr.extraclase5.logic.Lapicero;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Path("select")
public class Select {

    /**
     * Retorna un lapicero especifico de la base de datos
     * @param lapicero con el id a buscar
     * @return lapicero con los datos
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lapicero getLapicero(Lapicero lapicero){
        try {
            int id = lapicero.getId();
            Connection conn = DatabaseHolderData.getDatabaseData();
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT LapicerosId, Marca, Precio FROM Productos WHERE LapicerosId = " + String.valueOf(id));
            while (resultSet.next()) {
                lapicero.setId(resultSet.getInt("LapicerosId"));
                lapicero.setMarca(resultSet.getString("Marca"));
                lapicero.setPrecio(resultSet.getInt("Precio"));
            }
            conn.close();
            return lapicero;
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Retorna una lista con todos los lapiceros de la base de datos
     * @return lista con los lapiceros
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Lapicero> getAllLapicero(){
        try {
            ArrayList<Lapicero> arrayList = new ArrayList<Lapicero>();
            Connection conn = DatabaseHolderData.getDatabaseData();
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT LapicerosId, Marca, Precio FROM Productos");
            while (resultSet.next()) {
                Lapicero nLapicero = new Lapicero();
                nLapicero.setId(resultSet.getInt("LapicerosId"));
                nLapicero.setMarca(resultSet.getString("Marca"));
                nLapicero.setPrecio(resultSet.getInt("Precio"));
                arrayList.add(nLapicero);
            }
            conn.close();
            return arrayList;
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
            return null;
        }
    }

}
