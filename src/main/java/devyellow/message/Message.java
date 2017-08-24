package devyellow.message;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ww on 16.08.2017.
 */
@XmlRootElement
public class Message {

    private int msgID;
    private String msgRu;
    private String msgKz;
    private String msgEn;

    public Message(int msgID, String msgRu, String msgKz, String msgEn) {
        this.msgID = msgID;
        this.msgRu = msgRu;
        this.msgKz = msgKz;
        this.msgEn = msgEn;
    }

    public Message() {}

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public String getMsgRu() {
        return msgRu;
    }

    public void setMsgRu(String msgRu) {
        this.msgRu = msgRu;
    }

    public String getMsgKz() {
        return msgKz;
    }

    public void setMsgKz(String msgKz) {
        this.msgKz = msgKz;
    }

    public String getMsgEn() {
        return msgEn;
    }

    public void setMsgEn(String msgEn) {
        this.msgEn = msgEn;
    }


}
