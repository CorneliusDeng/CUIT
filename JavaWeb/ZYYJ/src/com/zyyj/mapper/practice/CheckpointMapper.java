package com.zyyj.mapper.practice;

import java.util.List;

import com.zyyj.bean.Checkpoint;

public interface CheckpointMapper {
	
	List<Checkpoint> getAllCheckpoints();
	List<String> getAllProgrammes();
	Checkpoint getCheckpoint(String checkpoint_id);
	
	int addCheckpoint(Checkpoint checkpoint);
	String getMaxId();
	
	int deleteCheckpoint(String checkpoint_id);
	
	int updateCheckpoint(Checkpoint checkpoint);
}
