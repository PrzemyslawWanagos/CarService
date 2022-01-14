package com.infoshareacademy;

import java.io.File;

public abstract class Utils {

    public static File findFile(String path, String fName) {
        File f = new File(path);
        if (fName.equalsIgnoreCase(f.getName())) {
            return f;
        }
        if (f.isDirectory()) {
            for (String aChild : f.list()) {
                File ff = findFile(path + File.separator + aChild, fName);
                if (ff != null) return ff;
            }
        }
        return null;
    }

}

