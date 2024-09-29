package com.haibazo.shop.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // ko hiển thị
public class ApiResponse<T> {

    @Builder.Default
    private int code = 1000;

    private String message;
    private T result;
}
