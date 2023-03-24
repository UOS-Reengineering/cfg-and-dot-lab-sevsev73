package dependenceAnalysis.intraprocedural;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reconnaissance {

    public static void main(String[] args) {

        try{
            ArrayList<String> loggedList= new ArrayList<>();
            ArrayList<String> logged2List= new ArrayList<>();
            ArrayList<String> logged3List= new ArrayList<>();
            FileInputStream logged = new FileInputStream("logged.log");
            FileInputStream logged2 = new FileInputStream("logged2.log");
            FileInputStream logged3 = new FileInputStream("logged3.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(logged));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(logged2));
            BufferedReader br3 = new BufferedReader(new InputStreamReader(logged3));
            String strLine;
            String strLine2;
            String strLine3;
            loggedList.clear();
            /* read log line by line */
            while ((strLine = br.readLine()) != null)   {
                if(strLine.startsWith("'")){
                String line = strLine.substring(strLine.indexOf("'")+ 1);
                line.trim();
                loggedList.add(line);}
                else {
                    String line = strLine.substring(strLine.indexOf("'")+ 2);
                    line.trim();
                    loggedList.add(line);
                    //System.out.println(loggedList);
                }
            }
            while ((strLine2 = br2.readLine()) != null)   {
                if(strLine2.startsWith("'")){
                    String line = strLine2.substring(strLine2.indexOf("'")+ 1);
                    line.trim();

                    logged2List.add(line);}
                else {
                    String line = strLine2.substring(strLine2.indexOf("'")+ 2);
                    line.trim();
                    logged2List.add(line);
                }
            }
            while ((strLine3 = br3.readLine()) != null)   {
                if(strLine3.startsWith("'")){
                    String line = strLine3.substring(strLine3.indexOf("'")+ 1);
                    line.trim();
                    logged3List.add(line);}
                else {
                    String line = strLine3.substring(strLine3.indexOf("'")+ 2);
                    line.trim();
                    logged3List.add(line);
                }
            }
            logged.close();
            logged2.close();
            logged3.close();
            //System.out.println(logged2List);

            //need to write code to compare the lists and extract the items mentioned in logged only and not logged2,3
            //Running out of time.

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
