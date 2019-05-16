import java.io.*;
import java.net.DatagramPacket; 
import java.net.DatagramSocket;
import java.net.*;
import java.net.SocketException; 
import java.util.Scanner; 
public class udpserver
{ 
	public static void main(String args[]) throws IOException 
	{       
        int a=1;
		Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(2100);
		byte[] receive = new byte[65535]; 
        
        byte buf[] = new byte[1024];       
 System.out.println("Server type bye to exit");

        while (a!=0)
        {
            DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
            System.out.println("Client:-" + data(receive)); 
            receive = new byte[65535];

            String inp = sc.nextLine();
            buf = inp.getBytes();
			DatagramPacket DpSend =new DatagramPacket(buf,buf.length,InetAddress.getLocalHost(),2200);
            ds.send(DpSend);
            if (inp.equals("bye")) 
			{
                    a=0;
            }


        }

    }

 public static StringBuilder data(byte[] a) 
	{ 
		if (a == null) 
		 	return null; 
		StringBuilder ret = new StringBuilder(); 
		int i = 0; 
		while (a[i] != 0) 
		{ 
			ret.append((char) a[i]); 
			i++; 
		} 
		return ret; 
	} 
} 
