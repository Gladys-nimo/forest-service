import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings-form", (request, response) -> {
            Map<String, Object> model = new HashMap< String, Object>();
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings-display", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Sightings> sightings = Sightings.getAllSightings();
            model.put("sightings", sightings);
            return new ModelAndView(model, "display-sightings.hbs");

        }, new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String ranger = request.queryParams("rangers");
            String location = request.params("location");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            Sightings sightings = new Sightings(ranger,location,animalId);
            sightings.save();
            response.redirect("/sightings-display");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Endangered> endangered = Endangered.allEndAnimals();
            List<notEndangered> notendangered = notEndangered.all();
            model.put("Endangered", endangered);
            model.put("n", notendangered);
            return new ModelAndView(model, "display-animal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String type = request.queryParams("type");

            if(type.equals("notEndangered")) {
                notEndangered notendangered = new notEndangered(name);
                notendangered.save();
            }
            else {
                String health = request.queryParams("age");
//                Endangered endangered = new Endangered(name,age, health);
//                Endangered.save();
            }

            response.redirect("/Animals");
            return null;
        }, new HandlebarsTemplateEngine());
        get("/Animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
