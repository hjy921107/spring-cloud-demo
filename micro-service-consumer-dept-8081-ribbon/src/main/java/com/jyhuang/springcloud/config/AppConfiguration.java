package com.jyhuang.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    @LoadBalanced // 客户端开启负载均衡，默认为轮循算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Ribbon 默认使用负载均衡算法是轮循算法（RoundRibbonRule）
     * 此处修改默认算法，使用随机算法（RandomRule）
     *
     * Ribbon 提供的负载均衡算法详见 IRule 下的实现类
     *
     * Ribbon 也支持自定义负载均衡算法，只需要实现 IRule 接口
     *        或者继承 AbstractLoadBalancerRule 抽象类，然后注入容器即可
     *        具体的实现可参考 Ribbon 提供算法的源码，进行修改。
     * 注意：
     *     自定义的负载均衡算法类不能放在主配置类（@SpringBootApplication 标注的类）
     *     所在包及其子包下
     */
    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
