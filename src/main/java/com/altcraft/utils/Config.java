package com.altcraft.utils;

public class Config {
    private String host;
    private int port;

    public Config(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Config() {
        this.host = "127.0.0.1";
        this.port = 8888;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Config{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
