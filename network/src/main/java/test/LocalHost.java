package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String hostName = inetAddress.getHostName();
		String hostIpAddress = inetAddress.getHostAddress();
		
		System.out.println(hostName);
		System.out.println(hostIpAddress);
		
		byte[] IpAddresses = inetAddress.getAddress();
		for(byte IpAddress : IpAddresses) {
			
		}
	}

}
