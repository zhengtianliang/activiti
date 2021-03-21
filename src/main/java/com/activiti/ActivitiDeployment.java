package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @author: ZhengTianLiang
 * @date: 2020/11/1  22:17
 * @desc: 测试流程定义的部署
 */
public class ActivitiDeployment {
    /**
     * @author: ZhengTianLiang
     * @date: 2020/11/1  22:31
     * @desc: 测试流程定义的部署
     * 部署时所涉及的三张表：
     * act_re_deployment：部署信息
     * act_re_procdef：流程定义的一些信息
     * act_ge_bytearray：流程定义的bpmn文件以及png文件
     */
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday01.png")
                .name("请假申请单流程_无心学习啊")
                .deploy();

        // 4、输出一些部署信息
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }
}
