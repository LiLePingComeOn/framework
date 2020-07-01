package com.zksc.framework.Controller;

import com.zksc.framework.Service.RedisService;
import com.zksc.framework.Service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/login.do")
    public String userLogin(Model model){

        redisService.set("name", "llp");

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("llp", "125811");
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(usernamePasswordToken);
            return "index.html";
        } catch (Exception e) {
            return "404.html";
        }
    }

    @RequestMapping("/code.do")
    public String getCode(Model model) {
        return "code.html";
    }

}
