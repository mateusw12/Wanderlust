package com.wanderlust.wanderlust.service.sendSms;

import com.wanderlust.wanderlust.model.sendSms.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmsService {

    @Autowired
    private AmazonSNS snsClient;

    public String sendSMS(SMS sms) {
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
        smsAttributes.put("AWS.SNS.SMS.SenderID",
                new MessageAttributeValue()
                        .withStringValue("Sender ID")
                        .withDataType("String"));
        smsAttributes.put("AWS.SNS.SMS.SMSType",
                new MessageAttributeValue()
                        .withStringValue("Transactional")
                        .withDataType("String"));

        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(sms.getMessage())
                .withSubject(sms.getSubject())
                .withPhoneNumber(sms.getPhoneNumber())
                .withMessageAttributes(smsAttributes));
        return result.getMessageId();
    }

}
