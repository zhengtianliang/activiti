package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author: ZhengTianLiang
 * @date: 2020/11/1 0001 22:42
 * @desc: 启动流程实例，前提是已经部署好了。(先后顺序需要注意)
 */
public class ActivitiStartInstance {

    public static void main(String[] args) {
        // 1、得到ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RunService对象
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        // 3、创建流程实例，流程定义的key需要知道
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("holiday");

        // 4、输出实例的相关信息
        System.out.println("流程部署id：" + instance.getDeploymentId()); // null
        System.out.println("流程定义id：" + instance.getProcessDefinitionId()); // holiday:1:4
        System.out.println("流程实例id：" + instance.getId()); // 5001
        System.out.println("活动id：" + instance.getActivityId()); // null

    }
}
