package com.tjdata.controller;


import com.tjdata.domain.User;
import com.tjdata.mapper.UserMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class userController {
    @Resource
    private UserMapper userMapper;

    @PostMapping("userLogin")
    public Object userLogin(@RequestBody User userInfo) {
        String userName = userInfo.userName;
        String passWord = userInfo.passWord;

        JSONObject json = new JSONObject();
        String PassWord = userMapper.getPassWord(userName);
        if (passWord.equals(PassWord)) {
            List<User> user = userMapper.Login(userName);
            json.put("code", "0");
            json.put("msg", "登陆成功");
            json.put("data", user);
        } else {
            json.put("code", "1");
            json.put("msg", "登陆失败");
        }

        return json;
    }

    @GetMapping("userRegis")
    public Object userRegis(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        UUID uuid = UUID.randomUUID();
        Integer result = userMapper.Regis(userName, passWord, uuid.toString());
        JSONObject json = new JSONObject();
        if (result == 1) {
            json.put("code", "0");
            json.put("msg", "注册成功");
        } else {
            json.put("code", "1");
            json.put("msg", "注册失败");
        }
        return json;

    }

}
