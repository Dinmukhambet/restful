package devyellow.message;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
        Collections.sort(messageList, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return (o1.getMsgID()-o2.getMsgID());
            }
        });
        return messageList;
    }
}
