package cn.com.spring_thymealf_jpa_crud4.controller;

import cn.com.spring_thymealf_jpa_crud4.dao.UserRepository;
import cn.com.spring_thymealf_jpa_crud4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    //查询所有
    @GetMapping(value = "/user/findAll")
    public String findAll(Model model){

        List<User> list = userRepository.findAll();
        model.addAttribute("list",list);
        return "show";
    }

    //跳转到添加页面
    @GetMapping(value = "/user/toadd")
    public String toadd(){
        return "add";
    }
    //添加
    @PostMapping(value = "/user/addUser")
    public String addUser(User user){
        userRepository.save(user);
        return "redirect:/user/findAll";
    }

    //修改查询
    @GetMapping(value = "/user/findById/{id}")
    public String findById(@PathVariable("id")Integer id,Model model){
        User user = userRepository.findOne(id);
        model.addAttribute("user",user);
        return "update";
    }
    //修改
    @PutMapping(value = "/user/updateUser")
    public String updateUser(User user){
        userRepository.saveAndFlush(user);
        return "redirect:/user/findAll";
    }

    //删除
    @DeleteMapping(value = "/user/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        userRepository.delete(id);
        return "redirect:/user/findAll";
    }
}

