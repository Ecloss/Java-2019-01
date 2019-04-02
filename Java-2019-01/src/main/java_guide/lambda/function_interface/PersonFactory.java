package lambda.function_interface;

import lambda.bo.PersonBo;

/**
 * 对象接口
 *
 * @author 余修文
 * @date 2019/4/2 17:02
 */
public interface PersonFactory<X extends PersonBo> {

    X create(String firstName, String lastName);

}
