package Model;

import Controller.Connector;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connector n = new Connector();
        n.createConnection();
    }
}
