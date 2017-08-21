package devyellow.message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by ww on 16.08.2017.
 */

@Path("/messages")
public class MessageController {

     MessageService service= new MessageService();


    public MessageController() throws IOException {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) throws IOException {
        Message msgResponse =service.createMessage(message);
        return  msgResponse;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessage(){
        return  service.getAllMessages();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMsg(Message message){
        return service.updateMessage(message);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMsg(@PathParam("id")Integer id) throws IOException {
        service.deleteMsg(id);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getMsgById(@PathParam("id") Integer id) {
        service.getMessageById(id);
    }

}
