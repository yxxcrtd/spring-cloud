# 服务规划：
### eureka-server         8761
### config-server         8888

### user-provider         8082
### user-provider1        8083
### user-provider2        8084

### user-consumer         8090
### user-consumer-feign   8091
### user-consumer-hystrix 8092

## 整合 SkyWalking
### 官网：http://skywalking.apache.org

### 1，安装 elasticsearch
#### Data:    /usr/local/var/lib/elasticsearch/
#### Logs:    /usr/local/var/log/elasticsearch/elasticsearch_young.log
#### Plugins: /usr/local/var/elasticsearch/plugins/
#### Config:  /usr/local/etc/elasticsearch/
#### 运行：brew services start elasticsearch
#### 不要后台服务的话，直接运行：elasticsearch


