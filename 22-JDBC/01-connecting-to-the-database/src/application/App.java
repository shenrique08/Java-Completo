package application;

import db.DB;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        Connection connection = DB.getConnection();
        DB.closeConnection();

    }
}
