
/*
 * Copyright (C) 2015 Synchronoss Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.synchronoss.cloud.nio.multipart;

/**
 * <p>
 *     Multipart context containing:
 *     <ul>
 *         <li>Content Type</li>
 *         <li>Content Length</li>
 *         <li>Character Encoding</li>
 *     </ul>
 * <p/>
 *
 * @author Silvano Riz.
 */
public class MultipartContext {

    private final String contentType;
    private final int contentLength;
    private final String charEncoding;

    /**
     * <p>
     *     Constructor
     * </p>
     * @param contentType The content type of the request
     * @param contentLength The content length of the request
     * @param charEncoding The request char encoding.
     */
    public MultipartContext(final String contentType, final int contentLength, final String charEncoding) {

        if (!MultipartUtils.isMultipart(contentType)){
            throw new IllegalStateException("Invalid content type '" + contentType + "'. Expected a multipart request");
        }

        this.contentType = contentType;
        this.contentLength = contentLength;
        this.charEncoding = charEncoding;
    }

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public String getCharEncoding() {
        return charEncoding;
    }

    @Override
    public String toString() {
        return "MultipartContext{" +
                "contentType='" + contentType + '\'' +
                ", contentLength=" + contentLength +
                ", charEncoding='" + charEncoding + '\'' +
                '}';
    }
}