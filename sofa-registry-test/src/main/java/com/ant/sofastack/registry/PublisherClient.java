package com.ant.sofastack.registry;

import com.alipay.sofa.registry.client.api.Publisher;
import com.alipay.sofa.registry.client.api.RegistryClientConfig;
import com.alipay.sofa.registry.client.api.Subscriber;
import com.alipay.sofa.registry.client.api.SubscriberDataObserver;
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
public class PublisherClient {

    public static void main(String[] args) throws InterruptedException {

        //注册中心 sessionproxy
        RegistryClientConfig config =  DefaultRegistryClientConfigBuilder
                .start()
                .setRegistryEndpoint("192.168.42.130")
                .setRegistryEndpointPort(9603)
                .build();
        DefaultRegistryClient registryClient = new DefaultRegistryClient(config);
        registryClient.init();


        // 构造发布者注册表
        PublisherRegistration registration = new PublisherRegistration("helloworld.service:2.0@DEFAULT");
        registration.setGroup("group_0");
        registration.setAppName("trade");

        // 将注册表注册进客户端并发布数据
        Publisher publisher = registryClient.register(registration, "192.168.42.130:12200?name=yuren");


        int index = 0;
        while(true){
            Thread.sleep(1000);
            System.out.println("--->重新发布数据");
            // 如需覆盖上次发布的数据可以使用发布者模型重新发布数据
            publisher.republish("192.168.42.130:12200?name=yuren" + "&age=" + index++);

        }


    }
}
