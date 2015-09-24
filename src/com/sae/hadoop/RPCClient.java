package com.sae.hadoop;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient {

	
	public static void main(String[] args) throws IOException{
		Bizable proxy=RPC.getProxy(Bizable.class, 10000, new InetSocketAddress("192.168.58.1",9527), new Configuration());
		System.out.println(proxy.sayHi("cyh"));
		RPC.stopProxy(proxy);
	}
	
}


