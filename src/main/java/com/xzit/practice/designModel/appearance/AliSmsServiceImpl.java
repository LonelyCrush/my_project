package com.xzit.practice.designModel.appearance;

import com.xzit.practice.designModel.appearance.SendSmsService;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:43
 */
public class AliSmsServiceImpl implements SendSmsService {

    @Override
    public void sendSms() {
        System.out.println("阿里云发送短信");
    }
}
