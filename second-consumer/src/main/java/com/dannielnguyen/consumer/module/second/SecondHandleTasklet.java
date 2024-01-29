package com.dannielnguyen.consumer.module.second;

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
public class SecondHandleTasklet implements Tasklet {

    private final Log LOGGER = LogFactory.getLog(getClass());

    private static final String JOB_CONSUMER_ID = "JOB_CONSUMER_ID";
    private static final String JOB_CONSUMER_GROUP = "JOB_CONSUMER_GROUP";
    private static final String JOB_PAYLOAD = "JOB_PAYLOAD";

    @Autowired
    SecondHandleService secondHandleService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Get job parameters
        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        String consumerId = jobParameters.getString(JOB_CONSUMER_ID);
        String consumerGroup = jobParameters.getString(JOB_CONSUMER_GROUP);
        String payload = jobParameters.getString(JOB_PAYLOAD);

        this.LOGGER.debug(String.format("SampleTasklet -> execute[%s][%s]: %s", consumerId, consumerGroup, payload));

        this.secondHandleService.execute(consumerId, consumerGroup, payload);

        return RepeatStatus.FINISHED;
    }
}
