package com.dannielnguyen.sampleconsumer.core.kafka;

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
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FirstConsumer {

    protected final Log LOGGER = LogFactory.getLog(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSZZ");

    private static final String JOB_PAYLOAD = "JOB_PAYLOAD";

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job firstConsumerHandleJob;

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(String message) {
        // Print statement
        System.out.println("message = " + message);

        // Get current java server date time
        Date currentDateTime = new Date();

        // Create job parameters
        JobParameters jobParameters = new JobParametersBuilder()
                .addString(JOB_PAYLOAD, message)
                .toJobParameters();

        // Start running job
        try {

            LOGGER.info(String.format("==[SAMPLE SCHEDULER (%s)] START FIRST_CONSUMER_JOB: %s",
                    dateFormat.format(currentDateTime),
                    jobParameters.getString(JOB_PAYLOAD)));

            jobLauncher.run(firstConsumerHandleJob, jobParameters);

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
