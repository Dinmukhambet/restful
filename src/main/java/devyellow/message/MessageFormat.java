package devyellow.message;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ww on 17.08.2017.
 */
public class MessageFormat {

    public List<Message> splitMsg(List<String> messages){
        return  messages.stream().map(string -> string.split("[|]")).map(strings ->
                new Message(Integer.valueOf(strings[0]),strings[1],strings[2],strings[3])).collect(Collectors.toList());


    }

    public List<Message> sortMsg(List<Message> messageList){
        Collections.sort(messageList, (o1, o2) -> (o1.getMsgID()-o2.getMsgID()));
        return messageList;
    }
}
