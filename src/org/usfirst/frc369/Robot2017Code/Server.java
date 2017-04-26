package org.usfirst.frc369.Robot2017Code;

import java.net.* ;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

// import org.json.JSONObject;
// import org.json.simple.parser.JSONParser;
public class Server
{
   private final static int PACKETSIZE = 100 ;
   private final static int PORT = 10000;
   
   DatagramChannel channel;
   
   public Server()
   {
	  try
	  {
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(PORT));
		channel.configureBlocking(false);  
	  

	  
	  
	  }
     catch( Exception e )
     {
        System.out.println( e ) ;
     }
	  
  }
   
   public void run(){
	   
	   ByteBuffer packet = ByteBuffer.allocate(PACKETSIZE);
	   
	   try{
	   if(channel.receive( packet ) != null) {
           // Print the packet
           byte[] bytes = new byte[packet.remaining()];
           packet.get(bytes);
           //java.nio.charset.StandardCharsets.UTF_8
           System.out.println( "data: " + new String(bytes));
           // System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData(), packet.getOffset(), packet.getLength()));
         }
	   }
	   catch(Exception e )
	   {
		   System.out.println( e );
	   }
	  }
}