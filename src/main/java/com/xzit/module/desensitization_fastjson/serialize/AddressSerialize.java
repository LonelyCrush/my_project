package com.xzit.module.desensitization_fastjson.serialize;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class AddressSerialize implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        if (type == String.class && o!= null) {
            jsonSerializer.write(StrUtil.hide(String.valueOf(o), 4, 0));
        }
    }
}
