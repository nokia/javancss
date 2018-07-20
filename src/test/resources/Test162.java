
 package mypackage;
 
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.SQLException;
 import java.sql.DriverManager;
 
 public class FooMain {
     
     public void noSemicolonAtTheEndOfTryWithResources() throws SQLException {
         
         Connection connection = DriverManager.getConnection("someUrl");
             
         try (PreparedStatement selectStatement = connection.prepareStatement("SELECT")) {
             
             selectStatement.setString(1, "some.parameter.value");
         }
     }
     
     public void semicolonAtTheEndOfTryWithResources() throws SQLException {
         
         Connection connection = DriverManager.getConnection("someUrl");
             
         try (PreparedStatement selectStatement = connection.prepareStatement("SELECT");) {
             
             selectStatement.setString(1, "some.parameter.value");
         }
     }

     public void noSemicolonAtTheEndOfSecondTryWithResources() throws SQLException {
         
         Connection connection = DriverManager.getConnection("someUrl");
             
         try (PreparedStatement selectStatement = connection.prepareStatement("SELECT");
                 PreparedStatement insertStatement = connection.prepareStatement("INSERT")) {
             
             selectStatement.setString(1, "some.parameter.value");
         }
     }

     public void semicolonAtTheEndOfSecondTryWithResources() throws SQLException {
         
         Connection connection = DriverManager.getConnection("someUrl");
             
         try (PreparedStatement selectStatement = connection.prepareStatement("SELECT");
                 PreparedStatement insertStatement = connection.prepareStatement("INSERT");) {
             
             selectStatement.setString(1, "some.parameter.value");
         }
     }
 }
 