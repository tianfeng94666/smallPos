package com.example.tianfeng.smallpos.utils;

import java.text.DecimalFormat;

public class NumberFormatUtil {
	/**
	 * Double
	 * 
	 * @param str
	 * @return
	 */
	public static double ParseDouble(String str) {
		if (null == str || "".equals(str) || "null".equals(str)) {
			return 0.0;
		}
		return Double.parseDouble(str);
	}

	/**
	 * int
	 * 
	 * @param str
	 * @return
	 */
	public static int ParseInt(String str) {
		if (null == str || "".equals(str) || "null".equals(str) || "false".equals(str)) {
			return 0;
		}
		return Integer.parseInt(str);
	}

	/**
	 * double
	 * 
	 * @param str
	 * @return
	 */
	public static double formatToDouble1(double num) {
		DecimalFormat df = new DecimalFormat("#.0");
		String str = df.format(num);
		return Double.parseDouble(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static double formatToDouble1(String num) {
		if (null == num || "".equals(num) || "null".equals(num)) {
			return 0.0;
		}
		DecimalFormat df = new DecimalFormat("#.0");
		String str = df.format(ParseDouble(num));
		return Double.parseDouble(str);
	}

	/**
	 * double
	 * 
	 * @param str
	 * @return
	 */
	public static double formatToDouble2(double num) {
		DecimalFormat df = new DecimalFormat("#.00");
		String str = df.format(num);
		return Double.parseDouble(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static double formatToDouble2(String num) {
		if (null == num || "".equals(num) || "null".equals(num)) {
			return 0.0;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		String str = df.format(ParseDouble(num));
		return Double.parseDouble(str);
	}

}
