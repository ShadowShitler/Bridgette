package org.usfirst.frc369.Robot2017Code;

import java.io.IOException;
import java.net.* ;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.io.*;
import java.util.Timer;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Queue;
import java.util.PriorityQueue;

public class Server
{
   private final static int PACKETSIZE = 1024;
   private final static int PORT =  10000;
   
   DatagramSocket socket;
  //  ByteBuffer packet;
  //  SocketAddress client;
   LinkedBlockingQueue<String> latestValue;
   Thread t;
   byte[] receiveData;
   public Server() {
     try{
      socket = new DatagramSocket(PORT);
      receiveData = new byte[256];
      System.out.println("The server is ready... on port: "+PORT);
      // packet = ByteBuffer.allocate(PACKETSIZE);
      latestValue = new LinkedBlockingQueue<String>();
     } catch(Exception ex) {
       System.err.println("durring setup: "+ ex);
     }
     t = new RuntimeThread(latestValue);
      t.start();
   }

   public String getString() {
     if(!latestValue.isEmpty()){
      return latestValue.poll();
     }
     return null;
   }
   public Double getDouble() {
      String s = getString();
      if(s != null)
        return new Double(s);
      return null;
   }

   class RuntimeThread extends Thread {
     private final LinkedBlockingQueue<String> v;
     public RuntimeThread(LinkedBlockingQueue<String> callback) {
        this.v = callback;
     }
     @Override
      public void run() {
          while(true) {
            try {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              socket.receive(receivePacket);
              String sentence = new String( receivePacket.getData());
              v.add(sentence);
              // System.out.println(sentence);
              // packet.clear();
              // socket.receive(packet);
              // packet.flip();
              // byte[] b = new byte[packet.limit()];
              // packet.get(b, 0, packet.limit());
              // latestValue = new String(b);
            } catch(Exception ex) {
              System.err.println("Thread Error: "+ex);
            }
          }
        }
   }
}
