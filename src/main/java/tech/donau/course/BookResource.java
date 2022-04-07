package tech.donau.course;

import tech.donau.course.data.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/book")
public class BookResource {


    private static ArrayList<Book> books = new ArrayList<>();


    static {
        books.add(new Book("Moby Dick", "Herman Melville"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        return Response.ok(books).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBook(final Book book) {
        if (books.size() >= 5)
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("No more books allowed").build();
        books.add(book);
        return Response.ok(books).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response putBook(@PathParam("id") final Integer id, final Book book) {
        if (id >= 0 && id <= books.size() && books.size() > 0 && books.get(id) != null) {
            books.remove(id.intValue());
            books.add(id, book);
            return Response.ok().entity(books).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(String.format("no book with id %s found", id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") final Integer id) {
        if (id >= 0 && id <= books.size() && books.size() > 0 && books.get(id) != null) {
            books.remove(id.intValue());
            return Response.ok().entity(books).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(String.format("no book with id %s found", id)).build();
    }
}
