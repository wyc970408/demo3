package com.example.demo.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SchedledConfiguration {

    /**@Bean(name = "detailFactoryBean")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(Job job) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(job);
        bean.setTargetMethod("reportCurrentByCron");
        bean.setConcurrent(false);
        return bean;
    }

    @Bean(name = "cornTriggerBean")
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean detailFactoryBean) {
        CronTriggerFactoryBean tigger=new CronTriggerFactoryBean();
        tigger.setJobDetail(detailFactoryBean.getObject());
        try {
            tigger.setCronExpression("0/5 * * * * ?");
        }catch (Exception e){
            e.printStackTrace();
        }
        return tigger;
    }

   /** @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBeans){
        SchedulerFactoryBean bean=new SchedulerFactoryBean();
        System.err.println(cronTriggerFactoryBeans);
        bean.setTriggers(cronTriggerFactoryBeans);
        return bean;
    }*/
}
