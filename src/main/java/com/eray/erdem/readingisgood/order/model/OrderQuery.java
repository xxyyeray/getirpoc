package com.eray.erdem.readingisgood.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderQuery {
    @JsonFormat(pattern = "YYYY-DD-MM")
    private Date startDate;
    @JsonFormat(pattern = "YYYY-DD-MM")
    private Date endDate;

}
