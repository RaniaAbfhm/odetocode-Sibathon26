import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class medicine {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sibathon",
            "root",
            "lote373"
        );
    }

    public boolean addMedicine(String name, String time) {
        try (Connection conn = getConnection()) {
            String query = "INSERT INTO medicines(name, time) VALUES(?, ?)";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, name);
            pre.setString(2, time);

            int rows = pre.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMedicine(String oldName, String newName, String newTime) {
        try (Connection conn = getConnection()) {
            String query = "UPDATE medicines SET name = ?, time = ? WHERE name = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, newName);
            pst.setString(2, newTime);
            pst.setString(3, oldName);

            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMedicine(String name) {
        try (Connection conn = getConnection()) {
            String query = "DELETE FROM medicines WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> listMedicines() {
        List<String> meds = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String query = "SELECT name, time FROM medicines";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                meds.add(rs.getString("name") + " - " + rs.getString("time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meds;
    }
}
