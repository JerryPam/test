
package HomeWork7;


public class Person {
    private String nick;
    private String password;
    
    public String getNick(){
        return nick;
    }

    public String getPassword(){
        return password;
    }

    public void setNick(String nick){
        this.nick = nick;
    }
    
    public boolean setPassword(String password){
        if (password.length() > 4 & password.length() < 11){
            this.password = password;
            return true;
        } else return false; 
    }
    

}

