package com.doucome.stockop.biz.core.utils;

import java.io.UnsupportedEncodingException;

/**
 * 字节顺序工具，用于处理java和c兼容
 * 
 * @author langben 2013-6-26
 * 
 */
public class FormatTransfer {
	
	//统一编码
	private static final String CHARSET = "UTF8";

	/**
	 * 将 int转为低字节在前，高字节在后的byte数组
	 * 
	 * @param n
	 *            int
	 * @return byte[]
	 */
	public static byte[] toLH(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}

	/**
	 * 将 int转为高字节在前，低字节在后的byte数组
	 * 
	 * @param n
	 *            int
	 * @return byte[]
	 */
	public static byte[] toHH(int n) {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >> 8 & 0xff);
		b[1] = (byte) (n >> 16 & 0xff);
		b[0] = (byte) (n >> 24 & 0xff);
		return b;
	}

	/**
	 * 将 short转为低字节在前，高字节在后的byte数组
	 * 
	 * @param n
	 *            short
	 * @return byte[]
	 */
	public static byte[] toLH(short n) {
		byte[] b = new byte[2];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		return b;
	}

	/**
	 * 将 short转为高字节在前，低字节在后的byte数组
	 * 
	 * @param n
	 *            short
	 * @return byte[]
	 */
	public static byte[] toHH(short n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) (n >> 8 & 0xff);
		return b;
	}

	/**
	 * 将将int转为高字节在前，低字节在后的byte数组 public static byte[] toHH(int number) { int
	 * temp = number; byte[] b = new byte[4]; for (int i = b.length - 1; i > -1;
	 * i--) { b = new Integer(temp & 0xff).byteValue(); temp = temp >> 8; }
	 * return b; } public static byte[] IntToByteArray(int i) { byte[] abyte0 =
	 * new byte[4]; abyte0[3] = (byte) (0xff & i); abyte0[2] = (byte) ((0xff00 &
	 * i) >> 8); abyte0[1] = (byte) ((0xff0000 & i) >> 16); abyte0[0] = (byte)
	 * ((0xff000000 & i) >> 24); return abyte0; }
	 */

	/**
	 * 将 float转为低字节在前，高字节在后的byte数组
	 */
	public static byte[] toLH(float f) {
		return toLH(Float.floatToRawIntBits(f));
	}

	/**
	 * 将 float转为高字节在前，低字节在后的byte数组
	 */
	public static byte[] toHH(float f) {
		return toHH(Float.floatToRawIntBits(f));
	}

	/**
	 * 将 String转为byte数组
	 */
	public static byte[] stringToBytes(String s, int length) {
		while (s.getBytes().length < length) {
			s += " ";
		}
		try {
			return s.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 将字节数组转换为String
	 * 
	 * @param b
	 *            byte[]
	 * @return String
	 */
	public static String bytesToString(byte[] b) {
		int index = 0;
		while(index < b.length) {
			if(b[index] == 0) {
				break;
			}
			index++;
		}
		byte[] temp = new byte[index];
		System.arraycopy(b, 0, temp, 0, index);
		try {
			return new String(temp,CHARSET);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	/**
	 * 将byte数组转化成String
	 */
	public static String lbytesToString(byte[] b,int maxLen) {
		int index = 0;
		while(index < b.length && index < maxLen) {
			if(b[index] == 0) {
				break;
			}
			index++;
		}
		byte[] temp = new byte[index];
		System.arraycopy(b, 0, temp, 0, index);
		try {
			return new String(temp,CHARSET);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 将byte数组转化成String
	 */
	public static String lbytesToString(byte[] b) {
		return lbytesToString(b,Integer.MAX_VALUE) ;
	}
	/**
	 * 将字符串转换为byte数组
	 * 
	 * @param s
	 *            String
	 * @return byte[]
	 */
	public static byte[] stringToBytes(String s) {
		try {
			return s.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 将高字节数组转换为int
	 * 
	 * @param b
	 *            byte[]
	 * @return int
	 */
	public static int hBytesToInt(byte[] b) {
		int s = 0;
		for (int i = 0; i < 3; i++) {
			if (b[i] >= 0) {
				s = s + b[i];
			} else {
				s = s + 256 + b[i];
			}
			s = s * 256;
		}
		if (b[3] >= 0) {
			s = s + b[3];
		} else {
			s = s + 256 + b[3];
		}
		return s;
	}

	/**
	 * 将低字节数组转换为int
	 * 
	 * @param b
	 *            byte[]
	 * @return int
	 */
	public static int lBytesToInt(byte[] b) {
		int s = 0;
		for (int i = 0; i < 3; i++) {
			if (b[3 - i] >= 0) {
				s = s + b[3 - i];
			} else {
				s = s + 256 + b[3 - i];
			}
			s = s * 256;
		}
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		return s;
	}

	/**
	 * 高字节数组到short的转换
	 * 
	 * @param b
	 *            byte[]
	 * @return short
	 */
	public static short hBytesToShort(byte[] b) {
		int s = 0;
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		s = s * 256;
		if (b[1] >= 0) {
			s = s + b[1];
		} else {
			s = s + 256 + b[1];
		}
		short result = (short) s;
		return result;
	}

	/**
	 * 低字节数组到short的转换
	 * 
	 * @param b
	 *            byte[]
	 * @return short
	 */
	public static short lBytesToShort(byte[] b) {
		int s = 0;
		if (b[1] >= 0) {
			s = s + b[1];
		} else {
			s = s + 256 + b[1];
		}
		s = s * 256;
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		short result = (short) s;
		return result;
	}

	/**
	 * 高字节数组转换为float
	 * 
	 * @param b
	 *            byte[]
	 * @return float
	 */
	public static float hBytesToFloat(byte[] b) {
		int i = 0;
		Float F = new Float(0.0);
		i = ((((b[0] & 0xff) << 8 | (b[1] & 0xff)) << 8) | (b[2] & 0xff)) << 8
				| (b[3] & 0xff);
		return F.intBitsToFloat(i);
	}

	/**
	 * 低字节数组转换为float
	 * 
	 * @param b
	 *            byte[]
	 * @return float
	 */
	public static float lBytesToFloat(byte[] b) {
		int i = 0;
		Float F = new Float(0.0);
		i = ((((b[3] & 0xff) << 8 | (b[2] & 0xff)) << 8) | (b[1] & 0xff)) << 8
				| (b[0] & 0xff);
		return F.intBitsToFloat(i);
	}

	/**
	 * 将 byte数组中的元素倒序排列
	 */
	public static byte[] bytesReverseOrder(byte[] b) {
		return bytesReverseOrder(b , -1) ;
	}
	
	public static byte[] bytesReverseOrder(byte[] b , int length) {
		if(length == -1) {
			length = b.length ;
		}
		int loop = length ;
		if(loop > b.length){
			loop = b.length ;
		}
		byte[] result = new byte[length];
		for (int i = 0; i < loop; i++) {
			result[length - i - 1] = b[i];
		}
		return result;
	}

	/**
	 * 打印byte数组
	 */
	public static void printBytes(byte[] bb) {
		int length = bb.length;
		for (int i = 0; i < length; i++) {
			System.out.print(bb + " ");
		}
		System.out.println("");
	}

	public static void logBytes(byte[] bb) {
		int length = bb.length;
		String out = "";
		for (int i = 0; i < length; i++) {
			out = out + bb + " ";
		}

	}

	/**
	 * 将 int类型的值转换为字节序颠倒过来对应的int值
	 * 
	 * @param i
	 *            int
	 * @return int
	 */
	public static int reverseInt(int i) {
		int result = FormatTransfer.hBytesToInt(FormatTransfer.toLH(i));
		return result;
	}

	/**
	 * 将 short类型的值转换为字节序颠倒过来对应的short值
	 * 
	 * @param s
	 *            short
	 * @return short
	 */
	public static short reverseShort(short s) {
		short result = FormatTransfer.hBytesToShort(FormatTransfer.toLH(s));
		return result;
	}

	/**
	 * 将 float类型的值转换为字节序颠倒过来对应的float值
	 * 
	 * @param f
	 *            float
	 * @return float
	 */
	public static float reverseFloat(float f) {
		float result = FormatTransfer.hBytesToFloat(FormatTransfer.toLH(f));
		return result;
	}

}
