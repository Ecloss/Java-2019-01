package lambda.bo;

/**
 * Lambda引用
 *
 * @author 余修文
 * @date 2019/4/2 17:00
 */
public class PersonBo {
    String firstName;
    String lastName;

    public PersonBo() {
    }

    public PersonBo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonBo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}