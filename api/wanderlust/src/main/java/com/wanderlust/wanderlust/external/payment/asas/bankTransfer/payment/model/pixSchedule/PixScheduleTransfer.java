package com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.pixSchedule;

import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.ted.TedBankAccount;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
public class PixScheduleTransfer {

    @Positive
    @NotNull
    private Double value;

    @NotNull
    private TedBankAccount bankAccount;

    @NotNull
    @NotBlank
    private String operationType;

    @NotNull
    private Date scheduleDate;

}
