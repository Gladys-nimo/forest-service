import org.sql2o.Connection;

import java.util.List;

public abstract class Animal {

    public String name;
    public String type;
    public int id;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getType().equals(newAnimal.getType());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
    public int getId() {
        return id;
    }
}

//    public abstract Animal save();
//}



