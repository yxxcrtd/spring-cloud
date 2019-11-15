package com.example.listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 用于监控 Eureka Server 宕机的报警机制
 */
@Slf4j
//@Configuration
//@EnableScheduling
public class EurekaServerStopedListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // EurekaInstanceCanceledEvent 服务下线事件
        if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
            // 获取当前Eureka实例中的节点信息
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();
            // 遍历获取已注册节点中与当前失效节点ID一致的节点信息
            applications.getRegisteredApplications().forEach((registeredApplication) -> {
                registeredApplication.getInstances().forEach((instance) -> {
                    if (instance.getInstanceId().equals(event.getServerId())) {
                        log.info("服务：" + instance.getAppName() + " 挂了。。。");
                        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!这里需要发邮件、短信、微信、钉钉等!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                    }
                });
            });
        }

        // EurekaInstanceRegisteredEvent 服务注册事件
        if (applicationEvent instanceof EurekaInstanceRegisteredEvent) {
            EurekaInstanceRegisteredEvent event = (EurekaInstanceRegisteredEvent) applicationEvent;
            log.info("服务：" + event.getInstanceInfo().getAppName() + " 注册成功！");
        }

        // EurekaInstanceRenewedEvent 服务续约事件
        if (applicationEvent instanceof EurekaInstanceRenewedEvent) {
            EurekaInstanceRenewedEvent event = (EurekaInstanceRenewedEvent) applicationEvent;
            log.info("服务：" + event.getInstanceInfo().getAppName() + "续约 ......");
        }

        // EurekaRegistryAvailableEvent Eureka注册中心启动事件
        if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
            log.info("Eureka Server 注册中心启动了 ......");
        }

    }


}
