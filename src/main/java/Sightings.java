import org.sql2o.Connection;

import java.util.List;
import java.util.Map;

public class Sightings {
    private int animalId;
    private String location;
    private String ranger;
    private int id;

    public Sightings (String ranger, String location, int animalId ) {
        this.ranger = ranger;
        this.location = location;
        this.animalId = animalId;


    }

//    public static Map<Object, Object> getallsightings() {
//    }

//    public static Map<Object, Object> getallsightings() {
//    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return ranger;
    }

    public int getId() {
        return id;
    }

    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sightings= con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }
    public static List<Sightings> getAllSightings() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO sightings (ranger, location, animalId) VALUES (:ranger, :location, :animalId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("ranger",this.ranger)
                    .addParameter("location", this.location)
                    .addParameter("animalId", this.animalId)
                    .executeUpdate()
                    .getKey();
        }
    }
    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sightings)) {
            return false;
        } else {
            Sightings newSighting = (Sightings) otherSighting;
            return this.getId() == newSighting.id;
        }
    }
}