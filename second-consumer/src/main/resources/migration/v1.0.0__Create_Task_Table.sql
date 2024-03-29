CREATE TABLE IF NOT EXISTS CONSUMER_TASK
(
    ID             BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    CONSUMER_ID    VARCHAR(255)                      NOT NULL,
    CONSUMER_GROUP VARCHAR(255)                      NOT NULL,
    HANDLER        VARCHAR(255)                      NOT NULL,
    PAYLOAD        VARCHAR(255)                      NOT NULL,
    CREATED_AT     TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT     TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);