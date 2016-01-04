package com.heika.test.web;
import com.heika.verify.base.util.JsonResultVo;
import com.heika.verify.flow.bean.VerifyUserStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.heika.verify.flow.inerface.IVerifyFlowService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

@RequestMapping("/")
@Controller
public class VerifyFlowController
{
    @Autowired
    private IVerifyFlowService flowTaskService;

    @PostConstruct
    public void postConstruct()
    {
        System.out.println("**************************");
        System.out.println("DubboControllerForTest regist");
        System.out.println("**************************");
    }

    @RequestMapping(value = "/init")
    @ResponseBody
    public JsonResultVo init(@RequestParam(value="userId", required = true) Integer userId)
    {
        flowTaskService.initVerifyUserStatus(userId);
        return JsonResultVo.success();
    }

    @RequestMapping(value = "/commit")
    @ResponseBody
    public JsonResultVo commit(@RequestParam(value="userId", required = true) Integer userId)
    {
        flowTaskService.commitVerifyUserStatus(userId);
        return JsonResultVo.success();
    }

    @RequestMapping(value = "/load")
    @ResponseBody
    public JsonResultVo load(@RequestParam(value="userId", required = true) Integer userId)
    {
        JsonResultVo jsonResultVo = JsonResultVo.success();
        jsonResultVo.addData("VerifyUserStatusVo", flowTaskService.loadVerifyUserStatusByUserId(userId));
        return jsonResultVo;
    }
}
