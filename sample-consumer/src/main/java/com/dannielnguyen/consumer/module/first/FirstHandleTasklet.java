package com.dannielnguyen.consumer.module.first;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstHandleTasklet implements Tasklet {

    private final Log LOGGER = LogFactory.getLog(getClass());

    private static final String JOB_PAYLOAD = "JOB_PAYLOAD";

    @Autowired
    FirstHandleService firstHandleService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        this.LOGGER.debug("SampleTasklet -> execute");

        // Get job parameters
        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        String payload = jobParameters.getString(JOB_PAYLOAD);

        this.LOGGER.debug(payload);

        this.firstHandleService.execute(payload);

        return RepeatStatus.FINISHED;
    }
}
