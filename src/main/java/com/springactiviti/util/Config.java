package com.springactiviti.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class Config {
    private static String configName = null;
    private static Properties configProperties = null;

    static {
        search();
    }

    private Config() {
    }

    public static String get(String name) {
        return name == null ? null : configProperties.getProperty(name);
    }

    public static void set(String name, String value) {
        if (name != null && value != null) {
            configProperties.setProperty(name, value);
        }
    }

    public static String getConfigName() {
        return configName;
    }

    public static Properties getConfigProperties() {
        return configProperties;
    }

    public static void reset() {
        configName = null;
        search();
    }

    public static void switchFilename(String filename) {
        System.setProperty("wfc.service.config.filename", filename);
        reset();
    }

    private static synchronized void search() {
        if (configName == null) {
            String filename = System.getProperty("wfc.service.config.filename");
            if (filename != null) {
                configName = filename;
                configProperties = loadConfig(new File(filename));
            } else {
                InputStream is = Config.class.getResourceAsStream("/application.properties");
                if (is != null) {
                    configName = Config.class.getResource("/application.properties").toString();
                    configProperties = loadConfig(is);
                } else {
                    filename = System.getProperty("user.dir");
                    filename = filename + File.separator + "application.properties";
                    File file = new File(filename);
                    if (file.exists()) {
                        configName = filename;
                        configProperties = loadConfig(file);
                    } else {
                        filename = File.separator + "application.properties";
                        file = new File(filename);
                        if (file.exists()) {
                            configName = filename;
                            configProperties = loadConfig(file);
                        } else {
                            print("没有找到用户配置");
                        }
                    }
                }
            }
        }
    }

    private static Properties loadConfig(InputStream is) {
        Properties p = new Properties();

        try {
            p.load(is);
            is.close();
        } catch (IOException var8) {
            var8.printStackTrace();
            print(var8.toString());
            return null;
        }

        Properties p2 = new Properties();

        String key;
        String value;
        for (Enumeration e = p.propertyNames(); e.hasMoreElements(); p2.setProperty(key, value)) {
            key = (String) e.nextElement();
            value = p.getProperty(key);

            try {
                key = new String(key.getBytes("ISO-8859-1"), "GBK");
                value = new String(value.getBytes("ISO-8859-1"), "GBK");
            } catch (UnsupportedEncodingException var7) {
                var7.printStackTrace();
                print(var7.toString());
                return null;
            }
        }

        print("配置已加载：" + configName);
        return p2;
    }

    private static Properties loadConfig(File file) {
        try {
            return loadConfig((InputStream) (new FileInputStream(file)));
        } catch (IOException var2) {
            var2.printStackTrace();
            print(var2.toString());
            return null;
        }
    }

    private static void print(String str) {
        System.out.println("########## " + str + " ##########");
    }

    public static void main(String[] args) {
        startWriterTestThread("线程 #1", 1, 300);
        startWriterTestThread("线程 #2", 2, 300);
        startWriterTestThread("线程 #3", 1, 300);
        startWriterTestThread("线程 #4", 2, 300);
        startWriterTestThread("线程 #5", 1, 300);
    }

    private static void startWriterTestThread(final String name, final int method, final int count) {
        (new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < count; ++i) {
                    if (method == 1) {
                        Config.reset();
                        System.out.println(name + " reset " + i);
                    } else {
                        String value = Config.get("wfc.service.connection.mode");
                        System.out.println(name + " - " + value);
                    }
                }

                try {
                    Thread.sleep(2L);
                } catch (InterruptedException var3) {
                }

            }
        })).start();
    }
}
