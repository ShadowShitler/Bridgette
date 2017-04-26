package org.usfirst.frc369.Robot2017Code;

import java.net.* ;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

// import org.json.JSONObject;
// import org.json.simple.parser.JSONParser;
public class Server
{
   private final static int PACKETSIZE = 100 ;

   public static void main( String args[] )
   {
    //  JSONParser parser = new JSONParser();
      // Check the arguments
      try
      {
         // Convert the argument to ensure that is it valid
         int port = 10000;

         // Construct the socket
        //  DatagramSocket socket = new DatagramSocket( port ) ;
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(port));
        channel.configureBlocking(false);
         

         System.out.println( "The server is ready..." ) ;


         for( ;; )
         {
            // Create a packet
            // DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
            ByteBuffer packet = ByteBuffer.allocate(PACKETSIZE);

            // Receive a packet (blocking)
            if(channel.receive( packet ) != null) {
              // Print the packet
              byte[] bytes = new byte[packet.remaining()];
              packet.get(bytes);
              //java.nio.charset.StandardCharsets.UTF_8
              System.out.println( "data: " + new String(bytes));
              // System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData(), packet.getOffset(), packet.getLength()));
            }
            System.out.println("waiting");
        }  
     }
     catch( Exception e )
     {
        System.out.println( e ) ;
     }
  }
}