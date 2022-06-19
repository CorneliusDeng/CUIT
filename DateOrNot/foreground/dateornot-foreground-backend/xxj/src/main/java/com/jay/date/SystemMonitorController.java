package com.jay.date;

import com.jay.date.util.sys.SystemMonitor;
import com.jay.date.util.sys.SystemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jay
 */
@RestController
@CrossOrigin
@RequestMapping("/sys")
public class SystemMonitorController {

    private final SystemMonitor systemMonitor;

    @Autowired
    public SystemMonitorController(SystemMonitor systemMonitor) {
        this.systemMonitor = systemMonitor;
    }

    @GetMapping("/status")
    public SystemStatus getSystemStatus(){
        return systemMonitor.getSystemStatus();
    }
}
