package com.hadoop.mr.mobile6;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer;

import com.hadoop.mr.mobile6.Sequence.MDimention;
import com.hadoop.mr.mobile6.Sequence.MDimentionValue;

public class MReducer extends Reducer<MDimention, MDimentionValue, MDimention, MDimentionValue> {

	@Override
	protected void reduce(MDimention arg0, Iterable<MDimentionValue> arg1,
			Reducer<MDimention, MDimentionValue, MDimention, MDimentionValue>.Context arg2)
			throws IOException, InterruptedException {
		int up=0;
		int down=0;
		for(MDimentionValue mv:arg1)
		{
			up+=mv.getUpflow();
			down+=mv.getDownflow();
		}
		MDimentionValue mv=new MDimentionValue();
		mv.setDownflow(down);
		mv.setUpflow(up);
		mv.setSum(up+down);
		arg2.write(arg0, mv);
	}
}
