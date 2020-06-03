package com.cd.oa.controller;

import com.cd.oa.entity.Adverstise;
import com.cd.oa.entity.Employee;
import com.cd.oa.global.Contant;
import com.cd.oa.service.AdverstiseService;
import com.cd.oa.service.DepartmentService;
import com.cd.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adverstise")
public class AdverstiseController {

    @Autowired
    private AdverstiseService adverstiseService;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        Map map2=new HashMap();
        map.put("list",adverstiseService.selectAdverstiseByMap(map2));
        return "adverstise_list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Map<String,Object> map){
        return "adverstise_add";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request,Adverstise adverstise){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        adverstise.setGmtTime(simpleDateFormat.format(new Date()));
        adverstise.setOperaterName(((Employee)request.getSession().getAttribute("employee")).getName());
        adverstise.setOperaterId(((Employee)request.getSession().getAttribute("employee")).getId());
        adverstiseService.add(adverstise);
        return "redirect:/adverstise/list";
    }

    @RequestMapping(value = "/toUpdate/{id}")
    public String toUpdate(@PathVariable(value = "id")String id,Map<String,Object> map){
        Map map1=new HashMap();
        map1.put("id",id);
        map.put("adverstise", adverstiseService.selectAdverstiseByMap(map1).get(0));
        return "adverstise_update";
    }

    @RequestMapping("/update/{id}")
    public String update(HttpServletRequest request,Adverstise adverstise,@PathVariable(value = "id")Integer id){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        adverstise.setId(id);
        adverstise.setGmtTime(simpleDateFormat.format(new Date()));
        adverstise.setOperaterName(((Employee)request.getSession().getAttribute("employee")).getName());
        adverstise.setOperaterId(((Employee)request.getSession().getAttribute("employee")).getId());
        adverstiseService.update(adverstise);
        return "redirect:/adverstise/list";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id")String id){
        adverstiseService.delete(id);
        return "redirect:/adverstise/list";
    }

}
