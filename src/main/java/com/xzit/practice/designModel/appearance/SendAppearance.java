package com.xzit.practice.designModel.appearance;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:45
 */
public class SendAppearance {

    public void sendSms() {
        new AliSmsServiceImpl().sendSms();
        new EmailServiceImpl().sendSms();
        new WeChatServiceImpl().sendSms();
    }
}
