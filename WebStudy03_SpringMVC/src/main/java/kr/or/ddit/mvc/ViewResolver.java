package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 컨트롤러가 결정한 viewName 으로 해당 view 를 찾고, flow control 방식으로 이동하기 위한 전략.
 *
 */
public interface ViewResolver {
	public void resolveView(String viewName, HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException;
	public default void setPrefix(String prefix) {}
	public default void setSuffix(String suffix) {}
}
