
package com.set.ultimax.login;
 
public class Users {
     
    //private variables
    int _id; // Just to have it.
    String _userName;
    String _passWord;
     
    // Empty constructor
    public Users(){

    }
    // constructor
    public Users(String userName, String _passWord){
        this._userName = userName;
        this._passWord = _passWord;
    }
    // getting User
    public String getUser(){
        return this._userName;
    }

    // getting Password
    public String getPassword(){
        return this._passWord;
    }
}