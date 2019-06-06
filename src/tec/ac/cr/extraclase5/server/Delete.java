package tec.ac.cr.extraclase5.server;

import tec.ac.cr.extraclase5.logic.Lapicero;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Path("delete")
public class Delete {

    /**
     * Elimina un lapicero de la base de datos
     * @param lapicero con los datos a eliminar
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteLapicero(Lapicero lapicero){
        try{
            int id = lapicero.getId();
            Connection conn = DatabaseHolderData.getDatabaseData();
            PreparedStatement ps = conn.prepareStatement("DELETE  FROM Productos WHERE LapicerosId = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        }catch (SQLException e){
            System.err.println("Error");
            e.printStackTrace();
        }
    }

}
