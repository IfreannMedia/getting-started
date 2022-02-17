package tech.donau.course;

import io.netty.util.internal.StringUtil;
import org.jboss.resteasy.annotations.Body;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/book")
public class BookResource {


    private static ArrayList<String> books = new ArrayList<>();


    static {
        books.add("Moby Dick");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return StringUtil.join(", ", books).toString();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String postBook(final String book) {
        books.add(book);
        return book;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> putBook(@PathParam("id") final Integer id, final String book) {
        books.remove(id.intValue());
        books.add(id, book);
        return books;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> deleteBook(@PathParam("id") final Integer id) {
        books.remove(id.intValue());
        return books;
    }
}
