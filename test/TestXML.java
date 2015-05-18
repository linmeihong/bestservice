import com.best.service.WechatProcess;


public class TestXML {

	public static void main(String[] args){
		String xml = "<xml><ToUserName><![CDATA[gh_70f38da34337]]></ToUserName><FromUserName><![CDATA[oAMP1s7Uj_bKjF4UwRhnrJp1T-HE]]></FromUserName><CreateTime>1431842770</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[hello]]></Content><MsgId>6149717870370122995</MsgId></xml>";
		System.out.println(new WechatProcess().processWechatMag(xml));
	}
}
