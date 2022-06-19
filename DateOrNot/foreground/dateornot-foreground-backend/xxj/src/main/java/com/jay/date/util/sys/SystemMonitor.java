package com.jay.date.util.sys;

import org.springframework.stereotype.Component;

/**
 * @author Jay
 */
@Component
public class SystemMonitor {

    public SystemStatus getSystemStatus(){
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();
        int availableProcessors = runtime.availableProcessors();

        return new SystemStatus(freeMemory, maxMemory, totalMemory, availableProcessors);
    }
}
