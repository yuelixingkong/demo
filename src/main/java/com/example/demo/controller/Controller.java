package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class Controller {
    @Resource
    UserDao userDao;
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser (HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        Map map = new HashMap();
        user = userDao.selectByPrimaryKey(userId);
        return user;
    }
}
