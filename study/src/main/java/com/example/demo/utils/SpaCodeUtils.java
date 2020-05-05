package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bijiankang
 * @title: 毕健康
 * @projectName service-spa
 * @description: TODO
 * @Date 2019/10/31 18:18
 */
@Slf4j
public class SpaCodeUtils {


    /**
     * 将 ETKA 的备件代码转变成 DSERP 的备件代码。
     *
     * @param bjdm ETKA 的备件代码:进口备件号：14位长度,国产备件号：15位长度，不足时后面加空格补齐，格式为：LXXXXXXXXXXXXXX
     * @return 新的 DSERP 的备件代码
     */
    public static String toDSERP(String bjdm) {

        return toSpaCode(bjdm);
//        char[] bytes = bjdm.toCharArray();
//        String bjdm_dserp;
//        if (bjdm.length() == 14) {
//            bjdm_dserp = etka2Dserp(bytes)[1];
//            log.info(bjdm + "(进口)-->" + bjdm_dserp);
//        } else {
//            bjdm = bjdm.substring(1);
//            bjdm_dserp = etka2Dserp(bytes)[0];
//            log.info(bjdm + "(国产)-->" + bjdm_dserp);
//        }
//        return bjdm_dserp;
    }


    private static String[] etka2Dserp(char[] ETKACode) {


        char chars = " ".charAt(0);

        if (ETKACode.length < 14) {

            char[] newChars = new char[14];

            System.arraycopy(ETKACode, 0, newChars, 0, ETKACode.length);

            for (int j = ETKACode.length; j < newChars.length; j++) {

                newChars[j] = chars;

            }

            ETKACode = newChars;

        }
        //一个空额
        final String space = " ";

        //两个空格
        final String doubleSpace = "  ";

        String LocalCode;
        String ImpCode;
        String F = new String(new char[]{ETKACode[11], ETKACode[12], ETKACode[13]});
        String E = new String(new char[]{ETKACode[10]});
        String D = new String(new char[]{ETKACode[9]});
        String C = new String(new char[]{ETKACode[6], ETKACode[7], ETKACode[8]});
        String B = new String(new char[]{ETKACode[3], ETKACode[4], ETKACode[5]});
        String A = new String(new char[]{ETKACode[0], ETKACode[1], ETKACode[2]});
        String Importpn = "";
        String Localpn = "";
        if (doubleSpace.equals(F)) {
            Importpn = A + space + B + space + C + space + D + E;
            Localpn = "L" + Importpn;
        }

        if (!doubleSpace.equals(F) && !space.equals(E)) {
            //%F非空格E非空格%
            Importpn = A + space + B + space + C + space + D + E + space + F;
            Localpn = "L" + A + space + B + space + C + space + D + E + F;
        }

        if (!doubleSpace.equals(F) && space.equals(E) && space.equals(D)) {
            //   %F非空格D空格E空格%
            Importpn = A + space + B + space + C + space + F;
            Localpn = "L" + Importpn;
        }

        if (!doubleSpace.equals(F) && space.equals(E) && !space.equals(D)) {
            //%F非空格D非空格E空格%
            Importpn = A + space + B + space + C + space + D + space + F;
            Localpn = "L" + Importpn;
        }

        //国产件：去除首代码“L”后，解析规则同进口件相同，解析出来的代码若长度超过18位，需要将解析后的代码最后一位空格去除。
        //跳不进来：不用改，目前的算法就适合
        if (Localpn.length() > 18) {
            log.error(Localpn + "超过18位需要将解析后的代码最后一位空格去除。");

        }

        ImpCode = Importpn.trim();
        //%去掉字符串末尾多余空格%
        LocalCode = Localpn.trim();
        String[] list = new String[2];
        list[0] = LocalCode;
        list[1] = ImpCode;
        return list;

    }


    public static String toSpaCode(String spaCode) {

        int str = spaCode.length();

        char space = " ".charAt(0);
        char l = "L".charAt(0);
        char t = "T".charAt(0);

        //补全不满18位代码
        char[] chars = completion(spaCode);

        //转换类型
        StringBuilder nweSpaCode = new StringBuilder(new String(chars));

        //初始化一个18空格数组
        char[] spaCodeInit = spaCodeInit();


        return getString(str, space, l, t, chars, nweSpaCode, spaCodeInit);

    }

    private static String getString(int str, char space, char l, char t, char[] chars, StringBuilder nweSpaCode, char[] spaCodeInit) {

        if (l != chars[0] && space == (chars[4]) && space == (chars[8]) && space == (chars[12])) {

            replace(0, spaCodeInit, substring(0, 4, nweSpaCode));
            replace(4, spaCodeInit, substring(5, 3, nweSpaCode));
            replace(7, spaCodeInit, substring(9, 3, nweSpaCode));
            replace(10, spaCodeInit, substring(13, 1, nweSpaCode));

            if (space == chars[14 - 1]) {
                replace(11, spaCodeInit, substring(15, 4, nweSpaCode));
            } else {
                replace(11, spaCodeInit, substring(14, 4, nweSpaCode));
            }
            return new String(spaCodeInit).trim();
        } else if (l == chars[0]) {
            if (space == chars[4]) {
                replace(0, spaCodeInit, substring(1, 3, nweSpaCode));
                replace(3, spaCodeInit, substring(5, 3, nweSpaCode));
                replace(6, spaCodeInit, substring(9, 3, nweSpaCode));
                replace(9, spaCodeInit, substring(13, 5, nweSpaCode));
                replace(14, spaCodeInit, " ");
                replace(15, spaCodeInit, "L");
                return new String(spaCodeInit).trim();
            }
            if (space == chars[3]) {
                replace(0, spaCodeInit, substring(0, 3, nweSpaCode));
                replace(3, spaCodeInit, substring(4, 3, nweSpaCode));
                replace(6, spaCodeInit, substring(8, 3, nweSpaCode));
                replace(9, spaCodeInit, substring(12, 2, nweSpaCode));
                replace(11, spaCodeInit, substring(15, 3, nweSpaCode));
                return new String(spaCodeInit).trim();
            }
            if (space != chars[3]) {
                replace(0, spaCodeInit, substring(0, 3, nweSpaCode));
                replace(4, spaCodeInit, substring(3, 3, nweSpaCode));
                replace(8, spaCodeInit, substring(6, 3, nweSpaCode));
                replace(12, spaCodeInit, substring(9, 2, nweSpaCode));
                replace(15, spaCodeInit, substring(11, 3, nweSpaCode));
                return new String(spaCodeInit).trim();

            }
        } else if (l == chars[15] && space == chars[14] && str == 16) {
            replace(0, spaCodeInit, "L");
            replace(1, spaCodeInit, substring(0, 3, nweSpaCode));
            replace(5, spaCodeInit, substring(3, 3, nweSpaCode));
            replace(9, spaCodeInit, substring(6, 3, nweSpaCode));
            replace(13, spaCodeInit, substring(9, 3, nweSpaCode));
            replace(16, spaCodeInit, substring(12, 3, nweSpaCode));
            return new String(spaCodeInit).substring(0, 17).trim();

        } else {
            if (space == chars[3]) {
                replace(0, spaCodeInit, substring(0, 3, nweSpaCode));
                replace(3, spaCodeInit, substring(4, 3, nweSpaCode));
                replace(6, spaCodeInit, substring(8, 3, nweSpaCode));
                //"123 456 789 KKK"
                if (space != chars[12] && space != chars[13] && space != chars[14]) {
                    replace(11, spaCodeInit, substring(12, 3, nweSpaCode));
                } else {
                    replace(1, spaCodeInit, substring(12, 2, nweSpaCode));
                    //"123 456 789 A KK"
                    if (space == chars[13]) {
                        replace(11, spaCodeInit, substring(14, 4, nweSpaCode));
                        //"123 456 789  U K"
                    } else {
                        replace(11, spaCodeInit, substring(15, 3, nweSpaCode));
                    }
                }
                return new String(spaCodeInit).trim();
            } else {
                if (t == chars[0]) {

                } else {
                    replace(0, spaCodeInit, substring(0, 3, nweSpaCode));
                    replace(4, spaCodeInit, substring(3, 3, nweSpaCode));
                    replace(8, spaCodeInit, substring(6, 3, nweSpaCode));
                    //"123456789XUKKK"
                    if (space != chars[10]) {
                        replace(12, spaCodeInit, substring(9, 2, nweSpaCode));
                    } else {
                        //"123456789A KKK"
                        if (space != chars[9]) {
                            replace(12, spaCodeInit, substring(9, 1, nweSpaCode));
                            replace(14, spaCodeInit, substring(11, 4, nweSpaCode));
                            //"123456789  KKK"
                        } else {
                            replace(12, spaCodeInit, substring(11, 3, nweSpaCode));
                        }
                    }
                }
                return new String(spaCodeInit).trim();
            }
        }
        return null;
    }

    /**
     * 初始化18位空字符
     *
     * @return 字符串数组
     */
    private static char[] spaCodeInit() {

        StringBuilder stringBuffer = new StringBuilder();

        for (int i = 0; i < 18; i++) {
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().toCharArray();
    }

    /**
     * 字符串截取
     *
     * @param star   起始位置
     * @param end    解释位置
     * @param string 需要截取的字符串
     * @return 截取后字符串
     */
    private static String substring(int star, int end, StringBuilder string) {

        return string.substring(star, star + end);

    }

    /**
     * 字符串替换
     *
     * @param star   开始位置
     * @param source 原字符串
     * @param target 替换字符串
     */
    private static void replace(int star, char[] source, String target) {

        char[] chars = target.toCharArray();

        for (char aChar : chars) {

            source[star] = aChar;
            star++;

        }

    }

    /**
     * 补全不满18位字符
     *
     * @param spaCode 原字符
     * @return 结果
     */
    private static char[] completion(String spaCode) {

        StringBuilder nweSpaCode = new StringBuilder();

        nweSpaCode.append(spaCode);

        if (spaCode != null && spaCode.length() < 18) {

            while (nweSpaCode.length() < 18 + 1) {
                nweSpaCode.append(" ");
            }
        }
        return nweSpaCode.toString().toCharArray();

    }


}
