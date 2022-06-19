package com.zyyj.service.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.Checkpoint;
import com.zyyj.mapper.practice.CheckpointMapper;
import com.zyyj.service.ServiceUtil;

@Service
public class CheckpointServiceImpl implements CheckpointService{
	
	@Autowired
	private CheckpointMapper mapper;
	
	public List<Checkpoint> getAllCheckpoints(){
		return mapper.getAllCheckpoints();
	}
	
	public List<String> getAllProgrammes(){
		return mapper.getAllProgrammes();
	}

	@Override
	public int addCheckpoint(Checkpoint checkpoint) {
		String max_id = mapper.getMaxId();
		checkpoint.setCheckpoint_id(ServiceUtil.getNextId(max_id, "checkpoint"));
		
		return mapper.addCheckpoint(checkpoint);
	}

	@Override
	public int deleteCheckpoint(String checkpoint_id) {
		return mapper.deleteCheckpoint(checkpoint_id);
	}

	@Override
	public String getCheckpointJSON(String checkpoint_id) {
		
		return mapper.getCheckpoint(checkpoint_id).toString();
	}

	@Override
	public int updateCheckpoint(Checkpoint checkpoint) {
		return mapper.updateCheckpoint(checkpoint);
	}
}
