package controllers;

import models.Task;
import play.data.Form;
import play.mvc.*;

import views.html.task.*;

public class Tasks extends Controller {
	
	final static Form<Task> taskForm = form(Task.class);
	
	public static Result index() {
		
        return ok(index.render(Task.find.all()));
    }
	

}
