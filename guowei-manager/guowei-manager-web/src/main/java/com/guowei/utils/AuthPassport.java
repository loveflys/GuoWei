package com.guowei.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * 权限控制
 * 1: 普通用户
 * 2: 普通员工
 * 3： 管理员
 * 4： 超级管理员
 * 5： 第三方合作商 - 管理员
 * 6： 第三方合作商 - 普通员工
 * @author 陈安一
 *
 */
public @interface AuthPassport {
	/**
	 * 1: 普通用户
	 * 2: 普通员工
	 * 3： 管理员
	 * 4： 超级管理员
	 * 5： 第三方合作商 - 管理员
	 * 6： 第三方合作商 - 普通员工
	 * @return
	 */
    int level() default 1;
}