package com.xzit.module.desensitization_annotation_custom.pojo;

import com.xzit.module.desensitization_annotation_custom.annotation.Desensitization;
import com.xzit.module.desensitization_annotation_custom.type.DesensitizationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPojo {
    private String userName;

    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String phone;

    @Desensitization(type = DesensitizationTypeEnum.PASSWORD)
    private String password;

    @Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 0, endExclude = 2)
    private String address;
}
