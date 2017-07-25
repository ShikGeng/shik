/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
package com.shik.quartz;


import com.shik.support.component.SpringContextUtil;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author gengshikun
 * @date 2017/6/22
 */
@Configuration
public class QuartzConfig {

    @Bean(name = "testJob")
    public MethodInvokingJobDetailFactoryBean testJob() {
        MethodInvokingJobDetailFactoryBean testJob = new MethodInvokingJobDetailFactoryBean();

        testJob.setTargetObject(SpringContextUtil.getBean("testJob1"));
        testJob.setTargetMethod("test");
        testJob.setConcurrent(Boolean.FALSE);
        return testJob;
    }

    @Bean(name = "testJob_cronTrigger")
    public CronTriggerFactoryBean testJob_cronTrigger(@Qualifier("testJob") JobDetail testJob) {
        CronTriggerFactoryBean testJob_cronTrigger = new CronTriggerFactoryBean();
        testJob_cronTrigger.setJobDetail(testJob);
        testJob_cronTrigger.setCronExpression("0/5 * * * * ? ");
        return testJob_cronTrigger;
    }

    @Bean(name = "testJob11")
    public MethodInvokingJobDetailFactoryBean testJob11() {
        MethodInvokingJobDetailFactoryBean testJob = new MethodInvokingJobDetailFactoryBean();

        testJob.setTargetObject(SpringContextUtil.getBean("testJob1"));
        testJob.setTargetMethod("test1");
        testJob.setConcurrent(Boolean.FALSE);
        return testJob;
    }

    @Bean(name = "testJob_cronTrigger11")
    public CronTriggerFactoryBean testJob_cronTrigger11(@Qualifier("testJob11") JobDetail testJob) {
        CronTriggerFactoryBean testJob_cronTrigger = new CronTriggerFactoryBean();
        testJob_cronTrigger.setJobDetail(testJob);
        testJob_cronTrigger.setCronExpression("0/5 * * * * ? ");
        return testJob_cronTrigger;
    }

    @Bean
    public SchedulerFactoryBean startQuertz(@Qualifier("testJob_cronTrigger") Trigger testJob_cronTrigger,
                                            @Qualifier("testJob_cronTrigger11") Trigger testJob_cronTrigger11) {
        SchedulerFactoryBean startQuertz = new SchedulerFactoryBean();

//        startQuertz.setTriggers(testJob_cronTrigger, testJob_cronTrigger11);

        return startQuertz;
    }

}
