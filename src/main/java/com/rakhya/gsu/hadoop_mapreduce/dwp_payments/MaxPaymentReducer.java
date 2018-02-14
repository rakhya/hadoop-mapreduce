package com.rakhya.gsu.hadoop_mapreduce.dwp_payments;

/**
 * MaxClosePriceReducer.java
 * www.hadoopinrealworld.com
 * This is a Reduce program to calculate Max Close Price from stock dataset using MapReduce
 */
 import java.io.IOException;

 import org.apache.hadoop.io.FloatWritable;
 import org.apache.hadoop.io.Text;
 import org.apache.hadoop.mapreduce.Reducer;

 public class MaxPaymentReducer
 extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	 @Override
	 public void reduce(Text key, Iterable<FloatWritable> values, Context context)
			 throws IOException, InterruptedException {

		 float maxPaymentPrice = Float.MIN_VALUE;
		 
		 //Iterate all temperatures for a year and calculate maximum
		 for (FloatWritable value : values) {
			 maxPaymentPrice = Math.max(maxPaymentPrice, value.get());
		 }
		 
		 //Write output
		 context.write(key, new FloatWritable(maxPaymentPrice));
	 }
 }
