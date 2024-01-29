package com.dannielnguyen.consumer.module.second;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@Configurable
public class SecondHandleModule {

    private static final String JOB_NAME = "SECOND_HANDLE_JOB";
    private static final String STEP_NAME = "SECOND_HANDLE_JOB_FIRST_STEP";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SecondHandleTasklet secondHandleTasklet;

    @Bean
    public Job secondHandleJob() {
        Step sampleFirstStep = new StepBuilder(STEP_NAME, this.jobRepository)
                .tasklet(secondHandleTasklet, this.transactionManager).build();

        return new JobBuilder(this.JOB_NAME, this.jobRepository)
                .start(sampleFirstStep)
                .build();
    }
}
