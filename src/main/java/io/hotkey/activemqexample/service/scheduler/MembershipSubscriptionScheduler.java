package io.hotkey.activemqexample.service.scheduler;

import io.hotkey.activemqexample.domain.model.Member;
import io.hotkey.activemqexample.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
public class MembershipSubscriptionScheduler {

   MemberService service;

   @Scheduled(fixedRate = 2000L)
   public void scheduler() {
      Member member = Member.builder().id("id007").email("philippe@example.com").build();
      service.createMemberSubscription(member);

   }
}
