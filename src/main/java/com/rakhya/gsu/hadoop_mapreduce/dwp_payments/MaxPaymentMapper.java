package com.rakhya.gsu.hadoop_mapreduce.dwp_payments;

/**
 * MaxClosePriceMapper.java
 * www.hadoopinrealworld.com
 * This is a Mapper program to calculate Max Close Price from stock dataset using MapReduce
 */

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxPaymentMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		String[] items = line.split(",");
		
		String stock = items[5];
		Float closePrice = Float.parseFloat(items[7]);
		
		context.write(new Text(stock), new FloatWritable(closePrice));
		
	}
}
