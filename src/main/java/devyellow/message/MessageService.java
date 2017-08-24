package devyellow.message;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ww on 17.08.2017.
 */
public class MessageService {

    static HashMap<Integer,Message> msgMap = new HashMap<Integer,Message>();
    static List<String> message = new ArrayList<>();
    static {
          try {
              BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(("C:\\Users\\ww\\Desktop\\messages.txt")),"UTF-8"));
              String s;
              while((s=reader.readLine())!=null){
                  if (s.isEmpty()) continue;
                  message.add(s);
              }

              MessageFormat msgFormat = new MessageFormat();
              for (Message msg:msgFormat.sortMsg(msgFormat.splitMsg(message))) {
                  msgMap.put(msg.getMsgID(),msg);
              }
              reader.close();
          }
           catch (IOException e) {
              e.printStackTrace();
          }

    }

    public MessageService() throws IOException {

    }

    public List<Message> getAllMessages() {
        List <Message> messageList = new ArrayList<>(msgMap.values());
        return  messageList;
    }

    public  Message getMessageById(int id){
        return msgMap.get(id);
    }

    public synchronized Message createMessage(Message msg) throws IOException {
        Message message= new Message();
          int max=0;
        for (int key:msgMap.keySet()) {


            if (key-max!=1){
                msg.setMsgID(max+1);
                msgMap.put(msg.getMsgID(),msg);
                break;
            }
                max=key;
        }
       // message.setMsgID(msg.getMsgID());


        return null;
    }

    public synchronized Message updateMessage(Message message){
        if (message.getMsgID()<=0){
            return null;
        }
        msgMap.put(message.getMsgID(),message);
        return message;
    }

    public Message deleteMsg(int id) throws IOException {
      Message msg=  msgMap.remove(id);
            return msg;
    }
}
