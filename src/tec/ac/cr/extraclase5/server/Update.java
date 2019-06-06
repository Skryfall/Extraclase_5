package tec.ac.cr.extraclase5.server;

import tec.ac.cr.extraclase5.logic.Lapicero;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Path("update")
public class Update {

    /**
     * Actualiza un lapicero en la base de datos
     * @param lapicero con los datos a actualizar
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateLapicero(Lapicero lapicero){
        try {
            int id = lapicero.getId();
            String marca = lapicero.getMarca();
            int precio = lapicero.getPrecio();
            Connection conn = DatabaseHolderData.getDatabaseData();
            PreparedStatement ps = conn.prepareStatement("UPDATE Productos SET Marca = ?, Precio = ? WHERE LapicerosId = ?");
            ps.setString(1, marca);
            ps.setInt(2, precio);
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
    }

}
