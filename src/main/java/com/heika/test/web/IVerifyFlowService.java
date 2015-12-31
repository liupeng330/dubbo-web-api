/**
 * Copyright(c) 2010-2015 by Renrendai Inc.
 * All Rights Reserved
 */
package com.heika.test.web;

import com.heika.common.verify.AuditUserStatusEnum;
import com.heika.common.verify.VerifyUserStatusOperateEnum;
import com.heika.verify.flow.bean.VerifyStatusVo;
import com.heika.verify.flow.bean.VerifyUserStatusVo;
import org.springframework.stereotype.Service;

/**
 * @author shixuning
 *
 */
public interface IVerifyFlowService
{

    /**
     * 变更流程状态  （进件，补件，一审通过等）
     * @param userId 要变更的用户id
     * @param toStatus 要变更到的状态
     * @return
     */
   public abstract boolean changeVerifyFlowStatus(int userId, AuditUserStatusEnum toStatus, VerifyUserStatusOperateEnum operateEnum, VerifyStatusVo vo);
   
   /**
    * 初始化用户审核状态为UNCOMMIT
    * @param userId 用户id
    * @return VerifyUserStatusVo 初始化后的用户审核状态vo
    */
   public abstract VerifyUserStatusVo initVerifyUserStatus(int userId);
   
   /**
    * 提交用户审核申请为INQUIREING
    * @param userId 用户id
    * @return VerifyUserStatusVo 修改后的用户审核状态vo
    */
   public abstract VerifyUserStatusVo commitVerifyUserStatus(int userId);
   /**
    * 
    * @param userId 用户id
    * @return VerifyUserStatusVo 获取到的用户审核状态vo
    */
   public abstract VerifyUserStatusVo loadVerifyUserStatusByUserId(int userId);
}
