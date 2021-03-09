package cn.hmxz.common.utils.file;

import cn.hmxz.common.utils.StringUtils;
import cn.hmxz.modules.lit.config.BlackConfig;
import cn.hmxz.modules.lit.exception.CustomException;
import cn.hmxz.modules.lit.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 图片处理工具类
 *
 * @author copote
 */
public class ImageUtils {
    private static final Logger log = LoggerFactory.getLogger(ImageUtils.class);

    @Data
    @AllArgsConstructor
    public static class ImageInfo {
        private String mimeType;
        private String suffix;
        private int width;
        private int height;
    }

    public static byte[] getImage(String imagePath) {
        InputStream is = getFile(imagePath);
        try {
            return IOUtils.toByteArray(is);
        } catch (Exception e) {
            log.error("图片加载异常 {}", e);
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    public static ImageInfo getImageInfo(byte[] imageBytes) {
        try (MemoryCacheImageInputStream imageInputStream = new MemoryCacheImageInputStream(new ByteArrayInputStream(imageBytes))) {
            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(imageInputStream);
            if (imageReaders == null || !imageReaders.hasNext()) {
                throw new CustomException("无法获取图片MimeType");
            }
            ImageReader imageReader = imageReaders.next();
            imageReader.setInput(imageInputStream);
            ImageReaderSpi imageSpi = imageReader.getOriginatingProvider();
            BufferedImage image = imageReader.read(0, imageReader.getDefaultReadParam());
            String[] fileSuffixes = imageSpi.getFileSuffixes();
            String[] mimeTypes = imageSpi.getMIMETypes();
            return new ImageInfo(mimeTypes[0], fileSuffixes[0], image.getWidth(), image.getHeight());
        } catch (Exception e) {
            log.error("无法获取图片MimeType");
        }
        return null;
    }

    public static InputStream getFile(String imagePath) {
        try {
            byte[] result = readFile(imagePath);
            result = Arrays.copyOf(result, result.length);
            return new ByteArrayInputStream(result);
        } catch (Exception e) {
            log.error("获取图片异常 {}", e);
        }
        return null;
    }

    /**
     * 读取文件为字节数据
     *
     * @param url 地址
     * @return 字节数据
     */
    public static byte[] readFile(String url) {
        InputStream in = null;
        ByteArrayOutputStream baos = null;
        try {
            if (url.startsWith("http")) {
                // 网络地址
                URL urlObj = new URL(url);
                URLConnection urlConnection = urlObj.openConnection();
                urlConnection.setConnectTimeout(30 * 1000);
                urlConnection.setReadTimeout(60 * 1000);
                urlConnection.setDoInput(true);
                in = urlConnection.getInputStream();
            } else {
                // 本机地址
                String localPath = BlackConfig.getProfile();
                String downloadPath = localPath + StringUtils.substringAfter(url, Constants.RESOURCE_PREFIX);
                in = new FileInputStream(downloadPath);
            }
            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            log.error("获取文件路径异常 {}", e);
            return null;
        } finally {
            IOUtils.closeQuietly(baos);
        }
    }
}
