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
package com.shik.support.generator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.shik.support.generator.tools.FreemarkerUtils;
import com.shik.support.generator.tools.JdbcUtil;
import com.shik.support.generator.tools.StringUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.List;
import java.util.Map;


/**
 * @author gengshikun
 * @date 2017/7/5
 */
public class MybatisGeneratorXml {

    // 模板路径
    private static String VM_PATH = "mybatis-generator";
    // 项目名称
    private static String PROJECT_NAME = "/src/main/java";
    // 数据库名称
    private static String DATABASE_NAME = "springboot";

    /**
     * 根据模板生成generatorConfig.xml文件
     *
     * @param module_prefix_name
     */
    public static void generator(
            String jdbc_driver,
            String jdbc_url,
            String jdbc_username,
            String jdbc_password,
            String module_prefix_name) {
        String module_path = module_prefix_name + "/src/main/resources/mybatis-generator/generatorConfig.xml";
        String sql = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + DATABASE_NAME + "';";
        System.out.println("========== 开始生成generatorConfig.xml文件 ==========");
        try {
            List<Map<String, Object>> tables = Lists.newArrayList();
            Map<String, Object> table = null;

            // 查询定制前缀项目的所有表
            JdbcUtil jdbcUtil = new JdbcUtil(jdbc_driver, jdbc_url, jdbc_username, jdbc_password);
            List<Map> result = jdbcUtil.selectByParams(sql, null);
            for (Map map : result) {
                System.out.println(map.get("TABLE_NAME"));
                table = Maps.newHashMap();
                table.put("table_name", map.get("TABLE_NAME"));
                table.put("model_name", StringUtil.lineToHump(map.get("TABLE_NAME").toString()));
                tables.add(table);
            }
            jdbcUtil.release();

            Map<String, Object> context = Maps.newHashMap();
//			String targetProject = PROJECT_NAME + module_prefix_name.replaceAll("\\.", "-") + "-dao";
            context.put("jdbc_driver", jdbc_driver);
            context.put("jdbc_url", jdbc_url);
            context.put("jdbc_username", jdbc_username);
            context.put("jdbc_password", jdbc_password);

            context.put("tables", tables);
            context.put("project", module_prefix_name + PROJECT_NAME);
            context.put("generator_javaModelGenerator_targetPackage", "com.shik.dao.model");
            context.put("generator_sqlMapGenerator_targetPackage", "com.shik.dao.mapper");
            context.put("generator_javaClientGenerator_targetPackage", "com.shik.dao.mapper");
//			context.put("targetProject", targetProject);
            context.put("master_jdbc_password", jdbc_password);
            FreemarkerUtils.generateToFile(VM_PATH, "generatorConfig.ftl", module_path, context, "UTF-8");
            // 删除旧代码
            deleteDir(new File(module_prefix_name + "/src/main/java/com/shik/dao/model"));
            deleteDir(new File(module_prefix_name + "src/main/java/com/shik/dao/mapper"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

        // 生成代码

    }

    public static void execute(String generatorPath){
        System.out.println("========== 开始运行MybatisGenerator ==========");
        try {
            List<String> warnings = Lists.newArrayList();
            File configFile = new File(MybatisGeneratorXml.class.getResource(generatorPath).getPath().replace("/target/classes/", "/src/main/resources/"));
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            for (String warning : warnings) {
                System.out.println(warning);
            }
            deleteDir(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("========== 结束运行MybatisGenerator ==========");
    }

    // 递归删除非空文件夹
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        dir.delete();
    }

    public static void main(String[] args) {
        String path = Class.class.getClass().getResource("/").getPath();
        String targetProject = findProjectName(path);
        System.out.println(targetProject);

        String projectBasePath = findProjectBasePath(path);
        System.out.println(projectBasePath);
    }

    private static String findProjectName(String path) {
        path = path.substring(0, path.length() - 16);
        String projectName = path.substring(path.lastIndexOf("/") + 1, path.length());
        return projectName;
    }

    private static String findProjectBasePath(String path) {
        path = path.substring(0, path.length() - 16);
        return path;
    }

}
