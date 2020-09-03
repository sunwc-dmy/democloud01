package com.sunwc.service7002.Component;

import com.sunwc.service7002.Service.FeignFallBackFactoryClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBackFactory implements FallbackFactory<FeignFallBackFactoryClient> {
    @Override
    public FeignFallBackFactoryClient create(Throwable throwable) {
        return new FeignFallBackFactoryClient() {
            @Override
            public void feignTest(String msg) {
                System.out.println("feign调用，熔断工厂降级");
            }
        };
    }
}
