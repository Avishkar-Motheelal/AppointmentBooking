package com.example.bookingapi.model;

import lombok.Data;

@Data
public class BookingDTO {
    private String customerName;
    private String customerPhone;


    public BookingModel toModel() {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setCustomerName(this.customerName);
        bookingModel.setCustomerPhone(this.customerPhone);
        return bookingModel;
    }
}
