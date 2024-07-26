package com.xzit.module.desensitization_fastjson.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.xzit.module.desensitization_fastjson.serialize.AddressSerialize;
import com.xzit.module.desensitization_fastjson.serialize.PasswordSerialize;
import com.xzit.module.desensitization_fastjson.serialize.PhoneSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPojo2 {
    private String userName;

    @JSONField(serializeUsing = PhoneSerialize.class)
    private String phone;

    @JSONField(serializeUsing = PasswordSerialize.class)
    private String password;

    @JSONField(serializeUsing = AddressSerialize.class)
    private String address;
}
