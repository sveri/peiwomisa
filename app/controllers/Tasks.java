package controllers;

import java.util.List;

import models.Task;
import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.task.*;

public class Tasks extends Controller {

	final static Form<Task> taskForm = form(Task.class);

	public static Result index() {
		return ok(index.render());
	}
	
	@BodyParser.Of(play.mvc.BodyParser.Json.class)
	public static Result indexR() {
		List<Task> tasks = Task.find.all();
		return ok(Json.toJson(tasks));
	}
	


}
