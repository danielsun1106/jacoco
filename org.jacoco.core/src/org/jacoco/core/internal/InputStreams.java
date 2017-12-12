/*******************************************************************************
 * Copyright (c) 2009, 2017 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Evgeny Mandrikov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utilities for {@link InputStream}s.
 */
public final class InputStreams {

	private InputStreams() {
	}

	/**
	 * Reads all bytes from an input stream into a byte array. The provided
	 * {@link InputStream} is not closed by this method.
	 *
	 * @param is
	 *            the input stream to read from
	 * @return a byte array containing all the bytes from the stream
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static byte[] readFully(final InputStream is) throws IOException {
		final byte[] buf = new byte[1024];
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		while (true) {
			final int r = is.read(buf);
			if (r == -1) {
				break;
			}
			out.write(buf, 0, r);
		}
		return out.toByteArray();
	}

}
