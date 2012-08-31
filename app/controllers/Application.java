package controllers;

import java.util.List;

import models.Task;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render());
    }
    
    
    @BodyParser.Of(play.mvc.BodyParser.Json.class)
    public static Result sayHello() {
    	  JsonNode json = request().body().asJson();
    	  ObjectNode result = Json.newObject();
    	  List<Task> tasks = Task.find.all();
    	  System.out.println(tasks.size());
    	  
    	  Json.toJson(tasks);
    	  
//    	  String name = json.findPath("name").getTextValue();
//    	  if(name == null) {
//    	    result.put("status", "KO");
//    	    result.put("message", "Missing parameter [name]");
//    	    return badRequest(result);
//    	  } else {
    	    result.put("name", "Test");
//    	    return ok(result);
    	    return ok(Json.toJson(tasks));
//    	  }
    	}

    
    
  
}