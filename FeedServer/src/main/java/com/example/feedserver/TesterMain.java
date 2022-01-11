package com.example.feedserver;

import com.example.feedserver.helpers.exceptions.UserType;
import com.example.feedserver.memorymanagers.MySqlMemoryManager;
import com.example.feedserver.memorymanagers.datastructure.sql.query.Query;
import com.example.feedserver.memorymanagers.datastructure.sql.QueryType;
import com.example.feedserver.memorymanagers.datatype.Property;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class TesterMain {
    public static void main(String[] args) {
//        oldMain();
//        testUserType();
        MySqlMemoryManager mySqlMemoryManager = new MySqlMemoryManager();
        System.out.println(mySqlMemoryManager.testReadQuery("select * from users.genders"));
    }

    private static void testUserType() {
//        UserType userType = UserType.USER;
//        UserType shouldFound = UserType.getUserType(600);
//        UserType shouldntFound1 = UserType.getUserType(0);
//        UserType shouldntFound2 = UserType.getUserType(11);
//        UserType shouldntFound3 = UserType.getUserType(12345);
        LinkedHashMap<Integer, String> codes = new LinkedHashMap<>() {{
            put(600, "raan");
            put(0, "UNSPECIFIED");
            put(10, "UNKNOWN");
            put(11, "I dont know - not a value");
            put(1234, "developer");
            put(20, "VIEWER");
        }};
        for (Integer key :
                codes.keySet()) {
            UserType userType = UserType.getUserType(key);
            System.out.println(
                    key + " = " + userType.getType() +
                            "\ngetUserType: " + userType +
                            "\n getGeneralUserType: " + UserType.getGeneralUserType(key) +
                            "\nshould be: " + codes.get(key) + "\n".repeat(2));
        }
    }

    private static void oldMain() {
        //        MySqlMemoryManager mySqlMemoryManager = new MySqlMemoryManager();
//        System.out.println(mySqlMemoryManager.testReadQuery("select * from users.genders"));
        int index = 1;
//        System.out.println("how many times do you want to insert?");
//        int times = Integer.parseInt(new Scanner(System.in).next());
        Date start = new Date();
        Date last = start;
        try {
            System.out.println("started at " + start);
            Connection connection = connect();
//            List<PreparedStatement> queryList = new ArrayList<>();
//            for (int i = 0; i < times; i++) {
//                int finalIndex = index;
//                queryList.add(new Query("users", "test_table", QueryType.INSERT_VALUE, new ArrayList<>() {{
//                    add(new Property(finalIndex, Types.INTEGER));
//                    add(new Property("hello", Types.VARCHAR));
//                    add(new Property(new Timestamp(new Date().getTime()), Types.TIMESTAMP));
//                    add(new Property(true, Types.BOOLEAN));
//                }}).build(connection));
//                index++;
//                if (index % 1000 == 0 && index >= 1000) {
//                    last = log("amount of successes: " + index, start, last);
//                }
//            }
//            for (PreparedStatement preparedStatement :
//                    queryList) {
//                preparedStatement.execute();
//                preparedStatement.close();
//            }
            while (true) {
                int finalIndex = index;
                new Query("users", "test_table", QueryType.INSERT_VALUE, new ArrayList<>() {{
                    add(new Property(finalIndex, Types.INTEGER));
                    add(new Property("hello", Types.VARCHAR));
                    add(new Property(new Timestamp(new Date().getTime()), Types.TIMESTAMP));
                    add(new Property(true, Types.BOOLEAN));
                }}).build(connection).execute();
                index++;
                if (index % 1000 == 0 && index >= 1000) {
                    last = log("amount of successes:    " + index, start, last);
                }
            }
//            for (Query query :
//                    queryList) {
//                query.build(connection).execute();
//            }
//            PreparedStatement p = query.build(connection);
//            if (p.execute()) {
//                System.out.println("success");
//            } else {
//                System.out.println("failure");
//            }
//            Date end = new Date();
//            System.out.println("ended at " + end);
//            Date difference = timeDifference(start, end);
//            System.out.println("it took " + (difference.getHours() - 2) + ":" + difference.getMinutes() + ":" + difference.getSeconds()/*toString().subSequence(19, 27)*/);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            System.out.println();
            log("crushed at the         " + index + "'th", start, last);
        }
    }

    private static Date log(String event, Date start, Date last) {
        System.out.println("\n".repeat(5) + "\u001B[35m" + "--------------------------------------------------------" + "\u001B[0m");
        Date end = new Date();
        System.out.println("started at:             " + start);
        System.out.println("current time:           " + end);
        Date difference = timeDifference(start, end);
        Date differenceFromLast = timeDifference(last, end);
        last = end;
        System.out.println("time since beginning:   " + (difference.getHours() - 2) + ":" + difference.getMinutes() + ":" + difference.getSeconds()/*toString().subSequence(19, 27)*/);
        System.out.println("time since last:        " + (differenceFromLast.getHours() - 2) + ":" + differenceFromLast.getMinutes() + ":" + differenceFromLast.getSeconds());
        System.out.println("\u001B[34m" + event + "\u001B[0m");
        System.out.println("\u001B[35m" + "--------------------------------------------------------" + "\u001B[0m");
        return last;
    }

    private static Date timeDifference(Date start, Date end) {
        return new Date(end.getTime() - start.getTime());
    }

    private static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306", "root", "");
    }
}
