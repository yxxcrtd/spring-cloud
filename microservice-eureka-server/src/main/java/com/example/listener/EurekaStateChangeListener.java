package com.example.listener;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.registry.AbstractInstanceRegistry;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    /**
     * EurekaInstanceCanceledEvent 服务下线事件
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        System.out.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }

    /**
     * EurekaInstanceRegisteredEvent 服务注册事件
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo.getAppName() + " 进行注册");
    }

    /**
     * EurekaInstanceRenewedEvent 服务续约事件
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        System.out.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    /**
     * EurekaRegistryAvailableEvent Eureka注册中心启动事件
     * @param event
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.out.println("注册中心 启动");
    }

    /**
     * EurekaServerStartedEvent Eureka Server启动事件
     * @param event
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        System.out.println("Eureka Server 启动");
    }

    @EventListener
    public void listen(AbstractInstanceRegistry event) {
        System.out.println("Eureka Server 服务的时间清理================");
    }

}
