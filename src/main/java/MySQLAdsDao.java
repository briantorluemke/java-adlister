import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private Connection connection;



    public MySQLAdsDao(Config config) {
        String url = config.getUrl();
        String name = config.getUsername();
        String pass = config.getPassword();
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    url,
                    name,
                    pass
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    private Ad pullAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAds(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(pullAd(rs));
        }
        return ads;
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() +"', "
                + "'" + ad.getDescription() + "')";
    }

    private String createDeleteQuery(String id) {
        return "DELETE FROM ads WHERE id = " + id +";";
    }

    @Override
    public List<Ad> all() throws SQLException {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAds(rs);

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create a new ad at this time.", e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            connection.createStatement().executeUpdate(createDeleteQuery(id));
        } catch (SQLException e) {
            throw new RuntimeException("Unable to delete ad. Good luck figuring out why.", e);
        }
    }
}
