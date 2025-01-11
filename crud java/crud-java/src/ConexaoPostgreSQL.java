import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {

    // Dados para conexão com o banco
    private static final String URL = "jdbc:postgresql://localhost:5432/CRUD Java - POO"; 
    private static final String USUARIO = "postgres"; 
    private static final String SENHA = "admin"; 

    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        return conexao;
    }

    public static void main(String[] args) {
        // Testa a conexão ao banco
        conectar();
    }
}
