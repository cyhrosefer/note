package com.sae.hadoop;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class RPCServer implements Bizable{

	
	public String sayHi(String name){
		return "Hi ~ " +name;
	}
	
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws HadoopIllegalArgumentException 
	 */
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		Server server=new RPC.Builder(conf).setProtocol(Bizable.class).setInstance(new RPCServer()).setBindAddress("192.168.58.1").setPort(9527).build();
		server.start();
	}

}
