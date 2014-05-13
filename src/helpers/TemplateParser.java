/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 *
 * @author Maxim
 */
public class TemplateParser 
{
    private static final String l_delim = "\\{\\{";
    private static final String r_delim = "\\}\\}";
    private static final String templatePath = "src/resources/templates";
    
    public static String parse(String templateName, Map<String, String> vars) 
    {
        //TODO: relative path gebruiken
        String content = readFile(templatePath + "/" + templateName);
       
        for(String var : vars.keySet()) {
            content = content.replaceAll(l_delim + "\\s*(" + var + ")\\s*" + r_delim, vars.get(var));
        }
        
        return content;                
    }
    
    public static String readFile(String strPath) 
    {        
        try {
            return new String(Files.readAllBytes(Paths.get(strPath)), StandardCharsets.UTF_8);
        }catch(Exception e) {
            e.printStackTrace();
        }  
        return "";
    }
}
