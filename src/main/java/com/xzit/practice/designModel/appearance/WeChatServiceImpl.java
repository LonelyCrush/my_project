package com.xzit.practice.designModel.appearance;

import com.xzit.practice.designModel.appearance.SendSmsService;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:44
 */
public class WeChatServiceImpl implements SendSmsService {

    @Override
    public void sendSms() {
        System.out.println("发送微信");
    }
}
