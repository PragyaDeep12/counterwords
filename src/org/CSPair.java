package org;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CSPair implements WritableComparable<CSPair>{

	private Text sports=new Text();
	public String getSports() {
		return sports.toString();
	}

	public void setSports(String sports) {
		this.sports.set(sports);
	}

	public String getCountry() {
		return country.toString();
	}

	public void setCountry(String country) {
		this.country.set(country);
	}
	public String toString()
	{
		return country.toString()+sports.toString();
	}


	private Text country=new Text();
	/*public void set(String s,String c)
	{
		sports.set(s);
		country.set(c);
	}*/
	
	@Override
	public void readFields(DataInput dataInput) throws IOException {
		
		sports.readFields(dataInput);
		country.readFields(dataInput);
	}

	@Override
	public void write(DataOutput dataOutput) throws IOException {
		sports.write(dataOutput);
		country.write(dataOutput);
	}

	

	@Override
	public int compareTo(CSPair csPair) {
		
		int c=sports.compareTo(csPair.sports);
		if(c==0)
		{
			c=country.compareTo(csPair.country);
		}
		return c;
	}

}
