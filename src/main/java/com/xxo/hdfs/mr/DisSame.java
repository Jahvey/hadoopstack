package com.xxo.hdfs.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *
 * 去重 , 只获取手机号
 * Created by xiaoxiaomo on 2016/5/10.
 */
public class DisSame {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance(new Configuration(), DisSame.class.getSimpleName());
        job.setJarByClass(DisSame.class);

        //1. 数据来源
        FileInputFormat.setInputPaths(job, args[0]);

        //2. 调用map

        job.setMapperClass(DisSameMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        //3. 调用reduce
        job.setReducerClass(DisSameReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        //4. 写入数据
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        //5. 执行
        job.waitForCompletion(true) ;

    }

    /**
     * 自定义 Mapper
     */
    static class DisSameMap extends Mapper<LongWritable,Text,Text,NullWritable>{

        Text K2 = new Text() ;
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //处理单行数据信息
            String line = value.toString();
            String[] stirs = line.split("\t");
            K2.set(stirs[1]);
            context.write(K2 , NullWritable.get());
        }
    }

    /**
     * 自定义 Reduce
     */
    static class DisSameReduce extends Reducer<Text , NullWritable , Text ,NullWritable >{

        @Override
        protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
            context.write( key , NullWritable.get() );
        }
    }

}
