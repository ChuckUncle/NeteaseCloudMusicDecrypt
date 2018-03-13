import java.io.*;  
  
public class Change{  
      
    public static void main(String[] args){  
        File f = null;
        String[] names;
        try{ 
             // change this path as your local music path
            f = new File("c:/Users/Chuck/Desktop/NewB/music");
                                 
            // array of files and directory
            names = f.list();
            // for each name in the path array
            for(int n=0,cName=0; n<names.length; n++,cName++) {
         
            File inFile = new File(f + "\\" + names[n]);
            // change this path as your desired output music directory. Like ["your path" + cName + ".mp3"].
            File outFile = new File("C:\\Users\\Chuck\\Desktop\\OutMusic\\" + cName + ".mp3");  
              
            DataInputStream dis = new DataInputStream( new FileInputStream(inFile));  
            DataOutputStream dos = new DataOutputStream( new FileOutputStream(outFile));  
            byte[] by = new byte[1000];  
            int len;  
            // decrypt, Netease Cloud Music using XOR with '0xa3'
            while((len=dis.read(by))!=-1){  
                for(int i=0;i<len;i++){  
                    by[i]^=0xa3;  
                }  
                dos.write(by,0,len);  
            }  
            dis.close();  
            dos.close();
            }  
        }catch(IOException ioe){  
            System.err.println(ioe);  
        }  
    }  
}  
