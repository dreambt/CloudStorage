package cn.im47.cloud.storage.utilities;

import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Copyright 2004-2012 ICEsoft Technologies Canada Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
public class RangingResourceHttpRequestHandler extends ResourceHttpRequestHandler {
    private static Logger log = Logger.getLogger(RangingResourceHttpRequestHandler.class.getName());
    private static String RANGE = "Range";
    private static String BYTES_PREFIX = "bytes=";
    private static String CONTENT_RANGE = "Content-Range";

    @Inject
    private WebApplicationContext context;

    @PostConstruct
    private void init() {
        List<Resource> locations = new ArrayList<Resource>(1);
        locations.add(context.getResource("/resources/"));
        setLocations(locations);
    }

    public void handleRequest(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String requestPath = requestURI.substring(contextPath.length());

        //locations are set up for delegation if desired
        /*
        if (!requestPath.startsWith("/media/"))  {
            super.handleRequest(request, response);
        }
        */

        boolean useRanges = false;
        int rangeStart = 0;
        int rangeEnd = 0;

        String rangeHeader = request.getHeader(RANGE);
        if (null != rangeHeader) {
            try {
                if (rangeHeader.startsWith(BYTES_PREFIX)) {
                    String range = rangeHeader
                            .substring(BYTES_PREFIX.length());
                    int splitIndex = range.indexOf("-");
                    String startString = range.substring(0, splitIndex);
                    String endString = range.substring(splitIndex + 1);
                    rangeStart = Integer.parseInt(startString);
                    rangeEnd = Integer.parseInt(endString);
                    useRanges = true;
                }
            } catch (Exception e) {
                useRanges = false;
                if (log.isLoggable(Level.FINE)) {
                    log.fine("Unable to decode range header " + rangeHeader);
                }
            }
        }

        response.setContentType(context.getServletContext()
                .getMimeType(requestPath));
        response.setHeader("Accept-Ranges", "bytes");

        Resource theResource = context.getResource(requestPath);
        String contentLength = Long.toString(theResource.contentLength());
        InputStream in = context.getResource(requestPath).getInputStream();
        OutputStream out = response.getOutputStream();

        if (useRanges) {
            response.setHeader(CONTENT_RANGE,
                    "bytes " + rangeStart + "-" + rangeEnd + "/" +
                            contentLength);
            response.setContentLength(1 + rangeEnd - rangeStart);
            copyStream(in, out, rangeStart, rangeEnd);
        } else {
            copyStream(in, out);
        }
    }

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[1000];
        int l = 1;
        while (l > 0) {
            l = in.read(buf);
            if (l > 0) {
                out.write(buf, 0, l);
            }
        }
    }

    public static int copyStream(InputStream in, OutputStream out,
                                 int start, int end) throws IOException {
        long skipped = in.skip((long) start);
        if (start != skipped) {
            throw new IOException("copyStream failed range start " + start);
        }
        byte[] buf = new byte[1000];
        int pos = start - 1;
        int count = 0;
        int l = 1;
        while (l > 0) {
            l = in.read(buf);
            if (l > 0) {
                pos = pos + l;
                if (pos > end) {
                    l = l - (pos - end);
                    out.write(buf, 0, l);
                    count += l;
                    break;
                }
                out.write(buf, 0, l);
                count += l;
            }
        }
        return count;
    }

}
