package com.hadoop.mr.mobile6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.OutputCommitter;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import com.hadoop.mr.mobile6.collector.ICollector;
import com.hadoop.mr.mobile6.Sequence.MDimention;
import com.hadoop.mr.mobile6.Sequence.MDimentionValue;


public class MySqlOutputFormat extends OutputFormat<MDimention, MDimentionValue> {//����Ϊreduce���������

	class MySqlWriter extends RecordWriter<MDimention, MDimentionValue> {		
		private Connection con;
		private Configuration conf;
		private Map<String, PreparedStatement> psMap = new HashMap<String, PreparedStatement>();
		int count = 0;

		public MySqlWriter(Connection con, Configuration conf) {
			this.con = con;
			this.conf = conf;
		}

		/**
		 * ������mysql���Լ�����Դ 0.�ж� 
		 * 1.����PrepareStatement ��Ҫsql 
		 * 2.��ҪΪsql��ֵ
		 * write��reduce���ô�����һ����
		 */
		@Override
		public void write(MDimention key, MDimentionValue value) throws IOException, InterruptedException {
					
			
			String k = "mobile_" + key.getFlag();
			PreparedStatement ps = psMap.get(k);
			if (ps == null) {
				String sql = conf.get(k);
				try {
					ps = con.prepareStatement(sql);
					psMap.put(k, ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			count++;
           
			try {
				ICollector collector = (ICollector) Class.forName(conf.get("param_" + key.getFlag())).newInstance();
				collector.bindSql(key, value, ps);
				
				
				if (count % 10 == 0) {
					ps.executeBatch();
					con.commit();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/**
		 *  ��reduceִ�н���֮�󣬻����close
		 */
		@Override
		public void close(TaskAttemptContext context) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			try {
				for (PreparedStatement ps : psMap.values()) {
					ps.executeBatch();
					con.commit();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					for (PreparedStatement ps : psMap.values()) {
						ps.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}

	@Override
	public RecordWriter<MDimention, MDimentionValue> getRecordWriter(TaskAttemptContext context)
			throws IOException, InterruptedException {//��д��������д��mysql
		// TODO Auto-generated method stub
		Configuration conf = context.getConfiguration();//�õ������ļ�����
		
		Connection con = JDBCManager.getConnection(conf);
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MySqlWriter(con, conf);
	}

	@Override
	public void checkOutputSpecs(JobContext context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public OutputCommitter getOutputCommitter(TaskAttemptContext context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return new FileOutputCommitter(FileOutputFormat.getOutputPath(context), context);
	}

}
