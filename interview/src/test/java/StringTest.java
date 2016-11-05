//  Created by xubinggui on 05/11/2016.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 

import com.example.string.StringSubject;
import org.junit.Test;

public class StringTest {
    StringSubject stringSubject = new StringSubject();

    @Test public void isAllCharacterDifferent() {
        String source = "abc";
        //boolean dataStructResult = stringSubject.isAllCharacterDifferent(source, true);
        //System.out.printf("using datastruct result %b", dataStructResult);
        //System.out.println();
        //boolean noneDataStructResult = stringSubject.isAllCharacterDifferent(source, false);
        boolean noneDataStructResult = stringSubject.isUniqueChars(source);
        System.out.printf("result %b", noneDataStructResult);
    }

    @Test public void testReverseString() {
        String source = "abcdef";
        String reversedString = stringSubject.reverseString(source);
        System.out.printf("result reversed string %s", reversedString);
        assert reversedString.equals(new StringBuilder(source).reverse().toString());
    }

    @Test public void testPretumation() {
        String string1 = "abc";
        String string2 = "cda";
        assert stringSubject.pretumation(string1, string2);
    }
}
