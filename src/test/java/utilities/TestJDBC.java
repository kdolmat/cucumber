package utilities;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.messages.types.DataTable;

import java.net.ConnectException;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        // jdbc:{driverType}:{urlToBandSchema}
//        String url = "jdbc:mysql://db-duotech.cc652zs7kmja.us-east-2.rds.amazonaws.com/duotify";
//       Connection connection= DriverManager.getConnection(url,"duotech","duotech2021");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from users limit 10");
//        resultSet.next();
//        System.out.println(resultSet.getString(3));//indexes are 1 based count
//        System.out.println(resultSet.getString("username"));
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("username"));
//        }
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        System.out.println(metaData.getColumnCount());
//        System.out.println(metaData.getColumnName(2));
//
//        int count = metaData.getColumnCount();
//        resultSet.last();
//        resultSet.first();
//        int rowNo = resultSet.getRow();
//        System.out.println(rowNo);
//        for (int i = 0; i < rowNo; i++) {
//            for (int j = 0; j < count; j++) {
//                System.out.println(resultSet.getString(j)+"\t");
//            }
//            System.out.println();
//            resultSet.next();
//        }
        DBUtility.createConnection();
        String query = "select * from users limit 10";
        List<List<Object>> queryR = DBUtility.getQueryResultAsListOfLists(query);
        for (List<Object> objects : queryR) {
            System.out.println(objects);
        }
        System.out.println(queryR.get(1).get(2));
        String o = (String) (queryR.get(1).get(2));


        List<Map<String,Object>> queryM = DBUtility.getQueryResultListOfMaps(query);
        for (Map<String,Object> objects : queryM) {
            System.out.println(objects);
        }
        System.out.println(queryM.get(1).get("firstname"));
        System.out.println(DBUtility.getColumnNames(query));
    }
}
