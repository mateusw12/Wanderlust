package com.wanderlust.wanderlust.model.bookingHotel;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "reservaHotel")
public class BookingHotelModel implements Serializable {

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
    @Column(name="codHotel", nullable = false, length = 200)
    public String hotelId;

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

    @NotNull
    @NotBlank
    @Length(max = 200)
    @Column(name="agencia")
    public String agency;

}
