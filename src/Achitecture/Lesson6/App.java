package Achitecture.Lesson6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/clients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "Lbvf88801";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            ClientMapper clientMapper = new ClientMapper(con);

            //запись в таблицу
            clientMapper.insert(UUID.randomUUID(),"ООО МояНочьСветла", "Дима Пастушков", "+89322134444",30000.123213D)
                        .insert(UUID.randomUUID(), "ООО БеременнаяВ16","Сергей Беляков", "+88878674", 2_000_000.12321)
                        .insert(UUID.randomUUID(), "ИП Узумаучихова", "Дмитрий Авдошин", "+880001123213", 3_555_123)
                        .insert(UUID.randomUUID(), "ООО ШО-Поделать", "Дмитрий Авдошин", "+87878", 35555)
                        .insert(UUID.randomUUID(), "IECOmapny", "Дмитрий Авдошин", "+321321312", 3213213)
                        .insert(UUID.randomUUID(), "JOJO", "Сергей Беляков", "+891232312", 321321321);

            //Поиск контактов в таблице
            List<Client> clients = new ArrayList<>(clientMapper.findClientByContactName("Дмитрий Авдошин"));
            for (Client client:clients) {
                System.out.println(client.toString());
            }

            System.out.println("Количество строк в таблице до удаления" + clientMapper.getCountPotentialClient());
            clientMapper.deleteByName("JOJO")
                        .deleteByName("IECOmapny")
                        .deleteByName("ООО МояНочьСветла");
            System.out.println("Количество строк после удаления " + clientMapper.getCountPotentialClient());


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
