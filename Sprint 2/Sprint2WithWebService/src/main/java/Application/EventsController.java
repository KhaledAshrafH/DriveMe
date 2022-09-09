package Application;

import Application.Control.DataBase.Events;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {
    Events event = new Events();
}