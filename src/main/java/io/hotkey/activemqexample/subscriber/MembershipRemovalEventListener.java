package io.hotkey.activemqexample.subscriber;

import io.hotkey.activemqexample.domain.event.MembershipRemovalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MembershipRemovalEventListener {

   @JmsListener(
           destination = "${event.queue.name}",
           selector = "_type ='MembershipRemovalEvent'")
   public void onEvent(MembershipRemovalEvent event) {
      log.info("ListenerR1 received msg: {}", event);
   }
}

