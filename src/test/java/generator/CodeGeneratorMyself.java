package generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;
import java.util.Collections;

/**
 * @author zhengfeipeng
 * <p>
 * 生成数据库表对应的 实体/Dao/Service/Controller
 */
@Slf4j
public class CodeGeneratorMyself {

    /**
     * 包含的表. 若空则表示该库中全部的表.
     * dispatch_detail_log,dispatch_center,dispatch_rule,dispatch_plan_manager,dispatch_task_manager，DISPATCH_CASE_DETAIL_LOG
     * RELA_PLAN,RELA_PLAN_DETAIL,RELA_TASK,RELA_TASK_DETAIL,RELA_PLAN_MANAGER,RELA_PLAN_MANAGER_DETAIL
     *REPORT_MODULE，REPORT_VERSION，REPORT_PROCESS，REPORT_PROCESS_DETAIL
     * SAMPLING_POINT_LIST
     */
    private static String tables =
            "SAMPLING_POINT_LIST";

    /**
     * 排除的表.
     */
    private static String[] exTables = {
    };

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:oracle:thin:@10.20.157.131:1521:orcl", "FA_DRILL_MANAGER", "hshome123")
                .globalConfig(builder -> {
                    builder.author("liming39602") // 设置作者
                            // 开启 swagger 模式
                            .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java");
                })
//                .dataSourceConfig(builder ->
//                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                            if (typeCode == Types.INTEGER) {
//                                // 自定义类型转换
//                                return DbColumnType.INTEGER;
//                            }
//                            return typeRegistry.getColumnType(metaInfo);
//                        })
//                )
                .packageConfig(builder ->
                        builder.parent("com.hundsun.fa.drill.repository") // 设置父包名
                                .entity("po.drill")
                                .mapper("mapper.drill")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, Paths.get(System.getProperty("user.dir")) + "/src/main/resources/mapper/drill")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .entityBuilder().enableFileOverride() // 允许覆盖实体类
                            .mapperBuilder().enableFileOverride()// 允许覆盖Mapper类
                    ;
                    builder.controllerBuilder().disable();
                    builder.serviceBuilder().disable();
                    // 设置需要生成的表名// 设置过滤表前缀
                })
                .templateEngine(new VelocityTemplateEngine())// 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


}
