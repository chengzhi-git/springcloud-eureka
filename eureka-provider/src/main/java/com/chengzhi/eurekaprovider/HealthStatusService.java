package com.chengzhi.eurekaprovider;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @Author:chengzhi
 * @Date:2021/7/25 12:35
 * @Description
 */

@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public Health health() {
        if(status)
            return new Health.Builder().up().build();
        return new Health.Builder().down().build();
    }

    public String getStatus() {
        return this.status.toString();
    }
}
