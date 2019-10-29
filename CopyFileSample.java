package javaapplication1;
import java.io.*;
import java.util.Scanner;

public class CopyFileSample {
    public static void copy(File source, File destination) throws IOException{
        try (InputStream in = new FileInputStream (source);
        OutputStream out = new FileOutputStream (destination)){
            int b;
            while ((b = in.read()) != -1){
                out.write(b);
            }
        }
    }
    public static void setArch(File file1) {

        try {
            FileWriter fichero = new FileWriter(file1, false);
        
            
            PrintWriter pw = new PrintWriter(fichero);
            pw.write("");
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            File file1 = new File("File1.txt");
            File file2 = new File("File2.txt");
            
            if(!file1.exists() && !file2.exists()){
               file1.createNewFile(); 
               file2.createNewFile();
               FileWriter fw = new FileWriter(file1);
               BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vitae lorem felis." 
                       + " Curabitur in ultricies eros. Proin lacus lacus, tincidunt at ultricies at, egestas in nibh. Praesent vitae imperdiet quam. Vestibulum ut mattis magna. " 
                       + "Suspendisse potenti. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. " 
                       + "Praesent finibus diam non libero facilisis, placerat laoreet diam hendrerit.");
                bw.close();
            }
            System.out.println("Se copia el contenido de file1 en file2 si file2 es difefrente de file1");
            if(!file2.equals(file1))
                copy(file1, file2);
            
            
            System.out.println("¿Desea elimar el contenido del archivo 2?"
                              +"\t1) SI"
                              +"\t2) NO");
            int opc = sc.nextInt();
            if(opc == 1)
                setArch(file2);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}