/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.mavenproject1;

import static com.tt.UI.BoPhanService.addBoPhan;
import java.text.ParseException;
import com.tt.UI.Menu;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author anhtu
 */
public class Main {
    
    public static void main(String[] args) throws ParseException{
        Scanner scanner = new Scanner(System.in);
        addBoPhan();
        Menu.Menu(scanner);
    }
    

}
