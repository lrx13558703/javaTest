import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class IOTest {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File("局域网地址");
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        System.out.println(br.readLine());
        String temp = "";
        while ((temp = br.readLine()) != null) {
            sb.append(temp + System.getProperty("line.separator"));
        }

//        System.out.println(sb);

        File file2 = new File("目标地址");
        file2.createNewFile();

        BufferedWriter out = new BufferedWriter(new FileWriter(file2));
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
