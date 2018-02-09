package io.hotkey.activemqexample.publisher;

import io.hotkey.activemqexample.domain.event.DomainEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
@EnableScheduling
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@AllArgsConstructor
public class JmsEventPublisher implements EventPublisher {

   final JmsTemplate jmsTemplate;
   final Destination destination;

   @Override
   public void publish(DomainEvent event) {
      jmsTemplate.convertAndSend(destination, event);
      log.trace("Sent event. [destination={}, event={}]", destination, event);
   }
}
