import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    static final String connection_string = "jdbc:mysql://localhost:3306/aulab?user=root&password=rootroot";
    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            //connessione
            Connection connection = DriverManager.getConnection(connection_string);
            Statement statement = connection.createStatement();
            String query = "FROM prodotti p join varianti v ON p.id = v.prodotto_id";
    
            ResultSet count = statement.executeQuery("SELECT count(*)" + query);
    
            // System.out.println("Le righe sono " + count.getInt(1));
            ResultSet resultSet = statement.executeQuery("SELECT p.nome, v.attributo, v.valore " + query);
    
            while (resultSet.next()) {
                // System.out.println("id " + resultSet.getLong("id"));
                // System.out.println("nome " + resultSet.getString("nome"));
                // System.out.println("descrizione " + resultSet.getString("descrizione"));
                // System.out.println("prezzo " + resultSet.getFloat("prezzo"));
                // System.out.println("nome: " + resultSet.getString("nome"));
                // System.out.println("attributo: " + resultSet.getString("attributo"));System.out.println("valore: " + resultSet.getString("valore"));
                System.out.println("nome: " + resultSet.getString(1));
                System.out.println("attributo: " + resultSet.getString(2));
                System.out.println("valore: " + resultSet.getString(3));
    
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
