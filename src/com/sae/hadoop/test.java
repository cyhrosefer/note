package com.sae.hadoop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.*;


public class test {
	
		FileSystem fs=null;
		
		@Before
		public void init() throws IOException, InterruptedException, URISyntaxException{
			fs=FileSystem.get(new URI("hdfs://192.168.58.128:9000"),new Configuration(), "root");
					
		}
	
		@Test
		public void testUpload() throws IllegalArgumentException, IOException{
			InputStream in=new FileInputStream("C://NOTICE.txt");
			OutputStream out=fs.create(new Path("/nnn.txt"));
			IOUtils.copyBytes(in, out, 4096, true);
		}
		
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
//		FileSystem fs=FileSystem.get(new URI("hdfs://192.168.58.128:9000"),new Configuration());
//		InputStream in=fs.open(new Path("/NOTICE.txt"));
//		OutputStream out=new FileOutputStream("C://NOTICE.txt");
//		IOUtils.copyBytes(in, out, 4096,true);
		
	}
}
