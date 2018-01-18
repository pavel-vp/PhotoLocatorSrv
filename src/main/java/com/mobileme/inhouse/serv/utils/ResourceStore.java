package com.mobileme.inhouse.serv.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;

public class ResourceStore
{
	private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

	private static boolean isCacheEnabled = true;

	public static void setCacheEnabled(boolean cacheEnabled) {
		isCacheEnabled = cacheEnabled;
	}
	
	public static String getQuery(final String path)
	{
		String res = getResource("sql/" + path);
		
		if (res == null)
			throw new RuntimeException("SQL query template not found " + path);
		
		return res;
	}
	
	public static String getResource(final String path)
	{
		if(!isCacheEnabled){
			return readStringFromResource(path);
		}

		String res = map.get(path);
		if (res == null)
		{
			res = readStringFromResource(path);
			
			if (res == null)
				return null;
			
			String anotherVal = map.putIfAbsent(path, res);
			if (anotherVal != null)
			{
				// Some other thread "won"
				res = anotherVal;
			}
			else
			{
				// This thread was the winner
			}
		}
		
		return res;
	}
	
	private static String readStringFromResource(final String path)
	{
		final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		try
		{
			if (stream == null)
				return null;
			
			return IOUtils.toString(stream);
		}
		catch (final IOException e)
		{
			throw new IllegalStateException(e);
		}
		catch (final NullPointerException e)
		{
			throw new IllegalStateException(e);
		}
		finally
		{
			IOUtils.closeQuietly(stream);
		}
	}
}
