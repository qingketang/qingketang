package com.qing.core.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponse<T> {
    private Boolean ok = true;

    private T result;

    public CommonResponse(T resultBody) {
        this.result = resultBody;
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse<T>();
    }
}
