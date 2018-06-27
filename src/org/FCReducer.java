package org;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FCReducer extends Reducer<CSPair, IntWritable, CSPair, IntWritable>{
	private IntWritable outval= new IntWritable();	
	
	@Override
	protected void reduce(CSPair key, Iterable<IntWritable> value,
			Reducer<CSPair, IntWritable, CSPair, IntWritable>.Context context) throws IOException, InterruptedException {
		int sum=0;
		for (IntWritable intWritable : value) {
			sum+=1;
		}
		outval.set(sum);
		context.write(key, outval);
	}

}
