package com.wanderlust.wanderlust.mapper.sendSms;

import com.wanderlust.wanderlust.dto.sendSms.SmsDTO;
import com.wanderlust.wanderlust.model.sendSms.SmsModel;
import org.springframework.stereotype.Component;

@Component
public class SmsMapper {

    public SmsDTO toDTO(SmsModel smsModel) {
        if (smsModel == null) {
            return null;
        }
        return new SmsDTO(
                smsModel.getPhoneNumber(),
                smsModel.getMessage(),
                smsModel.getSubject());
    }

    public SmsModel toEntity(SmsDTO smsDTO) {

        if (smsDTO == null) {
            return null;
        }

        SmsModel smsModel = new SmsModel();
        smsModel.setPhoneNumber(smsDTO.phoneNumber());
        smsModel.setMessage(smsDTO.message());
        smsModel.setSubject(smsDTO.subject());
        return smsModel;
    }

}
