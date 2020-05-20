package jobs;

import com.csvreader.CsvReader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class csv {
    public static void main(String[] args) throws Exception {
        File file = new File("E:/1026653290/任务/jobs4.csv");
        InputStream in = new FileInputStream(file);
        CsvReader cr = new CsvReader(in, Charset.forName("UTF-8"));

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/1026653290/任务/jobs/jobs4/output/job4.txt")));

        //获取CSV文件的表头
        cr.readHeaders();
        System.out.println(cr.getHeader(13));
        System.out.println("---------------------");
        System.out.println("各个字段的名称为" + Arrays.toString(cr.getHeaders()));

        //读取
        cr.readRecord();

        String rawRecord = cr.getRawRecord();

        //获取字段数
        int columnCount = cr.getColumnCount();
        System.out.println("一共有" + columnCount + "个字段");
        while (cr.readRecord()) {

            for (int i = 0; i < columnCount; i++) {
                //获取指定字段数的值
                String str = cr.get(i);
                Pattern p = Pattern.compile("\\s+|\t+|\n|\r");
                Matcher m = p.matcher(str);
                String s = m.replaceAll("");
                System.out.println(s);
                out.write(s);
            }
        }

        //关闭资源
        cr.close();
    }
}
