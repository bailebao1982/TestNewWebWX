/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author wewezhu
 */
public class QRCodeGenerator {
    
    private static final String FORMAT = "jpg";
    
    private static final int width = 480;
    
    private static final int length = 640;
    
    public static void encode(String content,String filePath) throws WriterException, IOException{
        QRCodeGenerator qrGenerator = new QRCodeGenerator();
        
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix;
        File file = new File(filePath,"qrcode.jpg");
        bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, length,(Hashtable) hints);
        //MatrixToImageWriter.writeToStream(bitMatrix, FORMAT, ops);
        MatrixToImageWriter.writeToFile(bitMatrix, FORMAT, file);
        
    }
    
    public static String decode(InputStream is) throws IOException, NotFoundException, ChecksumException, FormatException{
        QRCodeReader reader=new QRCodeReader();
        BufferedImage image=ImageIO.read(is);
        LuminanceSource source=new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap imageBinaryBitmap = new BinaryBitmap(binarizer);  
        Result result = reader.decode(imageBinaryBitmap);
        return result.getText();
        
    }
    
    public static void main(String[] args) throws WriterException, IOException{
        QRCodeGenerator.encode("123458", "d:\\");
    }
}
