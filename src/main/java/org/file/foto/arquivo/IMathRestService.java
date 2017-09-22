package org.file.foto.arquivo;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path(ServiceName.MATH_SERVICE)
@Produces(MediaType.APPLICATION_JSON)//Content-Type:application/json
@Consumes(MediaType.APPLICATION_JSON)//Content-Type:application/json
public interface IMathRestService {
	
	
	@POST
	@Path("/listacompleta")
	public RespLista listar() throws IOException;

}
