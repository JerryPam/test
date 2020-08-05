/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork7;

/**
 *
 * @author user
 */
public class Animal {
    private String nick;
    private int age;
    
    public String getNick(){
        return nick;
    }
    public int  getAge() {return age; }
    public void setNick(String nick){
        this.nick = nick;
    }
    
    public void setAge(int age){ // возраст может быть от 1 до 15
        if (age > 0 & age < 16){
            this.age = age;
        } else return; // может и не нужна эта срочка
    }
    

}

