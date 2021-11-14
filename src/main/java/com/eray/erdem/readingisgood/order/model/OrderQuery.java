package com.eray.erdem.readingisgood.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderQuery {
    @JsonFormat(pattern = "YYYY-DD-MM")
    @NotNull
    private Date startDate;
    @JsonFormat(pattern = "YYYY-DD-MM")
    @NotNull
    private Date endDate;

}
