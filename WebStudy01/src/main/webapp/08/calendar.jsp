<%@page import="java.util.Optional"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.Month"%>
<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.ZonedDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String yearP = request.getParameter("year");
	String monthP = request.getParameter("month");
	String localeP = request.getParameter("locale");
	String zoneP = request.getParameter("zone");
	// parsing : 문자열을 특정 타입의 데이터로 변환하는 작업.
	// formatting : 특정 타입의 데이터를 일정 형식의 문자열로 변환하는 작업.
/* 	Locale locale = request.getLocale() ; 
	if(localeP!=null){
		locale = Locale.forLanguageTag(localeP);
	} */
  	Locale locale = Optional.ofNullable(localeP)
		.filter(lp->!lp.isEmpty())
		.map(lp->Locale.forLanguageTag(lp))
		.orElse(request.getLocale());
	
	// ZoneId zone = ZoneId.systemDefault(); //클라이언트 아닌 서버기준 지역 아이디 구하기
	
	//int result = data ?? 34;
	ZoneId zone = Optional.ofNullable(zoneP)
			.filter(zp->!zp.isEmpty())
			.map((zp)->ZoneId.of(zp))
			.orElse(ZoneId.systemDefault());
	ZonedDateTime now = ZonedDateTime.now(zone); //ZoneId기준 현재 시각 구하기
	LocalDate today = LocalDate.from(now); // 현재 시각 기준 현재 날짜 구하기
	YearMonth thisMonth = YearMonth.from(now); //현재 시각 기준 현재 연/월 구하기
	
	if(yearP!=null && monthP!=null){
		try{
			thisMonth = YearMonth.of(Integer.parseInt(yearP),Integer.parseInt(monthP));
		}catch(NumberFormatException e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
			return;
		}
	}
	
	YearMonth prevMonth = thisMonth.minusMonths(1);
	YearMonth nextMonth = thisMonth.plusMonths(1);
	
	FormatStyle FULL = FormatStyle.FULL;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   h4.control{
      color: blue;
      text-decoration: underline;
      cursor: pointer;
   }
</style>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", ()=>{
   calForm.year.value = <%=thisMonth.getYear()%>;
   calForm.month.value = <%=thisMonth.getMonthValue()%>;
   calForm.locale.value = "<%=locale.toLanguageTag()%>";
   calForm.zone.value = "<%=zone.getId()%>";
   
   calForm.addEventListener("change", (e)=>{
	   e.target.form.requestSubmit();
   });
});

document.addEventListener("click", (e)=>{
   if(!e.target.classList.contains("control")) return false;
   let control = e.target;
   let year = control.dataset.year;
   let month = control.dataset.month;
   
   calForm.year.value = year;
   calForm.month.value = month;
   calForm.requestSubmit();
   
   
});


</script>
</head>
<body>
<h4>now : <%=now.format(DateTimeFormatter.ofLocalizedDateTime(FULL).withLocale(locale)) %></h4>
<h4>today : <%=today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale)) %></h4>

<div>
<h4 class="control title" data-year="<%=prevMonth.getYear() %>" data-month="<%=prevMonth.getMonthValue()%>"><%=prevMonth %></h4>
<h4>thisMonth : <%=thisMonth.format(DateTimeFormatter.ofPattern("yyyy, MMMM", locale)) %></h4>
<h4 class="control" data-year="<%=nextMonth.getYear() %>" data-month="<%=nextMonth.getMonthValue()%>"><%=nextMonth %></h4>
</div>
<form id="calForm">
   <input type="number" name="year"/>
   <select name="month">
      <% 
         for(Month single : Month.values()){
            %>
            <option value="<%=single.getValue()%>">
               <%=single.getDisplayName(TextStyle.FULL, locale) %>
            </option>
            <%
         }
      %>
   </select>
   <select name="locale">
   <%
		for(Locale single : Locale.getAvailableLocales()){
			if(single.getDisplayName().isEmpty()) continue;
			%>
 	  	<option value="<%=single.toLanguageTag() %>"><%=single.getDisplayName(single)%></option>
		<%
		}
   %>
   </select>
   <select name="zone">
	 <%
	 	for(String single : ZoneId.getAvailableZoneIds()){
	 		out.println(
	 			String.format("<option value='%s'>%s</option>",single, ZoneId.of(single).getDisplayName(TextStyle.FULL,locale))
	 		);
	 	}
	 %>
   </select>
</form>
</body>
</html>