package com.mindtree.ShoppingCart.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author M1056333
 *
 */
public class ShoppingCartServiceException extends ShoppingCartException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#fillInStackTrace()
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		// TODO Auto-generated method stub
		return super.fillInStackTrace();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#getCause()
	 */
	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#getLocalizedMessage()
	 */
	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#getMessage()
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#getStackTrace()
	 */
	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO Auto-generated method stub
		return super.getStackTrace();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#initCause(java.lang.Throwable)
	 */
	@Override
	public synchronized Throwable initCause(Throwable cause) {
		// TODO Auto-generated method stub
		return super.initCause(cause);
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#printStackTrace()
	 */
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#printStackTrace(java.io.PrintStream)
	 */
	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#printStackTrace(java.io.PrintWriter)
	 */
	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#setStackTrace(java.lang.StackTraceElement[])
	 */
	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		// TODO Auto-generated method stub
		super.setStackTrace(stackTrace);
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	/* (non-Javadoc)
	 * @see com.mindtree.ShoppingCart.exception.ShoppingCartException#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/**
	 * 
	 */
	public ShoppingCartServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ShoppingCartServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ShoppingCartServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ShoppingCartServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ShoppingCartServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
