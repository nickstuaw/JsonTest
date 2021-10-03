package xyz.nsgw.JsonT;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonT {
    public static void main(String[] args) {
        Sausage sausage = new Sausage();
        Gson gson = new Gson();
        try {
            String json = gson.toJson(new Sausage());
            FileWriter writer = new FileWriter("obj.json");
            writer.write(json);
            writer.close();
            log("The sausage has been stored. It IS"+(sausage.isCooked()?" ":" NOT ")+"cooked "+(sausage.isBurnt()?"but IS ":"and IS NOT ")+"burnt.");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("obj.json"));
            Sausage res = gson.fromJson(reader, Sausage.class);
            reader.close();
            log("read: " + res);
            log("The sausage has been retrieved. It IS"+(res.isCooked()?" ":" NOT ")+"cooked "+(res.isBurnt()?"but IS ":"and IS NOT ")+"burnt.");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    protected static void log(String str) {
        System.out.println(str);
    }
}

class Sausage {
    private boolean cooked, burnt;
    public Sausage() {
        this.cooked = false;
        this.burnt = false;
    }
    public void cook() {this.cooked = true;}
    public void burn() {this.burnt = true;}
    public boolean isCooked() {return this.cooked;}
    public boolean isBurnt() {return this.burnt;}
}
