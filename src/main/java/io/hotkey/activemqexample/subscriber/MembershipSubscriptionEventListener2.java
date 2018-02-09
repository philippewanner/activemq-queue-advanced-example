package io.hotkey.activemqexample.subscriber;

import io.hotkey.activemqexample.domain.event.MembershipSubscriptionEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MembershipSubscriptionEventListener2 {

   @JmsListener(
           destination = "${event.queue.name}",
           selector = "_type ='MembershipSubscriptionEvent'")
   public void onEvent(MembershipSubscriptionEvent event) {
      log.info("ListenerS2 received msg: {}", event);
   }
}
