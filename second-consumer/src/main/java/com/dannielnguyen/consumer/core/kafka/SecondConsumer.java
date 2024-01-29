package com.dannielnguyen.consumer.core.kafka;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SecondConsumer {

    protected final Log LOGGER = LogFactory.getLog(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSZZ");

    private static final String JOB_TIME = "JOB_TIME";
    private static final String JOB_CONSUMER_ID = "JOB_CONSUMER_ID";
    private static final String JOB_CONSUMER_GROUP = "JOB_CONSUMER_GROUP";
    private static final String JOB_PAYLOAD = "JOB_PAYLOAD";

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job secondHandleJob;

    @Value("${kafka.consumer.second.id}")
    private String consumerId;

    @Value("${kafka.consumer.second.group}")
    private String consumerGroup;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumer.second.group}")
    public void consume(String message) {
        // Print statement
        System.out.println("message = " + message);

        // Get current java server date time
        Date currentDateTime = new Date();

        // Create job parameters
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong(JOB_TIME, currentDateTime.getTime())
                .addString(JOB_CONSUMER_ID, this.consumerId)
                .addString(JOB_CONSUMER_GROUP, this.consumerGroup)
                .addString(JOB_PAYLOAD, message)
                .toJobParameters();

        // Start running job
        try {

            LOGGER.info(String.format("==[FirstConsumer] START FIRST_HANDLE_JOB[%s][%s]: %s",
                    jobParameters.getString(JOB_CONSUMER_ID),
                    jobParameters.getString(JOB_CONSUMER_GROUP),
                    jobParameters.getString(JOB_PAYLOAD)));

            jobLauncher.run(secondHandleJob, jobParameters);

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
