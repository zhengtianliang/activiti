package com.test;

import org.activiti.engine.*;
import org.junit.Test;

/**
 * @author: ZhengTianLiang
 * @date: 2020/11/1  16:27
 * @desc:
 */

public class ActivitiTest {

    /**
     * @author ZhengTianLiang
     * @date: 2020/11/1  16:29
     * @desc: 测试activiti所需要的25张表的生成     方法1
     */
    @Test
    public void testGenerateTable() {
        // 1、创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.
                createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        // 2、创建ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        // 3、输出ProcessEngine对象
        System.out.println(processEngine);

    }

    /**
     * @author ZhengTianLiang
     * @date: 2020/11/1  16:39
     * @desc: 测试activiti所需要的25张表的生成    方法2
     */
    @Test
    public void testGenerateTable02() {
        // 要想用这一行代码实现上面同样的效果，必须满足两个条件
        // 条件：1、activiti的配置文件必须叫做activiti.cfg.xml  2、bean的id必须叫做"processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 3、输出ProcessEngine对象
        System.out.println(processEngine);

        HistoryService historyService = processEngine.getHistoryService();  // activiti的历史管理类
        RepositoryService repositoryService = processEngine.getRepositoryService(); // activiti的资源管理类
        RuntimeService runtimeService = processEngine.getRuntimeService();  // activiti的流程运行管理类
        TaskService taskService = processEngine.getTaskService();  // activiti的任务管理类
        ManagementService managementService = processEngine.getManagementService(); // activiti的引擎管理类

        /**
         * activiti自带的25张表的命名规则：
         *      ACT_RE_*: 'RE'表示repository，这个前缀代表了流程定义和流程静态资源(图片、规则等等)
         *      ACT_RU_*：'RU'表示runtime，这些运行时的表，包含流程实例，任务、变量，异步任务，在流程结束后就会删除这些记录
         *      ACT_HI_*：'HI'表示history，这些表包含历史数据，变量、任务等等
         *      ACT_GE_*：'GE'表示general，通用数据，用于不同场景下。
         */


    }
}
