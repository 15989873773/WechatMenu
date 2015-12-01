package wechat.main;
import wechat.pojo.AccessToken;  
import wechat.pojo.Button;  
import wechat.pojo.CommonButton;  
import wechat.pojo.ComplexButton;  
import wechat.pojo.Menu;
import wechat.pojo.ViewButton;
import wechat.util.WechatUtil;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
/** 
 * 菜单管理器类 
 *  
 */  
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
  
    public static void main(String[] args) {  
        // 第三方用户唯一凭证  
        String appId = "0000";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "0000";  
  
        // 调用接口获取access_token  
        AccessToken at = WechatUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // 调用接口创建菜单  
            int result = WechatUtil.createMenu(getMenu(), at.getToken());  
  
            // 判断菜单创建结果  
            if (0 == result)  
                log.info("菜单创建成功！");  
            else  
                log.info("菜单创建失败，错误码：" + result);  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
        CommonButton btn11 = new CommonButton();  
        btn11.setName("员工认证");  
        btn11.setType("click");  
        btn11.setKey("11");  
  
        CommonButton btn12 = new CommonButton();  
        btn12.setName("查询");  
        btn12.setType("click");  
        btn12.setKey("12");  
  
        ViewButton btn13 = new ViewButton();  
        btn13.setName("View示例");  
        btn13.setType("view");  
        btn13.setUrl("http://baidu.com");  
        
        CommonButton btn21 = new CommonButton();  
        btn21.setName("预约陪诊");  
        btn21.setType("click");  
        btn21.setKey("21");  
  
        CommonButton btn31 = new CommonButton();  
        btn31.setName("反馈意见");  
        btn31.setType("click");  
        btn31.setKey("31");  
  
        ComplexButton mainBtn1 = new ComplexButton();  
        mainBtn1.setName("云康伙伴");  
        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13 }); 
        
  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { mainBtn1, btn21, btn31});  
  
        return menu;  
    }  
} 
