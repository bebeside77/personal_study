/*
 * @(#)WeekOfMonth.class 1.0.0 2018.02.08
 *
 * Copyright 2018 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.date;

import java.util.Calendar;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
@Slf4j
public class WeekOfMonth {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, Calendar.JUNE, 27);

		log.debug("week : {}", calendar.get(Calendar.WEEK_OF_MONTH)); // 월의 몇번째 주인지
		log.debug("dayOfWeekInMonth : {}", calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // 월의 몇번째 요일인지
	}
}
