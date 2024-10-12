package generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;
import java.sql.Types;
import java.util.Collections;

/**
 * @author wangjun51000
 * <p>
 * 生成数据库表对应的 实体/Dao/Service/Controller
 */
@Slf4j
public class CodeGenerator {

    /**
     * 包含的表. 若空则表示该库中全部的表.
     * dispatch_detail_log,dispatch_center,dispatch_rule,dispatch_plan_manager,dispatch_task_manager
     * RELA_PLAN,RELA_PLAN_DETAIL,RELA_TASK,RELA_TASK_DETAIL,RELA_PLAN_MANAGER,RELA_PLAN_MANAGER_DETAIL
     */
    private static String tables =
            "xxl_job_info";

    /**
     * 排除的表.
     */
    private static String[] exTables = {
    };

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai", "root", "hshome123")
                .globalConfig(builder -> {
                    builder.author("wangjun51000") // 设置作者
                            // 开启 swagger 模式
                            .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java");
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.INTEGER) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.business.program.cross.border.trade.repository") // 设置父包名
                                .entity("po")
                                .mapper("mapper")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, Paths.get(System.getProperty("user.dir")) + "/src/main/resources/mapper")) // 设置mapperXml生成路径
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
