package com.txp.logic_control.util;

/**
 * 命令存储
 */
public class AdbCommandUtil {

    /**
     * 开启ADB服务
     */
    private static String ADB_START_SERVER = "start-server";

    /**
     * 关闭ADB服务
     */
    private static String ADB_KILL_SERVER = "kill-server";

    /**
     * 连接设备
     */
    private static String ADB_CONNECT= "connect";

    /**
     * 秘钥方式连接设备
     */
    private static String ADB_PAIR = "pair";


    /**
     * 展示以连接的设备列表
     */
    private static String ADB_DEVICES = "devices";


    public static String getAdbStartServer(String adbPath) {
        return adbPath + " " + ADB_START_SERVER;
    }

    public static String getAdbKillServer(String adbPath) {
        return adbPath + " " + ADB_KILL_SERVER;
    }

    public static String getAdbConnect(String adbPath, String ip, String port) {
        return adbPath + " " + ADB_CONNECT + ip + ":" + port;
    }

    public static String getAdbPair(String adbPath) {
        return adbPath + " " + ADB_PAIR;
    }

    public static String getAdbDevices(String adbPath) {
        return adbPath + " " + ADB_DEVICES;
    }
}
