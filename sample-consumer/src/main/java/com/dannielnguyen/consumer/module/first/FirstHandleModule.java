package com.dannielnguyen.consumer.module.first;

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
public class FirstHandleModule {

    private static final String FIRST_HANDLE_JOB = "FIRST_HANDLE_JOB";
    private static final String FIRST_HANDLE_JOB_FIRST_STEP = "FIRST_HANDLE_JOB_FIRST_STEP";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private FirstHandleTasklet firstHandleTasklet;

    @Bean
    public Job firstHandleJob() {
        Step sampleFirstStep = new StepBuilder(FIRST_HANDLE_JOB_FIRST_STEP, this.jobRepository)
                .tasklet(firstHandleTasklet, this.transactionManager).build();

        return new JobBuilder(this.FIRST_HANDLE_JOB, this.jobRepository)
                .start(sampleFirstStep)
                .build();
    }
}
