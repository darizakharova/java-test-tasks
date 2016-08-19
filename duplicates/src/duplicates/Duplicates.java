package duplicates;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Duplicates {
    public static void main(String[] args) {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        if (processFile(file1,file2)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Error occured!");
        }
    }
   static boolean processFile(File infile, File outfile)  {
        try (BufferedReader input = new BufferedReader(new FileReader(infile))){
            try ( BufferedWriter output = new BufferedWriter(new FileWriter(outfile,true))) {
                Map<String,Integer> data  = new TreeMap<>();
                String line;
                while( (line = input.readLine() ) != null ) {
                    if (data.containsKey(line)) {
                        data.put(line, data.get(line) + 1);
                    }
                    else {
                        data.put(line, 1);
                    }
                }
                for (Map.Entry<String, Integer> x: data.entrySet() ){
                   output.write(x.getKey() + " [" + x.getValue() + "]\n" );
                }
                return true;
            }
            catch (Exception e) {}
        }    
        catch (Exception e) {}
        return false;
    }
}
   
