package com.xzit.demo.ip;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author leizefeng
 */
public class IpUtil {

    public static void main(String[] args) {

    }

    public static String getRequestIp(HttpServletRequest request) {
        String ipAddress = null;

        try {
            ipAddress = request.getHeader("X-Original-Forwarded-For");
            if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("X-Forwarded-For");
            }

            if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }

            if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }

            if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if ("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                }
            }

            if (ipAddress != null && ipAddress.contains(",")) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        } catch (UnknownHostException var3) {
            var3.printStackTrace();
        }

        return ipAddress;
    }
}
