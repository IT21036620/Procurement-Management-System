package com.csse.procurement.api.procurementapicore.adapter.api.request;

import com.csse.hexa.core.Request;
import lombok.Getter;

@Getter
public class ItemRequest implements Request {
    private String name;
    private String description;
    private String image;
    private String category;
    private Double price;
    private Long supplier;
}
