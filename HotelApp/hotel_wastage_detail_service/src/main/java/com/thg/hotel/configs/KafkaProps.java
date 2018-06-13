package com.thg.hotel.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "kafka")
public class KafkaProps {
  private String  brokerHost;
  private String  topic;
  private Integer totalConcurrentConsumers;
  private String  consumerId;
  private String  consumerGroup;
  private Boolean sslEnabled;
  private String  sslKeystorePath;
  private String  sslKeystorePassword;
  private String  sslTruststorePath;
  private String  sslTruststorePassword;
  private String  securityProtocol;
  private Integer maxRecordsToPoll;
}
