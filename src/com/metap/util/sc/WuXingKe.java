package com.metap.util.sc;

import java.util.List;

import com.metap.util.StringUtil;
import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.FormatUtil;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.Score;
@UIDesc(label="���пΣ�",name="",type=UIType.Spinner)
public class WuXingKe implements IScore{

	private Mountain mt;
	private BaZi bz;
	public WuXingKe(Mountain mt, BaZi bz){
		this.mt = mt;
		this.bz = bz;
	}
	
	public Score getScore() {
		Score score = new Score();
		score.setTitle("���пε÷֣�");
		int s = 100;
		// TODO Auto-generated method stub
		List<String> wxds = FormatUtil.formatWX(mt, bz);
		String[] dsa = {wxds.get(0),wxds.get(1),wxds.get(2),wxds.get(3)};
		String ds = wxds.get(0)+wxds.get(1)+wxds.get(2)+wxds.get(3);
		String guan = "��",sun = "��",xiong = "��", yin = "ӡ";
		
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
			score.getInfo().add("�������������������");
		}
		
		
		
		score.setScore(s);
		return score;
	}
}
