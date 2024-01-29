package com.dannielnguyen.sampleconsumer.module.sample;

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
public class SampleModule {

    private static final String SAMPLE_JOB = "SAMPLE_JOB";
    private static final String SAMPLE_JOB_MAIN_STEP = "SAMPLE_JOB_MAIN_STEP";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SampleTasklet sampleTasklet;

    @Bean
    public Job sampleJob() {
        Step sampleFirstStep = new StepBuilder(SAMPLE_JOB_MAIN_STEP, this.jobRepository)
                .tasklet(sampleTasklet, this.transactionManager).build();

        return new JobBuilder(this.SAMPLE_JOB, this.jobRepository)
                .start(sampleFirstStep)
                .build();
    }
}
