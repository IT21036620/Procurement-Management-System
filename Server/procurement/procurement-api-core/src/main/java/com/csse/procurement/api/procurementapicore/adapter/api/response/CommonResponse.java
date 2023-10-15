package com.csse.procurement.api.procurementapicore.adapter.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse {
    private Object result;

    public CommonResponse(Object result) {
        this.result = result;
    }
}
