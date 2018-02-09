package io.hotkey.activemqexample.domain.event;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MembershipSubscriptionEvent implements DomainEvent{

   String eventId;
   String email;
}
