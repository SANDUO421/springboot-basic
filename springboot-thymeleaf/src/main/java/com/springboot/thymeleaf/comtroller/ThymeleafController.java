package com.springboot.thymeleaf.comtroller;

import com.springboot.thymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 三多
 * @Time 2020/4/11
 */
@Controller
public class ThymeleafController {
    /**
     * 显示普通文本
     * @param model
     * @return
     */
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        return "show";
    }

    /**
     * 显示带有样式的普通文本
     * @param model
     * @return
     */
    @RequestMapping(value = "showStyle", method = RequestMethod.GET)
    public String showStyle(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","<span style='color:red'>sanduo</span>");
        return "show_style";
    }

    /**
     * 显示对象 thymeleaf
     * @param model
     * @return
     */
    @RequestMapping(value = "/message/member_show", method = RequestMethod.GET)
    public String memberShow(Model model) {
        User vo = new User();
        vo.setUid(12345678L);
        vo.setName("尼古拉丁.赵四");
        vo.setAge(59);
        vo.setSalary(1000.00);
        vo.setBirthday(new Date());
        model.addAttribute("member", vo);
        return "message/member_show";
    }

    /**
     * 数据处理 list
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/set", method = RequestMethod.GET)
    public String set(Model model) {
        Set<String> allNames = new HashSet<String>() ;
        List<Integer> allIds = new ArrayList<Integer>() ;
        for (int x = 0 ; x < 5 ; x ++) {
            allNames.add("boot-" + x) ;
            allIds.add(x) ;
        }
        for (String allName : allNames) {
            System.out.println(allName);
        }
        model.addAttribute("names", allNames) ;
        model.addAttribute("ids", allIds) ;
        model.addAttribute("mydate", new java.util.Date()) ;
        return "user_set" ;
    }

    /**
     * 操作内置对象
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/inner", method = RequestMethod.GET)
    public String inner(HttpServletRequest request, Model model) {
        request.setAttribute("requestMessage", "springboot-request");
        request.getSession().setAttribute("sessionMessage", "springboot-session");
        request.getServletContext().setAttribute("applicationMessage",
                "springboot-application");
        model.addAttribute("url", "www.baidu.cn");
        request.setAttribute("url2",
                "<span style='color:red'>www.baidu.cn</span>");
        return "show_inner";
    }

    /**
     * 数据遍历map
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/map", method = RequestMethod.GET)
    public String map(Model model) {
        Map<String,User> allMembers = new HashMap<String,User>();
        for (int x = 0; x < 10; x++) {
            User vo = new User();
            vo.setUid(101L + x);
            vo.setName("赵四 - " + x);
            vo.setAge(9);
            vo.setSalary(99999.99);
            vo.setBirthday(new Date());
            allMembers.put("mldn-" + x, vo);
        }
        model.addAttribute("allUsers", allMembers);
        return "user_map";
    }

    /**
     * 数据便利List
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> allMembers = new ArrayList<User>();
        for (int x = 0; x < 10; x++) {
            User vo = new User();
            vo.setUid(101L + x);
            vo.setName("赵四 - " + x);
            vo.setAge(9);
            vo.setSalary(99999.99);
            vo.setBirthday(new Date());
            allMembers.add(vo) ;
        }
        model.addAttribute("allUsers", allMembers);
        return "user_list";
    }
}
