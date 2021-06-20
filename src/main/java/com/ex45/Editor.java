package com.ex45;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Editor
{
    String fName;
    String fDes;
    String t;
    String replace;

    public String replaceTheTextInFile()
    {
        Path path = Paths.get(fName);
        Path desPath = Paths.get(fDes);
        Charset cset = Charset.forName("UTF-8");
        try {
            BufferedWriter bw = Files.newBufferedWriter(desPath, cset);
            Scanner sc = new Scanner(path, cset.name());
            String current;
            while (sc.hasNextLine())
            {
                current = sc.nextLine();
                current = current.replaceAll(t, replace);
                bw.write(current);
                bw.newLine();
            }
            sc.close();
            bw.close();
            return "Success";
        } catch(Exception ex){
            return "Failure";
        }
    }
}

