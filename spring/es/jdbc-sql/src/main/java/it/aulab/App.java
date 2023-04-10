package it.aulab;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.aulab.model.Prodotto;


public class App {
    static final String connection_string = "jdbc:mysql://localhost:3306/aulab?user=root&password=rootroot";
    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProdottoDao dao = context.getBean(ProdottoDao.class);

        System.out.println("I prodotti sono: " + dao.count()); 

        // Prodotto p = dao.getOne(1L);

        // System.out.println("id: " + p.getId());
        // System.out.println("nome: " + p.getNome());
        // System.out.println("descrizione: " + p.getDescrizione());
        // System.out.println("prezzo: " + p.getPrezzo());
        // System.out.println();

        // Prodotto newProdotto = new Prodotto();
        
        // newProdotto.setNome("Nuovo");
        // newProdotto.setDescrizione("Descrizione");
        // newProdotto.setPrezzo(30F);

        // dao.insert(newProdotto);

        // dao.delete(5L);
        // dao.delete(6L);

        // p.setDescrizione("Questa è una nuova descrizione");

        // dao.update(p.getId(), p);

        // List<Prodotto> all = dao.getData();

        // for (Prodotto prodotto: all) {
        //     System.out.println("id: " + prodotto.getId());
        //     System.out.println("nome: " + prodotto.getNome());
        //     System.out.println("descrizione: " + prodotto.getDescrizione());
        //     System.out.println("prezzo: " + prodotto.getPrezzo());
        //     System.out.println();
        // }

        List<Prodotto> productGreaterThen100 = dao.getGreaterThanPrezzo(100F);

        for (Prodotto prodotto: productGreaterThen100) {
            System.out.println("id: " + prodotto.getId());
            System.out.println("nome: " + prodotto.getNome());
            System.out.println("descrizione: " + prodotto.getDescrizione());
            System.out.println("prezzo: " + prodotto.getPrezzo());
            System.out.println();
        }




        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
    
        //     //connessione
        //     Connection connection = DriverManager.getConnection(connection_string);
        //     Statement statement = connection.createStatement();
        //     String query = "FROM prodotti p join varianti v ON p.id = v.prodotto_id";
    
        //     ResultSet count = statement.executeQuery("SELECT count(*)" + query);
    
        //     // System.out.println("Le righe sono " + count.getInt(1));
        //     ResultSet resultSet = statement.executeQuery("SELECT p.nome, v.attributo, v.valore " + query);
    
        //     while (resultSet.next()) {
        //         // System.out.println("id " + resultSet.getLong("id"));
        //         // System.out.println("nome " + resultSet.getString("nome"));
        //         // System.out.println("descrizione " + resultSet.getString("descrizione"));
        //         // System.out.println("prezzo " + resultSet.getFloat("prezzo"));
        //         // System.out.println("nome: " + resultSet.getString("nome"));
        //         // System.out.println("attributo: " + resultSet.getString("attributo"));System.out.println("valore: " + resultSet.getString("valore"));
        //         System.out.println("nome: " + resultSet.getString(1));
        //         System.out.println("attributo: " + resultSet.getString(2));
        //         System.out.println("valore: " + resultSet.getString(3));
    
        //         System.out.println();
        //     }
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

    }
}