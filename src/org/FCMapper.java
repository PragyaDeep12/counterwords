package org;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FCMapper extends Mapper<LongWritable, Text, CSPair, IntWritable> {
	
	private CSPair cspair= new CSPair();
	private IntWritable outval= new IntWritable(1);
@Override
protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, CSPair, IntWritable>.Context context)
		throws IOException, InterruptedException {
	String record =value.toString();
	String fields[]=record.split(",");
	if(fields.length==3)
	{
		String sport=fields[2].toLowerCase();
		cspair.setSports(sport);
		String countr=fields[1].toLowerCase();
		cspair.setCountry(countr);
		context.write(cspair, outval);
	}
}
}
