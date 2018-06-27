package org;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FCDriver {
	
  public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		Configuration conf= new Configuration();
		Job job=null;
		try {
			job = Job.getInstance(conf);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		job.setJarByClass(FCDriver.class);
		job.setMapperClass(FCMapper.class);
		job.setReducerClass(FCReducer.class);
	
		job.setOutputKeyClass(CSPair.class);
		job.setOutputValueClass(IntWritable.class);
		
		try {
			FileInputFormat.addInputPath(job,new Path("fcdir"));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		FileOutputFormat.setOutputPath(job, new Path ("fcoutput1"));
		try {
			job.waitForCompletion(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
