package com.crud.tasks.info;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class CompanyInformation {
    @Value("${info.company.name}")
    private String companyName;

    @Value("${info.company.email}")
    private String companyMail;

    @Value("${info.company.phone}")
    private String companyPhone;

    public final List<String> getCompanyInfo() {
        List<String> companyInfo = new ArrayList<>();
        companyInfo.add(companyName);
        companyInfo.add(companyMail);
        companyInfo.add("phone: "+companyPhone);
        return companyInfo;
    }
}
