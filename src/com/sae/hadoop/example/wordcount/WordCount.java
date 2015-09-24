package com.sae.hadoop.example.wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class WordCount {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
		if(args.length!=2){
			System.err.println("Usage:  WordCount <input path> <output path>");
			System.exit(-1);
		}
		
		Job job=Job.getInstance(new Configuration());
		
		job.setMapperClass(WCMapper.class);
		job.setReducerClass(WCReducer.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		job.setJarByClass(WordCount.class);
		job.waitForCompletion(true);
		
		
	}
}
