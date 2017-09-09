package org.file.foto.file3;


import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.google.gson.Gson;

@Provider
public class ObjectNotFoundExcepitonHandler implements ExceptionMapper<ObjectNotFoundExcepiton>{

	@Override
	public javax.ws.rs.core.Response toResponse(ObjectNotFoundExcepiton exception) {
		// TODO Auto-generated method stub
		return javax.ws.rs.core.Response
				.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
				.type(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.entity(new Gson().toJson(exception.getMessage()))
				.build();
	}
	
}
