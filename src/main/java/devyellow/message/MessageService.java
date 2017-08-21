package devyellow.message;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ww on 17.08.2017.
 */
public class MessageService {

      /* for (Message msg :sortedList){
        if (prevMsg!=null&&prevMsg.getMsgID()+1!=msg.getMsgID()&&prevMsg.getMsgID()!=msg.getMsgID()){
            bf.newLine();
        }
        bf.write(String.valueOf(msg.getMsgID())+"|"+msg.getMsgEn()+"|"+msg.getMsgKz()+"|"+msg.getMsgRu());
        bf.newLine();
        prevMsg=msg;
    }*/
   // private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(("C:\\Users\\ww\\Desktop\\messages.txt")),"UTF-8"));
    static HashMap<Integer,Message> msgMap = new HashMap<Integer,Message>();
    BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(("C:\\Users\\ww\\Desktop\\messages.txt")),"UTF-8"));
    public MessageService() throws IOException {

        List<String> message = new ArrayList<>();
        String s;
        while((s=reader.readLine())!=null){
            if (s.isEmpty()) continue;
            message.add(s);
        }
        MessageFormat msgFormat = new MessageFormat();

        for (Message msg:msgFormat.sortMsg(msgFormat.splitMsg(message))) {
            msgMap.put(msg.getMsgID(),msg);
        }
    }

    public List<Message> getAllMessages() {
        List <Message> messageList = new ArrayList<>(msgMap.values());
        return  messageList;
    }

    public Message getMessageById(Integer id){
        return msgMap.get(id);
    }

    public Message createMessage(Message msg) throws IOException {
        Message message= new Message();
        message.setMsgID(msg.getMsgID());
        msgMap.put(msg.getMsgID(),msg);
        /*String s;
        while((s=reader.readLine())!=null){
            if (s.isEmpty()){
                s.replace("",msg.getMsgID()+"|"+msg.getMsgRu()+"|"+msg.getMsgKz()+"|"+msg.getMsgEn());
            }
        }*/
        return null;
    }

    public Message updateMessage(Message message){
        if (message.getMsgID()<=0){
            return null;
        }
        msgMap.put(message.getMsgID(),message);
        return message;
    }

    public void deleteMsg(Integer id) throws IOException {

        msgMap.remove(id);
        String s;
        while((s=reader.readLine())!=null&&s.startsWith(String.valueOf(id))){
            s.replace(reader.readLine(),"\n");
        }
    }

}
