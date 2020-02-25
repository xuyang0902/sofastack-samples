package com.ant.sofastack.registry;

import com.alipay.sofa.registry.client.api.Publisher;
import com.alipay.sofa.registry.client.api.RegistryClientConfig;
import com.alipay.sofa.registry.client.api.Subscriber;
import com.alipay.sofa.registry.client.api.SubscriberDataObserver;
import com.alipay.sofa.registry.client.api.model.RegistryType;
import com.alipay.sofa.registry.client.api.model.UserData;
import com.alipay.sofa.registry.client.api.registration.PublisherRegistration;
import com.alipay.sofa.registry.client.api.registration.SubscriberRegistration;
import com.alipay.sofa.registry.client.provider.DefaultRegistryClient;
import com.alipay.sofa.registry.client.provider.DefaultRegistryClientConfigBuilder;
import com.alipay.sofa.registry.core.model.ScopeEnum;

/**
 * @author xu.qiang
 * @date 2020/2/24
 */
public class SubscriberClient {
    public static void main(String[] args) throws InterruptedException {


        RegistryClientConfig config =  DefaultRegistryClientConfigBuilder.start().setRegistryEndpoint("192.168.42.130").setRegistryEndpointPort(9603).build();
        DefaultRegistryClient registryClient = new DefaultRegistryClient(config);
        registryClient.init();





        // 构造订阅者注册表，设置订阅维度，ScopeEnum 共有三种级别 zone, dataCenter, global
        SubscriberRegistration registration = new SubscriberRegistration(
                "helloworld.service:2.0@DEFAULT",
                // 创建 SubscriberDataObserver
                new SubscriberDataObserver() {
                    @Override
                    public void handleData(String dataId, UserData data) {
                        System.out.println("receive data success, dataId: " + dataId + ", data: " + data);
                    }
        });
        registration.setGroup("group_0");
        registration.setAppName("portal");
        registration.setScopeEnum(ScopeEnum.global);

        // 将注册表注册进客户端并订阅数据，订阅到的数据会以回调的方式通知 SubscriberDataObserver
        Subscriber subscriber = registryClient.register(registration);

        registryClient.unregister("helloworld.service:2.0@DEFAULT","group_0", RegistryType.SUBSCRIBER);

        while(true){
            Thread.sleep(1000);
        }
    }

}
