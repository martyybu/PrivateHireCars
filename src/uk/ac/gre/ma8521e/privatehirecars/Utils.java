/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars;

/**
 *
 * @author ma8521e
 */
public class Utils {

    public static boolean fromStringtoBoolean(String b)  {
        return b.equals("Y");
    }
    
    public static String frommBooleanToString(Boolean b){
        if(b==true){
            return "Y";
        }else{
            return "N";
        }
    }
}
