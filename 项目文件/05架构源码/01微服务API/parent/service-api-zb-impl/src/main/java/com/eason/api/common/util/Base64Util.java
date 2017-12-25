package com.eason.api.common.util;

import java.io.CharArrayWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * String 工具类
 * 
 * @author eason
 */
public class Base64Util {

	private final static Log logger = LogFactory.getLog(Base64Util.class);

	private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
			.toCharArray();

	public static void main(String[] args) {
		System.out.println(convertToByte(null));
	}

	/**
	 * FunName:convertNickNameToBytes Description:将字符串转换成二进制码的字符串
	 * 
	 * @param:nickName
	 * @return String
	 * @Author:fanchangfei
	 * @Create Date: 2014-7-30
	 */
	public static String convertToByte(String str) {
		try {
			if (StringUtils.isNotBlank(str)) {
				byte[] bs = str.getBytes("UTF-8");
				String result = new sun.misc.BASE64Encoder().encodeBuffer(bs);
				return result;
			}
		} catch (Exception e) {
			logger.error("转为二进制，转码异常", e);
		}
		return null;

	}

	/**
	 * FunName:convertNickNameToString Description:将二进制码的字符串还原成真实的字符串
	 * 
	 * @param:nickName
	 * @return String
	 * @Author:fanchangfei
	 * @Create Date: 2014-7-30
	 */
	public static String convertToString(String str) {
		try {
			if (StringUtils.isNotBlank(str)) {
				byte[] bt;
				bt = new sun.misc.BASE64Decoder().decodeBuffer(str);
				str = new String(bt, "UTF-8");
				return str;
			}
		} catch (IOException e) {
			logger.error("转为字符串，转码异常", e);
		}
		return null;
	}

	public static char[] encode(byte[] content) {
		CharArrayWriter cw = new CharArrayWriter(4 * content.length / 3);

		int idx = 0;

		int x = 0;

		for (int i = 0; i < content.length; ++i) {
			if (idx == 0)
				x = (content[i] & 0xFF) << 16;
			else if (idx == 1)
				x |= (content[i] & 0xFF) << 8;
			else {
				x |= content[i] & 0xFF;
			}

			if (++idx == 3) {
				cw.write(alphabet[(x >> 18)]);
				cw.write(alphabet[(x >> 12 & 0x3F)]);
				cw.write(alphabet[(x >> 6 & 0x3F)]);
				cw.write(alphabet[(x & 0x3F)]);

				idx = 0;
			}
		}

		if (idx == 1) {
			cw.write(alphabet[(x >> 18)]);
			cw.write(alphabet[(x >> 12 & 0x3F)]);
			cw.write(61);
			cw.write(61);
		}

		if (idx == 2) {
			cw.write(alphabet[(x >> 18)]);
			cw.write(alphabet[(x >> 12 & 0x3F)]);
			cw.write(alphabet[(x >> 6 & 0x3F)]);
			cw.write(61);
		}

		return cw.toCharArray();
	}

	public static byte[] decode(char[] message) throws IOException {
		byte[] buff = new byte[4];
		byte[] dest = new byte[message.length];

		int bpos = 0;
		int destpos = 0;

		for (int i = 0; i < message.length; ++i) {
			int c = message[i];

			if ((c != 10) && (c != 13) && (c != 32)) {
				if (c == 9)
					continue;

				if ((c >= 65) && (c <= 90)) {
					buff[(bpos++)] = (byte) (c - 65);
				} else if ((c >= 97) && (c <= 122)) {
					buff[(bpos++)] = (byte) (c - 97 + 26);
				} else if ((c >= 48) && (c <= 57)) {
					buff[(bpos++)] = (byte) (c - 48 + 52);
				} else if (c == 43) {
					buff[(bpos++)] = 62;
				} else if (c == 47) {
					buff[(bpos++)] = 63;
				} else if (c == 61) {
					buff[(bpos++)] = 64;
				} else {
					throw new IOException("Illegal char in base64 code.");
				}

				if (bpos == 4) {
					bpos = 0;

					if (buff[0] == 64)
						break;

					if (buff[1] == 64)
						throw new IOException("Unexpected '=' in base64 code.");

					int v;
					if (buff[2] == 64) {
						v = (buff[0] & 0x3F) << 6 | buff[1] & 0x3F;
						dest[(destpos++)] = (byte) (v >> 4);
						break;
					}
					if (buff[3] == 64) {
						v = (buff[0] & 0x3F) << 12 | (buff[1] & 0x3F) << 6
								| buff[2] & 0x3F;
						dest[(destpos++)] = (byte) (v >> 10);
						dest[(destpos++)] = (byte) (v >> 2);
						break;
					}

					v = (buff[0] & 0x3F) << 18 | (buff[1] & 0x3F) << 12
							| (buff[2] & 0x3F) << 6 | buff[3] & 0x3F;
					dest[(destpos++)] = (byte) (v >> 16);
					dest[(destpos++)] = (byte) (v >> 8);
					dest[(destpos++)] = (byte) v;
				}
			}
		}

		byte[] res = new byte[destpos];
		System.arraycopy(dest, 0, res, 0, destpos);

		return res;
	}
}
