package utilities;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.messages.types.DataTable;

import java.net.ConnectException;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        DBUtility.createConnection();
        String query = "select * from tbl_mortagage";
        List<List<Object>> queryResultAsListOfLists = DBUtility.getQueryResultAsListOfLists(query);

        //list of lists(shows the inner list)
        for (List<Object> objects : queryResultAsListOfLists) {
            System.out.println(objects);
        }
        //list of lists(shows the inner list, accessed a prticular elemnt)
        System.out.println(queryResultAsListOfLists.get(1).get(2));
        String o = (String) (queryResultAsListOfLists.get(1).get(2));

        //list of maps(shows the key)
        List<Map<String, Object>> queryM = DBUtility.getQueryResultListOfMaps(query);
        for (Map<String, Object> objects : queryM) {
            System.out.println(objects);
        }

        //list of maps(shows the key, accessed a prticular elemnt)
        System.out.println(queryM.get(1).get("b_lastName"));

        //gets column names, not values
        System.out.println(DBUtility.getColumnNames(query));

        DBUtility.updateQuery("UPDATE tbl_mortagage SET realtor_info = 'test' WHERE b_lastName='Muhammad';");
        query = "select * from tbl_mortagage where realtor_info = 'test';";
        queryResultAsListOfLists = DBUtility.getQueryResultAsListOfLists(query);

        for (List<Object> eachRow : queryResultAsListOfLists) {
            System.out.println(eachRow);
        }




    }
}