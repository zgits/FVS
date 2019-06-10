package com.four.fvs.tools;


import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author: zjf
 * @Date: 2019/5/21 17:59
 * @Description: 获取视频的时长以及封面
 */
public class ReadVideo {


    public static String DateToString(){
        Date date = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);       //将Date类型转换成String类型
        return format;
    }

    /**
     * 获取指定视频的帧并保存为图片至指定目录
     *
     * @param path      视频文件路径
     * @return framefile 截取的图片地址
     * @throws
     */
    public static String fetchPic(String path) {
        String framefile=DateToString()+".jpg";
        File file = new File(path);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(file);
        try {
            ff.start();

            int lenght = ff.getLengthInFrames();

            File targetFile = new File(framefile);
            int i = 0;
            Frame frame = null;
            while (i < lenght) {
                // 过滤前5帧，避免出现全黑的图片，依自己情况而定
                frame = ff.grabFrame();

                if ((i > 5) && (frame.image != null)) {
                    break;
                }
                i++;
            }

            String imgSuffix = "jpg";
            if (framefile.indexOf('.') != -1) {
                String[] arr = framefile.split("\\.");
                if (arr.length >= 2) {
                    imgSuffix = arr[1];
                }
            }


            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage srcBi = converter.getBufferedImage(frame);
            int owidth = srcBi.getWidth();
            int oheight = srcBi.getHeight();
            // 对截取的帧进行等比例缩放
            int width = 1920;
            int height = (int) (((double) width / owidth) * oheight);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            bi.getGraphics().drawImage(srcBi.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

            ImageIO.write(bi, imgSuffix, targetFile);
            ff.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return framefile;
    }




    /**
     * 获取视频时长，按照hh:MM:ss格式返回，小时为0就以MM:ss格式返回
     *
     * @param path
     * @return 格式字符串
     */
    public static String getVideoTime(String path) {
        File file = new File(path);
        Long times = 0L;
        try {
            FFmpegFrameGrabber ff = new FFmpegFrameGrabber(file);
            ff.start();
            times = ff.getLengthInTime() / (1000 * 1000);
            ff.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String DateTimes = "";
        long hours = (times % (60 * 60 * 24)) / (60 * 60);
        long minutes = (times % (60 * 60)) / 60;
        long seconds = times % 60;
        if (hours > 0) {
            if (hours > 9) {
                DateTimes += hours+":";
            } else {
                DateTimes += "0" + hours+":";
            }
        } else {
            if (minutes > 9) {
                DateTimes += minutes+":";
            } else {
                DateTimes += "0" + minutes+":";
            }
            if (seconds < 10) {
                DateTimes += "0" + seconds;
            } else {
                DateTimes += seconds;
            }

        }

        return DateTimes;

   }



    public static void main(String[] args) {

        System.out.println(getVideoTime("C:\\Users\\幻夜~星辰\\Desktop\\工程实践4\\overlayVideo.mp4"));
        System.out.println(fetchPic("C:\\Users\\幻夜~星辰\\Desktop\\工程实践4\\VID_20190521_191028.mp4"));

    }


}