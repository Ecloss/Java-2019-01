package other.other2019_03;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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

}
