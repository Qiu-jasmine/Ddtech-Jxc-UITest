package libs;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import com.csvreader.CsvReader;

public class ReadCSV {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\eclipseworkplace\\jxc01\\data\\test.csv";
        CsvReader reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
        reader.readHeaders(); // 跳过表头, 如果不需要表头的话，不要写这句。
        while (reader.readRecord()) {
            // 一下获取的行号是从0开始
            System.out.println("当前行号 " + reader.getCurrentRecord());
            // 读取行内容记录
            System.out.println(reader.getRawRecord());
            System.out.println("==========");
            // 按列名读取这条记录的值
            System.out.println(reader.get("name"));
            System.out.println(reader.get("cander"));
            System.out.println("--------");
            if (reader.getCurrentRecord() == 3) {
                // 此处第四行是指去除表头开始计数的第四行，从一开始。
                System.out.println("这是第四行的记录" + reader.getRawRecord());
                // 读取指定行的指定列内容
                System.out.println(reader.get("name"));
                System.out.println(reader.get("cander"));

            }
        }
    }
}