package com.qingketang.graphql;

import lombok.Data;

@Data
public class BooleanResult {
    private Boolean ok;

    public BooleanResult(Boolean ok) {
        this.ok = ok;
    }
}
