package com.metap.util.refrect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface UIDesc {

	String label();
	String name();
	UIType type();
	String data() default "";
}


