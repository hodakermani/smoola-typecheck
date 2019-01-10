package main.codeGeneration;

import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class CodeGenerator  {

    public static void saveByteCode(ClassWriter cw) throws IOException {
        //save bytecode into disk
        FileOutputStream out = new FileOutputStream("../out.class");
        try {
            out.write(cw.toByteArray());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
