package com.solo.util.mybatis;

public class MybatisUtil {

	/**
	 * 拼接where后面的sql语句
	 * @param spliceType	拼接类型
	 * @param key			属性名
	 * @param value			值
	 * @return
	 */
	public static String spliceSqlAfterWhere(SpliceType spliceType,String key,Object value){

		String sql=null;
		switch (spliceType) {
		case IsNull:
			sql=" "+ key+" IS NULL ";
			break;
		case NotIsNull:
			sql=" "+ key+" IS NOT NULL ";
			break;
		case EqualTo:
			sql=" "+ key+" = '"+value+"'";
			break;
		case NotEqualTo:
			sql=" "+ key+" <> '"+value+"'";
			break;
		case GreaterThan:
			sql=" "+ key+" > '"+value+"'";
			break;
		case GreaterThanOrEqualTo:
			sql=" "+ key+" >= '"+value+"'";
			break;
		case LessThan:
			sql=" "+ key+" < '"+value+"'";
			break;
		case LessThanOrEqualTo:
			sql=" "+ key+" <= '"+value+"'";
			break;
		case Like:
			sql=" "+ key+" LIKE '"+value+"'";
			break;
		case NotLike:
			sql=" "+ key+" NOT LIKE'"+value+"'";
			
			break;
		default:
			break;
		}
		
		return sql;
	}
	
	public  enum SpliceType{
		/**为空**/
		IsNull,
		/**不为空**/
		NotIsNull,
		/**等于**/
		EqualTo,
		/**不等于**/
		NotEqualTo,
		/**大于**/
		GreaterThan,
		/**大于等于**/
		GreaterThanOrEqualTo,
		/**小于**/
		LessThan,
		/**小于等于**/
		LessThanOrEqualTo,
		/**类似**/
		Like,
		/**不类似**/
		NotLike;
	}

	
	
	public static void main(String[] args) {
		
		String str=MybatisUtil.spliceSqlAfterWhere(SpliceType.IsNull, "name","1");
		System.out.println(str);
	}
}
