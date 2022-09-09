package Application.User.Driver;

import Application.User.User;

import java.io.IOException;

public interface Idriver extends User {
     void Update(User object) throws IOException;
}
