package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.Checkpoint;

public interface CheckpointService {
	
	public List<Checkpoint> getAllCheckpoints();
	public List<String> getAllProgrammes();
	
	String getCheckpointJSON(String checkpoint_id);
	int addCheckpoint(Checkpoint checkpoint);
	int deleteCheckpoint(String checkpoint_id);
	
	int updateCheckpoint(Checkpoint checkpoint);
}
