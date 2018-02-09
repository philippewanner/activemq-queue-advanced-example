package io.hotkey.activemqexample.service;

import io.hotkey.activemqexample.domain.event.MembershipRemovalEvent;
import io.hotkey.activemqexample.domain.event.MembershipSubscriptionEvent;
import io.hotkey.activemqexample.domain.model.Member;
import io.hotkey.activemqexample.publisher.EventPublisher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Slf4j
public class MemberService {

   EventPublisher eventPublisher;

   public void createMemberSubscription(final Member member) {
      final MembershipSubscriptionEvent event = new MembershipSubscriptionEvent(member.getId(), member.getEmail());
      eventPublisher.publish(event);
      log.info("createMemberSubscription");
   }

   public void removeMemberSubscription(final Member member) {
      final MembershipRemovalEvent event = new MembershipRemovalEvent(member.getId());
      eventPublisher.publish(event);
      log.info("removeMemberSubscription");
   }
}
