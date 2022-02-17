package tech.donau.course;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final String TOKEN = "dev";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello test";
    }

    @GET
    @Path("/subpath/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloSubPath(@PathParam("id") final String id) {
        return "hello sub path, you sent id: " + id;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postHello(@HeaderParam("token") final String token, @QueryParam("token") final String param, final String body) {
        String theToken = token != null ? token : param;
        if(theToken == null){
            throw new RuntimeException("no token!");
        }
        System.out.println(param);
        System.out.println(body);
        System.out.println(theToken);
        return "posted";
    }
}