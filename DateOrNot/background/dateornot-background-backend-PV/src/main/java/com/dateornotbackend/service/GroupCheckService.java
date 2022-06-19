package com.dateornotbackend.service;

import com.dateornotbackend.entity.GroupCheck;
import com.dateornotbackend.mapper.GroupCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupCheckService {
    @Autowired
    private GroupCheckMapper groupCheckMapper;

    public int DeleteGroupCheck(int serial_num) {
        return groupCheckMapper.DeleteGroupCheck(serial_num);
    }

    public List<GroupCheck> QueryGroupCheckApplication() {
        return groupCheckMapper.QueryGroupCheckApplication();
    }

    public List<GroupCheck> QueryGroupCheckWarn() {
        return groupCheckMapper.QueryGroupCheckWarn();
    }

    public GroupCheck DetailGroupApplicationCheck(int serial_num) {
        return groupCheckMapper.DetailGroupApplicationCheck(serial_num);
    }

    public GroupCheck DetailGroupWarnCheck(int serial_num) {
        return groupCheckMapper.DetailGroupWarnCheck(serial_num);
    }
}
