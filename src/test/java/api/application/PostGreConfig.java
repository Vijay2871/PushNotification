package api.application;

import java.sql.*;

public class PostGreConfig {


    public PostGreConfig() throws SQLException {
    }

    public static String PostGreConfigdetails(String Email) throws SQLException {

        String dbUrl = "jdbc:postgresql://loyal-mobile-verification-test.cluster-cmjvpr3p3f4z.ap-southeast-2.rds.amazonaws.com:5432/mobile";

        String username = "give_it_app";

        String password = "TLocuz@13579";

        String query = "select * from loyalty_app_registration where email_address='" + Email + "'";

        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String myEmail = rs.getString(1);
            System.out.printf(myEmail);
            return myEmail;
        }

        return dbUrl;
    }
    public static String PostGreConfigdetailsDuplicateEmail(String Duplicate_email) throws SQLException {

        String dbUrl = "jdbc:postgresql://loyal-mobile-verification-test.cluster-cmjvpr3p3f4z.ap-southeast-2.rds.amazonaws.com:5432/mobile";

        String username = "give_it_app";

        String password = "TLocuz@13579";

        String query = "select datetime_added from loyalty_app_registration where email_address='" + Duplicate_email + "'";

        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String myEmail = rs.getString(1);
            System.out.printf(myEmail);
            return myEmail;
        }
        return dbUrl;
    }
    public static String PostGreConfigdetailsStatus(String Status) throws SQLException {

        String dbUrl = "jdbc:postgresql://loyal-mobile-verification-test.cluster-cmjvpr3p3f4z.ap-southeast-2.rds.amazonaws.com:5432/mobile";

        String username = "give_it_app";

        String password = "TLocuz@13579";

        String query = "select * from loyalty_app_registration where status= '"  + Status + "'";

        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String myStatus = rs.getString(4);
            System.out.println(myStatus);
            return myStatus;
        }
        return dbUrl;
    }
    public static String PostGreConfigdetailsGetCrmId(String crmid) throws SQLException {

        String dbUrl = "jdbc:postgresql://loyal-mobile-verification-test.cluster-cmjvpr3p3f4z.ap-southeast-2.rds.amazonaws.com:5432/mobile";

        String username = "give_it_app";

        String password = "TLocuz@13579";

        String query = "select crm_id from loyalty_app_registration where crm_id='"+crmid+"'";

        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String crmid1 = rs.getString(1);
            //System.out.printf(crmid1);
            return crmid1;
        }
        return crmid;
    }
}
