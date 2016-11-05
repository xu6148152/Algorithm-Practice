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
    @Test
    public void isAllCharacterDifferent() {
        StringSubject stringSubject = new StringSubject();
        String source = "aac";
        //boolean dataStructResult = stringSubject.isAllCharacterDifferent(source, true);
        //System.out.printf("using datastruct result %b", dataStructResult);
        //System.out.println();
        boolean noneDataStructResult = stringSubject.isAllCharacterDifferent(source, false);
        System.out.printf("result %b", noneDataStructResult);
    }
}
