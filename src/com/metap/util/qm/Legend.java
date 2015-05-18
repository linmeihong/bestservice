package com.metap.util.qm;

import java.util.Calendar;

public class Legend {

	public static final String[] LiuYiSanQi = { "戊", "己", "庚", "辛", "壬", "癸", "丁", "丙","乙"};
	public static final String[] JiuXing = {"蓬","芮","冲","辅","禽","心","柱","任","英"};
	public static final String[] BaShen = {"符","蛇","阴","六","白","玄","地","天"};
	public static final String[] BaMen = {"休","生","伤","杜","景","死","惊","开"};
	/**
	 *阳遁歌曰：
	 *冬至惊蛰一七四，小寒二八五同推；
	 *大寒春分三九六，芒种六三九是真；
	 *谷雨小满五二八，立春八五二相随；
	 *立夏清明四一七，九六三从雨水期。
	 *阴遁歌曰：
	 *夏至白露九三六，小暑八二五重逢；
	 *秋分大暑七一四，立秋二五八流通；
	 *霜降小雪五八二，大雪四七一相同；
	 *处暑排来一四七，立冬寒露六九三。
	 */
	public static final int[][] QiJv = {		
		{8,5,2},{9,6,3},{1,7,4},//立春雨水惊蛰
		{3,9,6},{4,1,7},{5,2,8},//春分
		{4,1,7},{5,2,8},{6,3,9},//立夏
		{9,3,6},{8,2,5},{7,1,4},//夏至
		{2,5,8},{1,4,7},{9,3,6},//立秋
		{7,1,4},{6,9,3},{5,8,2},//秋分
		{6,9,3},{5,8,2},{4,7,1},//立冬
		{1,7,4},{2,8,5},{3,9,6},//冬至
	};
	private int[] diPan = new int[9];
	private int[] tianPan = new int[9];
	
	private Calendar cal;
	public Legend(Calendar cal){
		this.cal = cal;
	}
}
