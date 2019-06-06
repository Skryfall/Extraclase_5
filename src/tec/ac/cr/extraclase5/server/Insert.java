package tec.ac.cr.extraclase5.server;

import tec.ac.cr.extraclase5.logic.Lapicero;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Path("insert")
public class Insert {

    /**
     * Agrega un lapicero a la base de datos
     * @param lapicero con los datos para ser agregado
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLapicero(Lapicero lapicero){
        try {
            int id = lapicero.getId();
            String marca = lapicero.getMarca();
            int precio = lapicero.getPrecio();
            Connection conn = DatabaseHolderData.getDatabaseData();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Productos VALUES (?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, marca);
            ps.setInt(3, precio);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
    }

}
