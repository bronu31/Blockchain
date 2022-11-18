package block;

import security.StringUtil;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    final private String data; //our data will be a simple message.
    final private long timeStamp; //as number of milliseconds since 1/1/1970

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after we set the other values.

    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
    }
}
