package com.wanderlust.wanderlust.model.bookingRentalCar;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "reservaAluguelCarro")
public class BookingRentalCarModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="codReserva", nullable = false, unique = true, length = 200)
    public String bookingId;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="codCarro", nullable = false, length = 200)
    public String rentalCarId;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="cidade", nullable = false, length = 200)
    public String city;

    @NotNull
    @Column(name="preco", nullable = false)
    public Double price;

    @NotNull
    @Column(name="dataInicio", nullable = false)
    public Date startDate;

    @NotNull
    @Column(name="dataFim", nullable = false)
    public Date endDate;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="agencia", nullable = false)
    public String agency;

    @NotNull
    @Column(name="condicaoPagamento", nullable = false)
    public String paymentCondition;

    @NotNull
    @Column(name="pagamento")
    public Boolean isPayment;

    @NotNull
    @NotBlank
    @Column(name="usuario")
    public String user;

    @NotNull
    @Column(name="dataReserva")
    public Date bookingDate;

}
