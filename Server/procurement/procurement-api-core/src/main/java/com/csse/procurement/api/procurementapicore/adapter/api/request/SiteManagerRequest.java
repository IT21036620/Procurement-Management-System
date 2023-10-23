package com.csse.procurement.api.procurementapicore.adapter.api.request;

import com.csse.hexa.core.Request;
import lombok.Getter;

@Getter
public class SiteManagerRequest implements Request {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String contactNo;
    private String employeeCode;
    private String role;
    private Boolean authorizedStatus;
}
