package io.hotkey.activemqexample.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import static io.hotkey.activemqexample.config.util.TypeIdMappingFactory.getTypeIdMapping;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JmsMessageConverter implements MessageConverter{

   MappingJackson2MessageConverter jacksonMessageConverter = new MappingJackson2MessageConverter();

   public JmsMessageConverter() {
      jacksonMessageConverter.setTypeIdPropertyName("_type");
      jacksonMessageConverter.setTypeIdMappings(getTypeIdMapping());
      jacksonMessageConverter.setTargetType(MessageType.TEXT);
   }

   @Override
   public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
      return jacksonMessageConverter.toMessage(object, session);
   }

   @Override
   public Object fromMessage(Message message) throws JMSException, MessageConversionException {
      return jacksonMessageConverter.fromMessage(message);
   }
}
