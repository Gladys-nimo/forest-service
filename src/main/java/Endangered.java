import org.sql2o.Connection;

import java.util.List;

public class Endangered extends Animal {

    private String health;
    private String age;

    public Endangered(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        type = "endangered";

    }

    public static List<Endangered> allEndAnimals() {
        String sql = "SELECT * FROM animals where type='endangered'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Endangered.class);
        }
    }
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId() {
        return id;
    }
    public String getHealth() {
        return health;
    }
    public String getAge() {
        return age;
    }


    public static Endangered Endangeredfind(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Endangered endangered = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Endangered.class);
            return endangered;
        }
    }
}


