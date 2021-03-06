/*******************************************************************************
 *  Copyright © 2012-2015 eBay Software Foundation
 *  This program is dual licensed under the MIT and Apache 2.0 licenses.
 *  Please see LICENSE for more information.
 *******************************************************************************/
package com.ebay.jetstream.event.processor;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NamedBean;

import com.ebay.jetstream.xmlser.XSerializable;


public abstract class QueuedEventProcessorConfiguration implements 
		NamedBean, BeanNameAware, XSerializable, InitializingBean {

	public static final int DEFAULT_THREAD_POOL_SIZE = 1;
	public static final int DEFAULT_QUEUE_SIZE_LIMIT = 60000; 
	
	private static final long serialVersionUID = 7914085020428668538L;

	private int m_threadPoolSize = DEFAULT_THREAD_POOL_SIZE;
	private int m_queueSizeLimit = DEFAULT_QUEUE_SIZE_LIMIT;
	private String m_strBeanName;
	private boolean m_bIsSyncMode;
	private volatile boolean m_bPropegateEventsAfterError; // If there is an exception thrown by any of the sink, drop subsequent events generated by EPL for the incoming event.

	

	@Override
	public String getBeanName() {
		return m_strBeanName;
	}

	public int getQueueSizeLimit() {
		return m_queueSizeLimit;
	}

	public int getThreadPoolSize() {
		return m_threadPoolSize;
	}

	public boolean isSyncMode() {
		return m_bIsSyncMode;
	}
	
	public boolean isPropagateEventOnFailure() {
		return m_bPropegateEventsAfterError;
	}
	
	public void setPropagateEventOnFailure(boolean bPropegateEventsAfterError) {
		m_bPropegateEventsAfterError = bPropegateEventsAfterError;
	}
	
	@Override
	public void setBeanName(String strBeanName) {
		m_strBeanName = strBeanName;
	}

	public void setQueueSizeLimit(int queueSizeLimit) {
		m_queueSizeLimit = queueSizeLimit;
	}

	public void setSyncMode(boolean syncMode) {
		m_bIsSyncMode = syncMode;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		m_threadPoolSize = threadPoolSize;
	}
}
