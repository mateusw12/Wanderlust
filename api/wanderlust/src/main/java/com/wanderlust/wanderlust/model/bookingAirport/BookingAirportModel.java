package com.wanderlust.wanderlust.model.bookingAirport;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "reservaPassagem")
public class BookingAirportModel implements Serializable {

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
    @Column(name="codAeroporto", nullable = false, length = 200)
    public String airportId;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="cidadeOrigem", nullable = false, length = 200)
    public String originCity;

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="cidadeDestino", nullable = false, length = 200)
    public String destinationCity;

    @NotNull
    @Column(name="preco", nullable = false)
    public Double price;

    @NotNull
    @Column(name="dataIda", nullable = false)
    public Date originDate;

    @NotNull
    @Column(name="dataVolta", nullable = false)
    public Date destinationDate;

    @NotNull
    @Column(name="numAdulto", nullable = false)
    public Double adultsNumber;

    @NotNull
    @Column(name="numCrianca", nullable = false)
    public Double childrenNumber;

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
