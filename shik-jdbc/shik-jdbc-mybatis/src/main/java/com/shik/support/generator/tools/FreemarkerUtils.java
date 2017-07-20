/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
package com.shik.support.generator.tools;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Locale;

/**
 * @author gengshikun
 * @date 2017/7/5
 */
public class FreemarkerUtils {

    private static Configuration getFreemarkerConfig(String templatePath) throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_23);
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getFile();
        config.setDirectoryForTemplateLoading(new File(classpath + "/" + templatePath));
        config.setEncoding(Locale.CHINA, "utf-8");
        return config;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
    }

    /**
     * 用FTL模板生成HTML，并返回HTML内容
     *
     * @param ftlPath    ftl模板文件的路径（不含文件名）
     * @param ftlName    ftl模板文件的名称（不含路径）
     * @param outputFile 输出文件（全路径名称）
     * @param data       数据Map类型，key-value
     * @param charset    编码
     * @throws TemplateNotFoundException
     * @throws MalformedTemplateNameException
     * @throws ParseException
     * @throws IOException
     * @throws TemplateException
     */
    public static void generateToFile(String ftlPath, String ftlName, String outputFile, Object data, String charset) throws IOException {

        File file = new File(outputFile.split("/")[0]);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(outputFile);
        Writer out = new OutputStreamWriter(fos, charset);
        try {
            charset = StringUtils.isBlank(charset) ? "UTF-8" : charset;

            Template tpl = getFreemarkerConfig(ftlPath).getTemplate(ftlName);
            tpl.setOutputEncoding(charset);

            tpl.process(data, out);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
            out.close();
        }
    }

    /**
     * 用FTL模板生成HTML，并返回HTML内容
     *
     * @param ftlPath ftl模板文件的路径（不含文件名）
     * @param ftlName ftl模板文件的名称（不含路径）
     * @param o       数据 Map类型，key-value
     * @param charset 编码
     * @return
     * @throws TemplateNotFoundException
     * @throws MalformedTemplateNameException
     * @throws ParseException
     * @throws IOException
     * @throws TemplateException
     */
    public static String generateToString(String ftlPath, String ftlName, Object o, String charset) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {

        charset = StringUtils.isBlank(charset) ? "UTF-8" : charset;

        String html = null;

        Template tpl = getFreemarkerConfig(ftlPath).getTemplate(ftlName);
        tpl.setOutputEncoding(charset);

        StringWriter writer = new StringWriter();
        tpl.process(o, writer);
        writer.flush();
        html = writer.toString();
        return html;
    }
}
