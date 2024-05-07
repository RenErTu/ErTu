package com.iflytek.Controller;

import com.iflytek.Dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private IUserDao iUserDao;

    @RequestMapping("/getCode")
    @ResponseBody
    public String test() {
        int Code =(int)(Math.random()*10000);
        redisTemplate.opsForValue().set("Code",String.valueOf(Code),1, TimeUnit.MINUTES);
        return String.valueOf(Code);
    }

    @RequestMapping("/gogoin")
    @ResponseBody
    public String gogoin(@RequestParam("code") String code, @RequestParam("username") String username,
                         @RequestParam("password") String password) {

        String Code = redisTemplate.opsForValue().get("Code");
        if(Code.equals(code)){
            iUserDao.insertUser(username,password);
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login() {
        return "login success";
    }
}
