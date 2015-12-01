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
 * �˵��������� 
 *  
 */  
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
  
    public static void main(String[] args) {  
        // �������û�Ψһƾ֤  
        String appId = "0000";  
        // �������û�Ψһƾ֤��Կ  
        String appSecret = "0000";  
  
        // ���ýӿڻ�ȡaccess_token  
        AccessToken at = WechatUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // ���ýӿڴ����˵�  
            int result = WechatUtil.createMenu(getMenu(), at.getToken());  
  
            // �жϲ˵��������  
            if (0 == result)  
                log.info("�˵������ɹ���");  
            else  
                log.info("�˵�����ʧ�ܣ������룺" + result);  
        }  
    }  
  
    /** 
     * ��װ�˵����� 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
        CommonButton btn11 = new CommonButton();  
        btn11.setName("Ա����֤");  
        btn11.setType("click");  
        btn11.setKey("11");  
  
        CommonButton btn12 = new CommonButton();  
        btn12.setName("��ѯ");  
        btn12.setType("click");  
        btn12.setKey("12");  
  
        ViewButton btn13 = new ViewButton();  
        btn13.setName("Viewʾ��");  
        btn13.setType("view");  
        btn13.setUrl("http://baidu.com");  
        
        CommonButton btn21 = new CommonButton();  
        btn21.setName("ԤԼ����");  
        btn21.setType("click");  
        btn21.setKey("21");  
  
        CommonButton btn31 = new CommonButton();  
        btn31.setName("�������");  
        btn31.setType("click");  
        btn31.setKey("31");  
  
        ComplexButton mainBtn1 = new ComplexButton();  
        mainBtn1.setName("�ƿ����");  
        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13 }); 
        
  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { mainBtn1, btn21, btn31});  
  
        return menu;  
    }  
} 
