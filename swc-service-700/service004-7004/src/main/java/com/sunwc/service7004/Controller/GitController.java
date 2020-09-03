package com.sunwc.service7004.Controller;

import com.sunwc.service7004.Component.GitAutoRefreshConfig;
import com.sunwc.service7004.Component.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//git文件修改，自动刷新（@value不支持，@ConfigurationProperties支持）
@RefreshScope
public class GitController {

    @Autowired
    private GitConfig gitConfig;

    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    @GetMapping(value = "show")
    public Object show() {
        return gitConfig;
    }

    @GetMapping(value = "autoShow")
    public Object autoShow() {
        return gitAutoRefreshConfig;
    }

    @GetMapping("/")
    public String index (){
        return "我是Service004";
    }
}