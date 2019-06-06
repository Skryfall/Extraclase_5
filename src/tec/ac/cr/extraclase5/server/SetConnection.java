package tec.ac.cr.extraclase5.server;

import tec.ac.cr.extraclase5.logic.Lapicero;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import static tec.ac.cr.extraclase5.server.DatabaseHolderData.ip;

@Path("setip")
public class SetConnection {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void setIP(Lapicero lapicero){
        ip = lapicero.getMarca();
        System.out.println(ip);
    }

}
