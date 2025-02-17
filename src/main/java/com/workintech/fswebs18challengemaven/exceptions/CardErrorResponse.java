package com.workintech.fswebs18challengemaven.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardErrorResponse {

private Integer status;
private String message;
private Long timestamp;

    public CardErrorResponse(String message) {
        this.message = message;
    }
}
