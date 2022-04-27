import database.Database;
import models.DailyDevotion;
import utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Database database = new Database();

        while (true) {
            try {
                database.createTable(database.getConnection());
                Utils.mainMenu();
                int choices = Integer.parseInt(br.readLine());
                switch (choices) {
                    case 1: {
                        System.out.print("Enter title : ");
                        String title = br.readLine();
                        System.out.print("Enter content : ");
                        String content = br.readLine();
                        DailyDevotion dailyDevotion = new DailyDevotion(title, content);
                        database.insertData(dailyDevotion);
                        break;
                    }
                    case 2: {
                        ResultSet rs = database.getData(database.getConnection());
                        while (rs.next()) {
                            System.out.println("Id: " + rs.getInt("id"));
                            System.out.println("Title: " + rs.getString("title"));
                            System.out.println("Content: " + rs.getString("content"));
                        }
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        System.exit(0);
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
