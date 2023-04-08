package com.mofan.test;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author MoFany-J
 * @date 2023/4/2
 * @description CsvTest
 */
public class CsvTest {
    @Test
    public void test1() throws IOException {
        String content = "ID,MENU_NAME,MENU_CODE,MENU_TYPE,IDX,PARENT_ID,ICON,URL_PREFIX,URL,VAILD,REMARK,CREATE_TIME,CREATE_USER,OPEN_TYPE\n" +
                "105,系统管理,XTGL,XTGL,Menu,1030,null,fa fa-sliders,,Y,,2016-04-28 10:58:03.0,admin,0\n" +
                "0dfbc01aaa9e4565ac4b613b98084a39,工程报修类别,CMDB_EngineeringRepairReport,CMDB_EngineeringRepairReport,Menu,1,105,,,/cmdbfront/index.html#/ci_common?code=EngineeringRepairReport&title=工程报修类别&alias=EngineeringRepairReport_SELECTOR,Y,类型创建,2022-06-27 14:57:37.0,bztest03,0\n" +
                "5b6a31af14fc4655bb0084c166d4cefe,编辑,editobj,editobj,Func,1,0dfbc01aaa9e4565ac4b613b98084a39,,,,Y,,2022-06-27 14:57:37.0,bztest03,0\n" +
                "80b5049a9510423f81b22dbf77ccc681,删除,delobj,delobj,Func,2,0dfbc01aaa9e4565ac4b613b98084a39,,,,Y,,2022-06-27 14:57:37.0,bztest03,0\n" +
                "0f8292b2b7ab4c8aa4ffce2e7b4b4057,日志管理,XTGL-LOG,XTGL-LOG,Menu,30,105,,,/sys/#/LogManage,Y,,2019-03-14 19:27:15.0,dai,0\n" +
                "b292cec5b87d42658e84db96fa92eaa7,导出,LOG-EXPORT,LOG-EXPORT,Func,3,0f8292b2b7ab4c8aa4ffce2e7b4b4057,,,,Y,,2019-03-14 19:29:02.0,dai,0\n" +
                "1051,菜单管理,XTGL-CDGL,XTGL-CDGL,Menu,13,105,,,/sys/#/Menu,Y,,2016-04-28 11:01:01.0,admin,0\n" +
                "3a72f25937d9441ea4cbb1fb81ed8391,导出,export_menu,export_menu,Func,2,1051,,,,Y,,2021-06-16 15:25:54.0,bztest02,0\n" +
                "58dadd32a33c4492bce38f01a77e4954,删除,del_menu,del_menu,Func,5,1051,,,,Y,,2021-06-16 15:26:50.0,bztest02,0\n" +
                "61122be1eb4c4eb2b6a35d4b600a7586,修改,edit_menu,edit_menu,Func,4,1051,,,,Y,,2021-06-16 15:26:36.0,bztest02,0\n" +
                "7fcbe4343e0e4e89904364c00c748b82,新增,add_menu,add_menu,Func,3,1051,,,,Y,,2021-06-16 15:26:15.0,bztest02,0\n" +
                "a316b361c85c4e04954ceaab4fb49ed6,导入,import_menu,import_menu,Func,1,1051,,,,Y,,2021-06-16 15:25:24.0,bztest02,0\n" +
                "1054,角色管理,XTGL-JSGL,XTGL-JSGL,Menu,12,105,,,/sys/#/Role,Y,,2016-04-28 10:59:16.0,,0\n" +
                "1748fe9eb3594535960977556d46a048,修改,edit_role,edit_role,Func,2,1054,,,,Y,,2021-07-08 11:41:24.0,bztest05,0\n" +
                "5b4fe0a3f8cf4b2c8b151e9b3983c119,新增,add_role,add_role,Func,1,1054,,,,Y,,2021-07-08 11:40:28.0,bztest05,0\n" +
                "8a8374a962454565a69556573d8c5f8b,编辑权限,edit_auth_role,edit_auth_role,Func,4,1054,,,,Y,,2021-07-08 11:45:50.0,bztest05,0\n" +
                "f629d3b222254baeb60aef618b77fa7d,删除,del_role,del_role,Func,3,1054,,,,Y,,2021-07-08 11:42:38.0,bztest05,0\n" +
                "11092599089a4eb7acaddac418913666,APP版本管理,XTGL-APP,XTGL-APP,Menu,21,105,,,/sys/#/AppVersion,Y,,2020-12-28 17:54:47.0,bztest04,0\n" +
                "82794976a86743cfbfe8facd39f84432,新增,addobj,addobj,Func,3,11092599089a4eb7acaddac418913666,,,,Y,,2021-08-19 11:14:29.0,bztest05,0\n" +
                "ad939b30828e415eb8268db29397030c,编辑,editobj,editobj,Func,2,11092599089a4eb7acaddac418913666,,,,Y,,2021-08-19 11:14:09.0,bztest05,0\n" +
                "cdc1580c4d5a42b3a765cd8609d26ec7,删除,delobj,delobj,Func,1,11092599089a4eb7acaddac418913666,,,,Y,,2021-08-19 11:13:53.0,bztest05,0\n" +
                "16693e93f03948cdb6860e62a0721a22,快捷菜单,CMDB_Feature_Favorites,CMDB_Feature_Favorites,Menu,14,105,,,/cmdbfront/index.html#/ci_common?code=Feature_Favorites&title=快捷菜单&alias=Feature_Favorites_SELECTOR,Y,类型创建,2021-12-23 11:56:48.0,bztest01,0\n" +
                "4d367095d52749228f2575d9dc473ab5,删除,delobj,delobj,Func,2,16693e93f03948cdb6860e62a0721a22,,,,Y,,2021-12-23 11:56:48.0,bztest01,0\n" +
                "7139ed82545c45dfa4d4dccc5ae28536,编辑,editobj,editobj,Func,1,16693e93f03948cdb6860e62a0721a22,,,,Y,,2021-12-23 11:56:48.0,bztest01,0\n" +
                "1c69cc9cab2e439785b4f503cbc680cf,位置管理,CMDB_Loc,CMDB_Loc,Menu,2,105,,,/cmdbfront/index.html#/ci_common?code=Loc&title=位置管理&alias=loc_management,Y,类型创建,2020-12-01 17:25:28.0,null,0\n" +
                "5c71fb8c20024338a68daaf7659338e5,项目信息配置,CMDB_ProjectReceviableConfig,CMDB_ProjectReceviableConfig,Menu,2,105,,,/cmdbfront/index.html#/ci_common?code=ProjectReceviableConfig&title=项目信息配置&alias=ProjectReceviableConfig_SELECTOR,Y,类型创建,2022-02-24 13:43:20.0,bztest03,0\n" +
                "29899f1010e142aa8ab953d7aab06a2a,删除,delobj,delobj,Func,2,5c71fb8c20024338a68daaf7659338e5,,,,Y,,2022-02-24 13:43:20.0,bztest03,0\n" +
                "bc3f4e6c1258441f801219dd697fa111,编辑,editobj,editobj,Func,1,5c71fb8c20024338a68daaf7659338e5,,,,Y,,2022-02-24 13:43:20.0,bztest03,0\n" +
                "5dd942ff93ae44cd8e58733246443c0c,页面轮询,XTGL_YMLX,XTGL_YMLX,Menu,31,105,,,/sys/#/List?p=demo,Y,,2019-06-13 18:05:49.0,yan,0\n" +
                "0eae86cab317431eaa1bcd2af897eaf4,编辑,editobj,editobj,Func,2,5dd942ff93ae44cd8e58733246443c0c,,,,Y,,2021-08-19 11:20:22.0,bztest05,0\n" +
                "6b5e3593f23e4e69ad608de8a9bb2477,删除,delobj,delobj,Func,3,5dd942ff93ae44cd8e58733246443c0c,,,,Y,,2021-08-19 11:20:46.0,bztest05,0\n" +
                "84378797b15e405ba88058636bb012e0,新增,addobj,addobj,Func,1,5dd942ff93ae44cd8e58733246443c0c,,,,Y,,2021-08-19 11:20:00.0,bztest05,0\n" +
                "751d6e5033c544378c92ef16ca8d4954,系统能力,CMDB_sys_ability,CMDB_sys_ability,Menu,1,105,,,/cmdbfront/index.html#/ci_common?code=sys_ability&title=系统能力&alias=sys_ability_SELECTOR2,Y,类型创建,2023-02-08 10:33:22.0,bztest03,0\n" +
                "7c4e17ccac974ddf8971499113503541,项目管理,CMDB_Project,CMDB_Project,Menu,1,105,,,/cmdbfront/index.html#/ci_common?code=Project&title=项目管理&alias=Project_SELECTOR,Y,类型创建,2022-02-07 16:53:04.0,bztest01,1\n" +
                "9510f357923d4278b525597639291a65,系统权限映射,CMDB_SystemPermissionMapping,CMDB_SystemPermissionMapping,Menu,1,105,,,/cmdbfront/index.html#/ci_common?code=SystemPermissionMapping&title=系统权限映射&alias=SystemPermissionMapping_SELECTOR,Y,类型创建,2022-05-13 14:09:48.0,bztest03,0\n" +
                "6ac5a41e4bd8426595e90d8aadb28982,删除,delobj,delobj,Func,2,9510f357923d4278b525597639291a65,,,,Y,,2022-05-13 14:09:49.0,bztest03,0\n" +
                "d70e23aabecc4d5f9b9aff98ab06f54c,编辑,editobj,editobj,Func,1,9510f357923d4278b525597639291a65,,,,Y,,2022-05-13 14:09:49.0,bztest03,0\n" +
                "9ac61c66671d410ea45ac8c5fdb30070,人员管理,CMDB_Person,CMDB_Person,Menu,10,105,,,/cmdbfront/index.html#/ci_common?code=Person&title=人员管理&alias=Person_SELECTOR,Y,类型创建,2021-04-14 14:01:48.0,null,0\n" +
                "c1243f40001d4dc9bbeba5fce1673b4e,调度管理,XTGL_DDGL,XTGL_DDGL,Menu,32,105,iconfont icontiaoduguanli,,/TaskDispatch/#/dispatch?p=tpim&t=调度管理,Y,,2019-03-28 09:44:34.0,dai,0\n" +
                "223d44aab139445fa5e5ee39b6b23a28,手动执行任务,DDGL-PERFORMTASK,DDGL-PERFORMTASK,Func,10,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:50:52.0,dai,0\n" +
                "35c92c85b8fa4060a54bb09091061a41,修改任务类型,DDGL-EDITTASKTYPE,DDGL-EDITTASKTYPE,Func,3,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:47:04.0,dai,0\n" +
                "42dca6ac3d424365a3b5e3638b55bf59,删除任务,delobj,delobj,Func,8,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:48:52.0,dai,0\n" +
                "5d187a8f524f4bb9be124703b8119721,修改任务状态,DDGL-EDITTASKSTATUS,DDGL-EDITTASKSTATUS,Func,9,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:49:16.0,dai,0\n" +
                "673b78e4e8c44ae7b36bad3be8ca32c5,查看任务日志,log,log,Func,11,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:51:21.0,dai,0\n" +
                "873a0f57298d455e94a9081787933476,手动执行命令,DDGL-PERFORMORDER,DDGL-PERFORMORDER,Func,12,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:53:35.0,dai,0\n" +
                "981ff2ed345b4f15b99e14dcf36012a2,新增任务,DDGL-ADDTASK,DDGL-ADDTASK,Func,6,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:48:15.0,dai,0\n" +
                "a3fbc5b9440e4dfab595c991598f15b0,新增任务类型,DDGL-ADDTASKTYPE,DDGL-ADDTASKTYPE,Func,2,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:46:36.0,dai,0\n" +
                "aa723ca95c91430a8e96045a7b5b94fc,导出任务数据,exp,exp,Func,13,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:54:12.0,dai,0\n" +
                "adb128ef7a8e4da6816d8bd94f7753b9,导入任务数据,imp,imp,Func,14,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:54:38.0,dai,0\n" +
                "be18e286db7541a5a7b348635ccafe9f,修改任务,DDGL-EDITTASK,DDGL-EDITTASK,Func,7,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:48:35.0,dai,0\n" +
                "c7a086e52275421ca8d1005d76c8da78,编辑,editobj,editobj,Func,1,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2021-03-25 10:14:58.0,bztest05,0\n" +
                "d42587bc4a5a499e9198401f3ea1f271,查看任务,DDGL-VIEWTASK,DDGL-VIEWTASK,Func,5,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:47:53.0,dai,0\n" +
                "d5dc87d6a74d4f0fbe8439ce497003f5,删除任务类型树,DDGL-DELTYPE,DDGL-DELTYPE,Func,4,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:47:31.0,dai,0\n" +
                "ff49347a40f846cbab28d7c81c824c06,查看任务类型树,DDGL-VIEWTASKTYPE,DDGL-VIEWTASKTYPE,Func,1,c1243f40001d4dc9bbeba5fce1673b4e,,,,Y,,2019-03-28 09:46:04.0,dai,0\n" +
                "d6ae7a64bff54624bd3ec8beb32d68d6,用户管理,XTGL-YHGL,XTGL-YHGL,Menu,11,105,,,/sys/#/User,Y,,2016-04-28 10:59:16.0,admin,0\n" +
                "746c06512b214624bc551988fb04d88c,删除,del_user,del_user,Func,3,d6ae7a64bff54624bd3ec8beb32d68d6,,,,Y,,2021-06-17 14:21:01.0,bztest02,0\n" +
                "9f5dcf200e6d4b5aaf23e8a18951be08,重置密码,reset_pwd_user,reset_pwd_user,Func,4,d6ae7a64bff54624bd3ec8beb32d68d6,,,,Y,,2021-06-17 14:21:56.0,bztest02,0\n" +
                "b33b235ea89e4149becac8294169382a,新增,add_user,add_user,Func,1,d6ae7a64bff54624bd3ec8beb32d68d6,,,,Y,,2021-06-17 14:20:01.0,bztest02,0\n" +
                "f0e904adc40148d5bb965c64c8c8d681,修改,edit_user,edit_user,Func,2,d6ae7a64bff54624bd3ec8beb32d68d6,,,,Y,,2021-06-17 14:20:49.0,bztest02,0\n" +
                "f576e4bc728d460c8699b3c20e79980f,新增角色,add_role,add_role,Func,5,d6ae7a64bff54624bd3ec8beb32d68d6,,,,Y,,2021-08-12 17:44:18.0,youxing,0\n" +
                "df3bd51d8f44478e8becf07567a56aae,APP授权管理,XTGL-AUTH,XTGL-AUTH,Menu,20,105,,,/sys/#/Authorization,Y,,2021-11-16 08:59:19.0,bztest04,0\n" +
                "40698fc73e514fc8b193cff949d69139,删除,delobj,delobj,Func,3,df3bd51d8f44478e8becf07567a56aae,,,,Y,,2021-11-16 09:00:33.0,bztest04,0\n" +
                "abe38c00990c431a89d04302589a7d06,编辑,editobj,editobj,Func,1,df3bd51d8f44478e8becf07567a56aae,,,,Y,,2021-11-16 09:00:09.0,bztest04,0\n" +
                "e53506fbd53f4490b8a4c6544f43ab34,新增,addobj,addobj,Func,2,df3bd51d8f44478e8becf07567a56aae,,,,Y,,2021-11-16 09:00:23.0,bztest04,0\n" +
                "e839ac9ff7c9488694d427260e3b7e8a,组织管理,CMDB_Org,CMDB_Org,Menu,3,105,,,/cmdbfront/index.html#/ci_common?code=Org&title=组织管理&alias=Org_SELECTOR,Y,类型创建,2021-12-18 22:10:03.0,bztest01,0";
        File importFile = new File("src/main/resources/tempFile/current.csv");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(importFile)), "utf-8"))) {
            // csv文件bom头
            System.out.println(Charset.defaultCharset());
            bufferedWriter.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            bufferedWriter.write(content);
            // 刷新缓冲
            bufferedWriter.flush();
        }
    }
}
