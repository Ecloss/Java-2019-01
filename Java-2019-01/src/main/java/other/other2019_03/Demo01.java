package other.other2019_03;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试Collectors.joning
 *
 * @author 余修文
 * @date 2019/3/18 9:16
 */
public class Demo01 {

    @Test
    public void demo02() {
        String str = "按揭业务-按揭电销-A类名单,按揭业务-按揭电销-B类名单,按揭业务-按揭电销-C类名单";
        String str1 = "按揭业务-按揭电销-C类名单,按揭业务-按揭电销-B类名单,按揭业务-按揭电销-A类名单";

        String[] strs = str.split(",");
        String[] strs1 = str1.split(",");
        Boolean isSame = checkSameDifferent(Arrays.asList(strs), Arrays.asList(strs1));
        if (isSame) {
            System.out.println("两个类型相同！");
        } else {
            System.out.println("两个类型不相同！");
        }
    }

    public Boolean checkSameDifferent(List<String> list, List<String> list1) {
        if (list.size() != list1.size()) {
            return false;
        }
        Boolean isSame = list.stream().sorted().collect(Collectors.joining()).equals(list1.stream().sorted().collect(Collectors.joining()));
        return isSame;
    }

    @Test
    public void demo03() {
        String str = getType(1, null, null);
        String str1 = getType(1, 1, null);
        String str2 = getType(null, 2, 1);
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void demo04() {
        String str = "aa";
        System.out.println(StringUtils.isBlank(str) ? null : 123);
    }

    public String getType(Integer businessType, Integer businessProperty, Integer nameListType) {
        String type = "";
        if (businessType != null && businessType != 0) {
            type = type + BusinessType.getByValue(businessType).getContent();
            if (businessProperty != null && businessProperty != 0) {
                type = type +  "-" + BusinessProperty.getByValue(businessProperty).getContent();
                if (nameListType != null && nameListType != 0) {
                    type = type + "-" + NameListType.getByValue(nameListType).getContent();
                }
            }
        }
        return type.toString();
    }

    @Test
    public void demo05() {
        Integer i = null;
        System.out.println(1 == i);
    }

    @Test
    public void demo06() {
        System.out.println(getRandomID());
    }

    public static String getRandomID() {
        String id = "";
        // 随机生成省、自治区、直辖市代码 1-2
        String provinces[] = { "11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
                "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
                "63", "64", "65", "71", "81", "82" };
        String province = provinces[new Random().nextInt(provinces.length - 1)];
        // 随机生成地级市、盟、自治州代码 3-4
        String citys[] = { "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "21", "22", "23", "24", "25", "26", "27", "28" };
        String city = citys[new Random().nextInt(citys.length - 1)];
        // 随机生成县、县级市、区代码 5-6
        String countys[] = { "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" };
        String county = countys[new Random().nextInt(countys.length - 1)];
        // 随机生成出生年月 7-14
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE,
                date.get(Calendar.DATE) - new Random().nextInt(365 * 100));
        String birth = dft.format(date.getTime());
        // 随机生成顺序号 15-17
        String no = new Random().nextInt(999) + "";
        // 随机生成校验码 18
        String checks[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "X" };
        String check = checks[new Random().nextInt(checks.length - 1)];
        // 拼接身份证号码
        id = province + city + county + birth + no + check;

        return id;
    }

}
