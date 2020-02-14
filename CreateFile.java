package com.test.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

public class CreateFile {
	
    /**
     * This class shows how to create file in java
     * with x number of lines and each line consist 
     * of a string that is unique with 100 characters long
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
	   	 	System.out.print("Input valid int number: ");
	   	 	//Read the input value.
	   	 	int noOfLines = in.nextInt(); 
	   	 	//Calling function createFileWithRandomStrings() to create Random strings.
	        createFileWithRandomStrings(noOfLines);
	        System.out.println("DONE");
        }finally {
            in.close();
        }
    }


    /**
     * BufferedWriter used when number of write operations are more
     * and It uses internal buffer to reduce real IO operations and saves time
     * @param noOfLines
     */
    private static void createFileWithRandomStrings(int noOfLines) {
        File file = new File("test.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        Random random = new SecureRandom();
        String strAlphaNumericString  = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            String dataWithNewLine="";
            for(int i = noOfLines; i>0; i--){
            	StringBuilder returnValue = new StringBuilder(100);
    	        for (int cnt = 0; cnt < 100; cnt++) {
    	            returnValue.append(strAlphaNumericString.charAt(random.nextInt(strAlphaNumericString.length())));
    	        }
    	        dataWithNewLine=returnValue.toString()+System.getProperty("line.separator");
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
