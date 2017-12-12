package com.jiuwu.openoo.common.openapi.utils;

import java.math.BigDecimal;

/**
 * 金额操作工具类
 * @author mazhengzheng
 *
 */
public class AmountUtil {
	
	public static void main(String[] args) {
//		System.out.println(new BigDecimal(0.1).toString());		//0.1000000000000000055511151231257827021181583404541015625
//		System.out.println(new BigDecimal("0.1").toString());	//0.1
//		System.out.println(new Double(0.1).toString());			//0.1
//		System.out.println(new Double(5.85)-new Double(3.21));	//2.6399999999999997
//		System.out.println(AmountUtil.sub(5.85, 3.21));			//2.64
//		System.out.println(new Double(2.64001).toString());
//		System.out.println(Double.toString(2.6400));
		System.out.println(new BigDecimal("-10").scale());
		System.out.println(new BigDecimal(Double.toString(2.6400)).scale());
//		System.out.println(1.0/3.0);
//		System.out.println(new BigDecimal("1").divide(new BigDecimal("3")));
		
//		BigDecimal bd=new BigDecimal(new BigInteger("-5000"),5);
//		System.out.println(bd.toString());
//		bd.setScale(5);
//		
		BigDecimal bd1=new BigDecimal("0.333333330");
		System.out.println(bd1.scale());
		System.out.println(bd1.setScale(7).unscaledValue());
		
//		BigDecimal a=new BigDecimal("99.22500001");
//		System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_UNNECESSARY ).toString());
//		System.out.println(a.setScale(2, BigDecimal.ROUND_UP).toString());
	}
	
	/**
	 * 返回精度
	 * @param amount
	 * @return
	 */
	public static int scale(Double amount){
		return scale(transToBD(amount));
	}
	
	/**
	 * 返回精度
	 * @param amount
	 * @return
	 */
	public static int scale(BigDecimal amount){
		return amount.scale();
	}
	
	/**
	 * Double型数据转换成BigDecimal
	 * @param amount
	 * @return
	 */
	public static BigDecimal transToBD(Double amount){
		return new BigDecimal(Double.toString(amount));
	}
	
	/**
	 * BigDecimal型数据转换成Double(有可能丢失精度)
	 * @param amount
	 * @return
	 */
	public static Double transToD(BigDecimal amount){
		return amount.doubleValue();
	}
	
	/**
	 * 金额相加
	 * @param addend	被加数
	 * @param augend	加数
	 * @return
	 */
	public static Double add(Double augend,Double addend){
		BigDecimal bdAugend=transToBD(augend);
		BigDecimal bdAddend=transToBD(addend);
		
		return transToD(add(bdAugend, bdAddend));
	}
	
	/**
	 * 金额相加
	 * @param addend	被加数
	 * @param augend	加数
	 * @return
	 */
	public static BigDecimal add(BigDecimal augend,Double addend){
		BigDecimal bdAddend=transToBD(addend);
		
		return add(augend,bdAddend);
	}
	
	/**
	 * 金额相加
	 * @param addend	被加数
	 * @param augend	加数
	 * @return
	 */
	public static BigDecimal add(BigDecimal augend,BigDecimal addend){
		return augend.add(addend);
	}
	
	/**
	 * 金额相减
	 * @param minuend		被减数
	 * @param subtrahend	减数
	 * @return
	 */
	public static Double sub(Double minuend,Double subtrahend){
		BigDecimal bdMinuend=transToBD(minuend);
		BigDecimal bdSubtrahend=transToBD(subtrahend);
		
		return transToD(sub(bdMinuend, bdSubtrahend));
	}
	
	/**
	 * 金额相减
	 * @param minuend		被减数
	 * @param subtrahend	减数
	 * @return
	 */
	public static BigDecimal sub(Double minuend,BigDecimal subtrahend){
		BigDecimal bdMinuend=transToBD(minuend);
		
		return sub(bdMinuend, subtrahend);
	}
	
	/**
	 * 金额相减
	 * @param minuend		被减数
	 * @param subtrahend	减数
	 * @return
	 */
	public static BigDecimal sub(BigDecimal minuend,Double subtrahend){
		BigDecimal bdSubtrahend=transToBD(subtrahend);
		
		return sub(minuend, bdSubtrahend);
	}
	
	/**
	 * 金额相减
	 * @param minuend		被减数
	 * @param subtrahend	减数
	 * @return
	 */
	public static BigDecimal sub(BigDecimal minuend,BigDecimal subtrahend){
		return minuend.subtract(subtrahend);
	}
	
	/**
	 * 金额相乘
	 * @param multiplicand	被乘数
	 * @param multiplier	乘数
	 * @return
	 */
	public static BigDecimal multiply(Double multiplicand,Double multiplier){
		BigDecimal bdMultiplicand=transToBD(multiplicand);
		BigDecimal bdMultiplier=transToBD(multiplier);
		
		return multiply(bdMultiplicand,bdMultiplier);
	}
	
	/**
	 * 金额相乘
	 * @param multiplicand	被乘数
	 * @param multiplier	乘数
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal multiplicand,Double multiplier){
		BigDecimal bdMultiplier=transToBD(multiplier);
		
		return multiply(multiplicand, bdMultiplier);
	}
	
	/**
	 * 金额相乘
	 * @param multiplicand	被乘数
	 * @param multiplier	乘数
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal multiplicand,BigDecimal multiplier){
		return multiplicand.multiply(multiplier);
	}
	
	/**
	 * 对数据进行舍入
	 * @param amount	
	 * @param scale			精确位数
	 * @param roundMode		舍入方式(与BigDecimal.ROUND_的舍入方式对应)
	 * 						0:非0舍弃加1,1:截断,4:>=50...四舍五入,5:>50...四舍五入
	 * @return
	 */
	public static Double round(Double amount,int scale,int roundMode){
		BigDecimal bdAmount=transToBD(amount);
		return transToD(round(bdAmount, scale, roundMode));
	}
	
	/**
	 * 对数据进行舍入
	 * @param amount	
	 * @param scale			精确位数
	 * @param roundMode		舍入方式(与BigDecimal.ROUND_的舍入方式对应)
	 * 						0:非0舍弃加1,1:截断,4:>=50...四舍五入,5:>50...四舍五入
	 * @return
	 */
	public static BigDecimal round(BigDecimal amount,int scale,int roundMode){
		return amount.setScale(scale, roundMode);
	}
	
	
	/**
	 * 金额比较
	 * @param src	源
	 * @param val	目标
	 * @return
	 */
	public static int compareTo(Double src,Double val){
		BigDecimal bdSrc=transToBD(src);
		BigDecimal bdVal=transToBD(val);
		
		return bdSrc.compareTo(bdVal);
	}
	
	/**
	 * 金额比较
	 * @param src	源
	 * @param val	目标
	 * @return
	 */
	public static int compareTo(BigDecimal src,Double val){
		BigDecimal bdVal=transToBD(val);
		
		return src.compareTo(bdVal);
	}
	
	/**
	 * 金额比较
	 * @param src	源
	 * @param val	目标
	 * @return
	 */
	public static int compareTo(BigDecimal src,BigDecimal val){
		return src.compareTo(val);
	}
}
