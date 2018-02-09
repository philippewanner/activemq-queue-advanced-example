package io.hotkey.activemqexample.config.util;

import io.hotkey.activemqexample.domain.event.DomainEvent;

import java.util.Map;
import java.util.stream.Collectors;

public class TypeIdMappingFactory {

   /**
    * Returns all domain event class objects associated with
    * the class name
    */
   public static Map<String, Class<?>> getTypeIdMapping() {
      return SubclassFinderUtil
              .findAllSubtypes(DomainEvent.class, "io/hotkey/activemqexample") // All domain events under the root package!
              .stream()
              .collect(Collectors.toMap(Class::getSimpleName, clazz -> clazz)); // simple name to class
   }
}