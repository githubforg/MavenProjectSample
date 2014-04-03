package com.ChatRoomTCP;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by DELL on 14-4-2.
 */
public class TestClientMain {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("192.168.1.105",10000);
        chatRoomClient client=new chatRoomClient();
        client.getOutput(socket).start();
        client.getReceive(socket).start();


    }
}
