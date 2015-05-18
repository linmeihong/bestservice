package com.metap.util.sc;

import java.util.List;

import com.metap.util.StringUtil;
import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.FormatUtil;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.Score;
@UIDesc(label="�����пΣ�",name="",type=UIType.Spinner)
public class DouShouKe implements IScore{

	private Mountain mt;
	private BaZi bz;
	public DouShouKe(Mountain mt, BaZi bz){
		this.mt = mt;
		this.bz = bz;
	}
	
	public Score getScore() {
		Score score = new Score();
		score.setTitle("���׿ε÷֣�");
		int s = 100;
		// TODO Auto-generated method stub
		List<String> wxds = FormatUtil.formatDS(mt, bz);
		String[] dsa = {wxds.get(0),wxds.get(1),wxds.get(2),wxds.get(3)};
		String ds = wxds.get(0)+wxds.get(1)+wxds.get(2)+wxds.get(3);
		String guan = "��",sun = "��",xiong = "��", yin = "ӡ",cai = "��";
		
		if(dsa[2].equals(guan) || dsa[3].equals(guan)){
			s = 0;
			score.getInfo().add("��ʱ�й���");
		}
		
		if(StringUtil.findCount(ds, guan) > 1){
			s = 0;
			score.getInfo().add("������������");
		}
		
		int sunCount = StringUtil.findCount(ds, sun);
		if(sunCount > 2){
			s = 0;
			score.getInfo().add("������������");
		}
		
		int caiCount = StringUtil.findCount(ds, cai);
		if(caiCount > 2){
			s = 0;
			score.getInfo().add("������������");
		}
		
		if(dsa[2].equals(sun) && dsa[3].equals(sun)){
			s= 0;
			score.getInfo().add("��ʱ��������");
		}
		
		score.setScore(s);
		return score;
	}
	
	
	public static void main(String[] args){
		String str = "33kjfk3dkdfk3d";

		System.out.println(StringUtil.findCount(str, "3"));
		
		System.out.println(str.indexOf("3", 1));
		System.out.println(str.indexOf("3", 2));
	}
}
