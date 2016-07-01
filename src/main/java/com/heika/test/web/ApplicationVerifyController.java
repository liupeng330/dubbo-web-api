package com.heika.test.web;

import com.heika.verify.base.util.JsonResultVo;
import com.heika.verify.flow.api.IApplicationPublicService;
import com.heika.verify.flow.common.ApplicationStatusEnum;
import com.heika.verify.flow.common.ApplicationStatusOperateEnum;
import com.heika.verify.flow.vo.ApplicationStatusVo;
import com.heika.verify.flow.vo.ApplicationSubmitResultVo;
import com.heika.verify.flow.vo.CheckCanSubmitApplicationResultVo;
import com.heika.verify.flow.vo.LoadApplicationStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by peng on 16-7-1.
 */
@RequestMapping("/incommingApplication")
@Controller
public class ApplicationVerifyController
{
    @Autowired
    private IApplicationPublicService applicationService;

    @RequestMapping(value = "/submitApplication")
    @ResponseBody
    public JsonResultVo submitApplication(String userKey, Integer productType, Integer channelId, boolean isSelfRegister, String blackBoxId, String platform)
    {
        ApplicationSubmitResultVo rst = applicationService.submitApplication(userKey, productType, channelId,
                isSelfRegister, blackBoxId, platform);
        return JsonResultVo.success().addData("rst", rst);
    }

    @RequestMapping(value = "/changeApplicationStatus")
    @ResponseBody
    public boolean changeApplicationStatus(String applicationId, String userKey,
                                                ApplicationStatusOperateEnum operateEnum, ApplicationStatusEnum toStatus, ApplicationStatusVo verifyStatusVo)
    {
        return this.applicationService.changeApplicationStatus(applicationId, userKey, operateEnum, toStatus, verifyStatusVo);
    }

    @RequestMapping(value = "/loadApplicationStatus")
    @ResponseBody
    public JsonResultVo loadApplicationStatus(String applicationId)
    {
        LoadApplicationStatusVo rst = applicationService.loadApplicationStatus(applicationId);
        return JsonResultVo.success().addData("rst", rst);
    }

    @RequestMapping(value = "/checkCanSubmitApplication")
    @ResponseBody
    public JsonResultVo submitApplication(String userKey)
    {
        CheckCanSubmitApplicationResultVo rst = applicationService.checkCanSubmitApplication(userKey);
        return JsonResultVo.success().addData("rst", rst);
    }
}
