package io.hotkey.activemqexample.config.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * ClassFinder is an utility class to find classes and subclasses in this project.
 */
@Slf4j
public class SubclassFinderUtil {

   /**
    * Find all subtypes of a given parent class.
    * @param parentClass the parent class
    * @param basePackage the package to look in recursively.
    * @return all subtypes classes associated with the given parent class.
    */
   public static List<Class> findAllSubtypes(final Class parentClass, final String basePackage) {
      ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
      provider.addIncludeFilter(new AssignableTypeFilter(parentClass));
      return provider
              .findCandidateComponents(basePackage) // e.g. org/my/project
              .stream()
              .map(BeanDefinition::getBeanClassName)
              .map(SubclassFinderUtil::mapNameToClass)
              .collect(toList());
   }

   /**
    * Returns the {@code Class} object associated with the class or
    * interface with the given string name. If the class is not
    * found, then the exception is hidden.
    * @param className name to map.
    * @return the associate class.
    */
   private static Class mapNameToClass(String className) {
      try {
         return Class.forName(className);
      } catch (ClassNotFoundException e) {
         log.error("No class object was found for the class name {}.", className);
         return null;
      }

   }

}
