package com.jiuwu.openoo.openapi.router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

public interface OpenApiVisitRouter {

	@POST
	@Path("/router")
	@Consumes({ "application/x-www-form-urlencoded" })
	public String router(MultivaluedMap<String, String> paramMap, @Context HttpServletRequest request, @Context HttpServletResponse response);
	
	
	@POST
	@Path("/router")
	@Consumes({ "multipart/form-data" })
	public String routerWithFile(MultipartBody body, @Context HttpServletRequest request, @Context HttpServletResponse response);
	
	
	
}
