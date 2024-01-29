package com.dannielnguyen.sampleconsumer.module.first;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class FirstHandleTasklet implements Tasklet {

    private final Log LOGGER = LogFactory.getLog(getClass());

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        this.LOGGER.debug("SampleTasklet -> execute");

        return RepeatStatus.FINISHED;
    }
}
