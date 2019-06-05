import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * @Program: King-Admin
 * @Class: Sha256Test
 * @Description:
 * @Author: Eastascend <EastascendWang@gmail.com>
 * @Date: 2019-06-05 17:04
 **/
public class Sha256Test {
    public static void main(String[] args) {
        System.out.println(new Sha256Hash("111111","111111").toHex());
    }
}
