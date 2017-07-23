<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >
<generatorConfiguration>

    <context id="MysqlContext" targetRuntime="MyBatis3" defaultModelType="flat">

        <property name="javaFileEncoding" value="UTF-8"/>
        <!-- 由于beginningDelimiter和endingDelimiter的默认值为双引号(")，在Mysql中不能这么写，所以还要将这两个默认值改为`  -->
        <property name="beginningDelimiter" value="`"/>
        <property name="endingDelimiter" value="`"/>

        <!-- 为生成的Java模型创建一个toString方法 -->
        <plugin type="org.mybatis.generator.plugins.ToStringPlugin"></plugin>

        <!-- 为生成的Java模型类添加序列化接口，并生成serialVersionUID字段 -->
        <plugin type="com.shik.plugin.SerializablePlugin">
            <property name="suppressJavaInterface" value="false"/>
        </plugin>

        <!-- 生成一个新的selectByExample方法，这个方法可以接收offset和limit参数，主要用来实现分页 -->
        <#--<plugin type="com.zkgengkun.plugin.PaginationPlugin"></plugin>-->

        <!-- 生成在XML中的<cache>元素 -->
        <#--<plugin type="org.mybatis.generator.plugins.CachePlugin">
            <!-- 使用ehcache &ndash;&gt;
            <property name="cache_type" value="org.mybatis.caches.ehcache.LoggingEhcache" />
            <!-- 内置cache配置 &ndash;&gt;
            <!--
            <property name="cache_eviction" value="LRU" />
            <property name="cache_flushInterval" value="60000" />
            <property name="cache_readOnly" value="true" />
            <property name="cache_size" value="1024" />
            &ndash;&gt;
        </plugin>-->

        <!-- Java模型生成equals和hashcode方法 -->
        <plugin type="org.mybatis.generator.plugins.EqualsHashCodePlugin"></plugin>

        <!-- 生成的代码去掉注释 -->
        <commentGenerator>
            <property name="suppressAllComments" value="true" />
            <property name="suppressDate" value="true"/>
        </commentGenerator>

        <!-- 数据库连接 -->
        <jdbcConnection driverClass="${jdbc_driver}" connectionURL="${jdbc_url}" userId="${jdbc_username}" password="${jdbc_password}" />

        <!-- 生成实体类地址 -->
        <javaModelGenerator targetPackage="${generator_javaModelGenerator_targetPackage}"
                            targetProject="${project}">
            <!-- 是否在当前路径下新加一层schema,eg：fase路径com.oop.eksp.user.model， true:com.oop.eksp.user.model.[schemaName] -->
            <property name="enableSubPackages" value="true"/>
            <!-- 是否针对string类型的字段在set的时候进行trim调用 -->
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- 生成mapxml文件 -->
        <sqlMapGenerator targetPackage="${generator_sqlMapGenerator_targetPackage}"
                         targetProject="${project}">
            <!-- 是否在当前路径下新加一层schema,eg：fase路径com.oop.eksp.user.model， true:com.oop.eksp.user.model.[schemaName] -->
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- 生成mapxml对应client，也就是接口dao -->
        <javaClientGenerator targetPackage="${generator_javaClientGenerator_targetPackage}"
                             targetProject="${project}" type="XMLMAPPER">
            <!-- 是否在当前路径下新加一层schema,eg：fase路径com.oop.eksp.user.model， true:com.oop.eksp.user.model.[schemaName] -->
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!-- 需要映射的表 -->
        <#list tables as table>
        <table tableName="${table.table_name}" domainObjectName="${table.model_name}"/>
        </#list>
    </context>
</generatorConfiguration>