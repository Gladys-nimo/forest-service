import org.sql2o.Connection;

import java.util.List;



public class notEndangered extends Animal{
    public notEndangered(String name) {
        this.name = name;
        type = "Not Endangered";
    }

    public static Animal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
        public static List<notEndangered> all () {
            String sql = "SELECT * FROM animals WHERE type = 'Not Endangered'";
            try (Connection con = DB.sql2o.open()) {
                return con.createQuery(sql)
                        .throwOnMappingFailure(false)
                        .executeAndFetch(notEndangered.class);
            }
        }
    }

