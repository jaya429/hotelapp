package com.thg.hotel.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Profile ("!test")
@SuppressFBWarnings ("DM_NEXTINT_VIA_NEXTDOUBLE")
@Configuration
@EnableKafka
@EnableConfigurationProperties (KafkaProps.class)
public class KafkaConsumerConfig {

  @Autowired private KafkaProps kafkaProps;

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    // list of host:port pairs used for establishing the initial connections
    // to the Kakfa cluster
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProps.getBrokerHost());
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    // allows a pool of processes to divide the work of consuming and
    // processing records
    props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProps.getConsumerGroup());
    props.put(ConsumerConfig.CLIENT_ID_CONFIG,
        (kafkaProps.getConsumerId() + "-" + ((int) (Math.random() * 8847))));
    // maximum records per poll
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaProps.getMaxRecordsToPoll());
    
    return props;
  }

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    factory.setConcurrency(kafkaProps.getTotalConcurrentConsumers());
    return factory;
  }

}
