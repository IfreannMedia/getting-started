package tech.donau.course;

import tech.donau.course.data.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

@Path("/book")
public class BookResource {


    private static ArrayList<Book> books = new ArrayList<>();


    static {
        books.add(new Book("Moby Dick", "Herman Melville"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book> getBooks() {
        return books;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Book postBook(final Book book) {
        books.add(book);
        return book;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book> putBook(@PathParam("id") final Integer id, final Book book) {
        books.remove(id.intValue());
        books.add(id, book);
        return books;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book> deleteBook(@PathParam("id") final Integer id) {
        books.remove(id.intValue());
        return books;
    }
}
