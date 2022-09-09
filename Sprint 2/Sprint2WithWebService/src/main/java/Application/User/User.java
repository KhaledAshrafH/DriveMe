package Application.User;

public interface User {

     void setE_mail(String e_mail) ;
     void setMobile(String mobile);
     void setPassword(String password);
     void setUsername(String username);
     void setSTATE(userState STATE);

     String getPassword();
     String getUsername();
     String getMobile();
     String getE_mail();
     userState getSTATE();

     User Login(String username,String password);
     void Register(User obj);
}