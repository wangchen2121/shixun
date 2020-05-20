package jobs;

import com.csvreader.CsvReader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jobs6 {
    public static void main(String[] args) throws IOException {

        File file = new File("E:/1026653290/任务/jobs/jobs6/input/jobs6.csv");
        InputStream in = new FileInputStream(file);
        CsvReader cr = new CsvReader(in, Charset.forName("utf-8"));

        OutputStream out = new FileOutputStream("E:/1026653290/任务/jobs/jobs6/output/job6.csv");

        //输出约束信息
        cr.readHeaders();

        //输出一行数据
        while(cr.readRecord()){

            //读每一行
            cr.readRecord();

            //获取列数
            int columnCount = cr.getColumnCount();

            for (int i = 0; i < columnCount; i++) {
                String str = cr.get(i);
                Pattern p = Pattern.compile("\\s+|\t+|\n|\r");
                Matcher m = p.matcher(str);
                String s = m.replaceAll("；");
                byte[] bus = (s+',').getBytes();
                out.write(bus);
            }

            //加换行符
            out.write("\n".getBytes());
        }
    }
}