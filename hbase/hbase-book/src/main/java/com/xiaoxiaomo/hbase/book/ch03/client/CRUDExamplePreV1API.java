package com.xiaoxiaomo.hbase.book.ch03.client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import util.HBaseHelper;

import java.io.IOException;

// cc CRUDExamplePreV1API Example application using all of the basic access methods (before v1.0)
@SuppressWarnings("deprecation") // because of old API usage
public class CRUDExamplePreV1API {

    public static void main(String[] args) throws IOException {

        //// 加载配置
        Configuration conf = HBaseConfiguration.create();
        HBaseHelper helper = HBaseHelper.getHelper(conf);

        /** drop create table */
        helper.dropTable("testtable");
        helper.createTable("testtable", "colfam1", "colfam2");

        //
        HTable table = new HTable(conf, "testtable");


        /** put */
        Put put = new Put(Bytes.toBytes("row1"));
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"), Bytes.toBytes("val1"));
        put.add(Bytes.toBytes("colfam2"), Bytes.toBytes("qual2"), Bytes.toBytes("val2"));
        table.put(put);

        /** scan */
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        for (Result result2 : scanner) {
            System.out.println("Scan 1: " + result2);
        }


        /** get */
        Get get = new Get(Bytes.toBytes("row1"));
        get.addColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"));
        Result result = table.get(get);
        System.out.println("Get result: " + result);
        byte[] val = result.getValue(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"));
        System.out.println("Value only: " + Bytes.toString(val));


        /** delete */
        Delete delete = new Delete(Bytes.toBytes("row1"));
        delete.deleteColumns(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"));
        table.delete(delete);

    }
}
