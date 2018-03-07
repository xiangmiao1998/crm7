package com.zking.tag.ui;


import com.zking.util.PageBean;

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = -6650240612580556566L;

	private PageBean pageBean;

	public PageTag() {
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if (null != pageBean) {
				String html = this.convertHTML();
				System.out.println(html);
				JspWriter out = pageContext.getOut();
				out.println(html);
			} else {
				throw new RuntimeException("找不到分页必须的pageBean");
			}
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将pageBean转换成html字符串
	 * 
	 * @return
	 */
	private String convertHTML() {
		StringBuffer bf = new StringBuffer();
		// 1.动态生成表单
		bf.append("<div style='width: 0px;height:0px'>" +
				"<form name='pageBeanForm' action='" + pageBean.getUrl()
				+ "' method='post'>");
		bf.append("<input type='hidden' name='curPage' value=''/>");
		for (Map.Entry<String, String[]> entry : pageBean.getParameterMap()
				.entrySet()) {
			
			String name = entry.getKey();
			String[] values = entry.getValue();
			if ("curPage".equals(name)) {
				continue;
			}
			for (String value : values) {
				bf.append("<input type='hidden' name='" + name + "' value='"
						+ value + "'/>");
				//System.out.println(name);
			}
		}
		bf.append("</form>");
		// 2.动态生成js
		bf.append("<script type='text/javascript'>");
		bf.append("function doSkipPage(curPage){");
		bf.append("document.pageBeanForm.curPage.value=curPage;");
		bf.append("document.pageBeanForm.submit();}");
		bf.append("var maxPageNumber="+pageBean.getMaxPageNumber()+";");
		bf.append("function doGotoPage(){");
		bf.append("var curPage=document.getElementById('gotoPageNumber').value;");
		bf.append("if(!curPage||isNaN(curPage)||parseInt(curPage)<=0||parseInt(curPage)>maxPageNumber){");
		bf.append("alert('页码必须是1~N之间的数字');");
		bf.append("document.getElementById('gotoPageNumber').value='';");
		bf.append("return ;}");
		bf.append("doSkipPage(curPage);");
		bf.append("}</script>");
		
		
		bf.append("</div>");
		
		// 3.动态生成分页按钮
		bf.append("<div style='text-align: right; font-size: 12px;'>");
		bf.append("第<b>" 
				+ pageBean.getCurPage() 
				+ "</b>页，每页<b>"
				+ pageBean.getPageRecord() 
				+ "</b>条记录，共<b>"
				+pageBean.getTotalRecord()
				+"</b>条，共<b>"
				+pageBean.getMaxPageNumber()
				+"</b>页&nbsp;&nbsp;<a href='javascript:doSkipPage(1)'>首页</a>&nbsp;&nbsp;<a href='javascript:doSkipPage("
				+pageBean.getPreviousPageNumber()
				+")'>上一页</a>&nbsp;&nbsp;<a href='javascript:doSkipPage("
				+pageBean.getNextPageNumber()
				+")'>下一页</a>&nbsp;&nbsp;<a href='javascript:doSkipPage("
				+pageBean.getMaxPageNumber()
				+")'>尾页</a>&nbsp;&nbsp;<input id='gotoPageNumber' type='text' style='width:30px; text-align:center;'/>&nbsp;&nbsp;<a href='javascript:doGotoPage()'>GO</a>");
		bf.append("</div>");
		
		return bf.toString();
	}
}
