package com.wanderlust.wanderlust.external.hotel.booking.model.question;

import lombok.Data;

@Data
public class BookingHotelQuestion {

    private String hotel_id;
    private String question_id;
    private String question;
    private String answer;
    private int votes;
    private String asked_at;
    private String answered_at;
    private int answer_time_epoch;
    private int ask_time_epoch;
    private int naive_sentiment;
    private String language;
    private String answered_at_formatted;
    private String average_response_time;
    private String average_response_time_text;
    private int average_response_time_in_seconds;
    private String sign_off;
    private String translated_question;
    private String translated_answer;
    private boolean is_or_could_be_translated;
    private boolean opted_out_of_q_and_a;
    private boolean hidden;
    private String room_id;
    private String rank;

}
