package com.blolq.controller;

import com.blolq.model.UserEntity;
import com.blolq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by michael on 2016/8/9.
 */
@Controller
public class MainController
{
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public String showNote(String id)
    {
        return "success";
    }

    @RequestMapping(value = "admin/users")
    public String getUsers(ModelMap modelMap)
    {
        // 查询user表中的所有记录
        List<UserEntity> userEntityList = userRepository.findAll();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("userEntityList", userEntityList);
        // 返回pages目录下的admin/users.jsp
        return "admin/users";
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser()
    {
        // 转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/admin/users/addP")
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity)
    {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        // userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
        userRepository.saveAndFlush(userEntity);
        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap)
    {
        // 找到userId所表示的用户
        UserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }

    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap)
    {
        // 找到userId所表示用户
        UserEntity userEntity = userRepository.findOne(userId);
        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity userEntity)
    {
        // 更新用户信息
        userRepository.updateUser(userEntity.getNickname(), userEntity.getFirstName(), userEntity.getLastName(),
                userEntity.getPassword(), userEntity.getId());
        userRepository.flush();// 刷新缓存区
        return "redirect:/admin/users";

    }

    // 删除用户
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        // 删除id为userId的用户
        userRepository.delete(userId);
        // 立即刷新
        userRepository.flush();
        return "redirect:/admin/users";
    }
}
