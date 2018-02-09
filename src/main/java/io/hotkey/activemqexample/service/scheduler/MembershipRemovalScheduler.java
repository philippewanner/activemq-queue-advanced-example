package io.hotkey.activemqexample.service.scheduler;

import io.hotkey.activemqexample.domain.model.Member;
import io.hotkey.activemqexample.service.MemberService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MembershipRemovalScheduler {

   MemberService service;

   @Scheduled(fixedRate = 5000L)
   public void scheduler() {
      Member member = Member.builder().id("id007").email("philippe@example.com").build();
      service.removeMemberSubscription(member);

   }
}
