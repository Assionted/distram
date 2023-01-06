package im.anchor.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 逆向工程核心生成代码
 */
public class GeneratorSql {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定逆向工程配置文件
        String file = GeneratorSql.class.getResource("/config/generatorConfig.xml").getFile();
        System.out.println("file: " + file);
        File configFile = new File(file);
        System.out.println("configFile: " + configFile);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        System.out.println("cp: " + cp);
        Configuration config = cp.parseConfiguration(configFile);
        System.out.println("config: " + config);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        System.out.println("callback: " + callback);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        System.out.println("myBatisGenerator: " + myBatisGenerator);
        myBatisGenerator.generate(null);
    }
}
