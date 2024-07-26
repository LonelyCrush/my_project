package com.xzit.module.desensitization;

import cn.hutool.core.util.DesensitizedUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 利用Hutool实现数据脱敏
 * @author: leizefeng
 * @date: 2024/7/26
 */
@SpringBootTest
public class HuToolDesensitizationTest {

        @Test
        public void testPhoneDesensitization() {
                String phone="13723231234";
                System.out.println(DesensitizedUtil.mobilePhone(phone)); //输出：137****1234
        }

        @Test
        public void testBankCardDesensitization(){
                String bankCard="6217000130008255666";
                System.out.println(DesensitizedUtil.bankCard(bankCard)); //输出：6217 **** **** *** 5666
        }

        @Test
        public void testIdCardNumDesensitization(){
                String idCardNum="411021199901102321";
                //只显示前4位和后2位
                System.out.println(DesensitizedUtil.idCardNum(idCardNum,4,2)); //输出：4110************21
        }
        @Test
        public void testPasswordDesensitization(){
                String password="www.jd.com_35711";
                System.out.println(DesensitizedUtil.password(password)); //输出：****************
        }
}
