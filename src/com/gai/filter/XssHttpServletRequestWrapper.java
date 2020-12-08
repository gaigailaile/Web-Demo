package com.gai.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = this.request.getParameter(name);
        if(StringUtils.isNotBlank(value)){
            System.out.println("原数据:" + value);
            value = StringEscapeUtils.escapeHtml4(value);
            System.out.println("转换之后数据:" + value);
        }
        return value;
    }
}
