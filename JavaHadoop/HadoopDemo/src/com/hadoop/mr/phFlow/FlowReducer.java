package com.hadoop.mr.phFlow;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
public class FlowReducer extends Reducer<Flow, NullWritable, Flow, NullWritable> {
     @Override
    protected void reduce(Flow key, Iterable<NullWritable> vs2,
    		Reducer<Flow, NullWritable, Flow, NullWritable>.Context context)
    		throws IOException, InterruptedException {
    	context.write(key, NullWritable.get());
    }
}