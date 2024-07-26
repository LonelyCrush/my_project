package com.xzit.module.desensitization_fastjson.serialize;

import cn.hutool.core.util.DesensitizedUtil;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class PhoneSerialize implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        if (type == String.class && o!= null) {
            jsonSerializer.write(DesensitizedUtil.mobilePhone(String.valueOf(o)));
        }
    }
}
