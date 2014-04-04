package com.ChatRoomTCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DELL on 14-4-2.
 */
public class TestServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10000);
        Socket s = socket.accept();
        chatRoomServer server = new chatRoomServer();
        server.getSvOut(s).start();
        server.getSvReceive(s).start();

    }
}
