<%@page import="com.newlecture.jspweb.entity.NoticeView"%>
<%@page import="com.newlecture.jspweb.jdbc.jdbcNoticeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.jspweb.dao.NoticeDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%			
NoticeDao noticeDao = new jdbcNoticeDao();
List<NoticeView> list = noticeDao.getList();
%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<script>

/* var exam = {};
exam.kor=20;
exam.eng=30;
 */
/* var list = [
	{kor:30, eng:40, math:60},{kor:30, eng:40, math:60},{kor:30, eng:40, math:100}
];
 
 alert(list[2].math) */
	
</script>
</head>
<body>
	<!-- 제목 목록 표 문장 폼 -->
	<header id="header">
		<div class="root-container">
			<h1 id="logo">
				<img src="../../images/logo.png" alt="뉴렉처 온라인" />
			</h1>
			<section>
				<h1 class="hidden">헤더</h1>

				<nav class="hor-menu main-menu first-pad-none">
					<h1 class="hidden">메인메뉴</h1>
					<ul>
						<li><a href="">학습가이드</a></li>
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>

				<section id="lecture-search-form">
					<h1 class="hidden">강좌검색 폼</h1>
					<form>
						<fieldset>
							<label>과정검색</label> 
							<input type="text" /> <input class="btn btn-search btn-image" type="submit"value="검색" />
						</fieldset>
					</form>
				</section>

				<nav class="hor-menu member-menu first-pad-none">
					<h1 class="hidden">회원 메뉴</h1>
					<ul>
						<li>HOME</li>
						<li>로그인</li>
						<li>회원가입</li>
					</ul>
				</nav>

				<nav id="" class="hor-menu quick-menu">
					<h1 class="hidden">간편 메뉴</h1>
					<ul>
						<li><a href=""><img src="../../images/txt-customer.png"
								alt="마이페이지" /></a></li>
						<li><a href=""><img src="../../images/txt-mypage.png"
								alt="고객센터" /></a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>

	<!-- Visual 부분 시작 -->
	<div id="visual">
		<div class="root-container"></div>
	</div>

	<div id="body">
		<div class="root-container">
			<!-- 따옴표 안에 clear-fix -->
			<!-- aside 시작------------------------------------------------------------------------------------------------------------- -->

			<aside class="aside">
				<h1 class="aside-title">고객센터</h1>
				<nav class="aside-menu aside-title">
					<h1 class="hidden">고객센터 메뉴</h1>
					<ul>
						<li><a href="">공지사항</a></li>
						<li><a href="">1:1고객문의</a></li>
						<li><a href="">학습안내</a></li>
					</ul>
				</nav>

				<nav>
					<h1 class="title aside-title">추천 사이트</h1>
					<ul>
						<li>앤서이즈</li>
						<li>W3C</li>
						<li>마이크로소프트</li>
					</ul>
				</nav>
			</aside>

			<!-- main 시작-------------------------------------------------------------------------------------------------------------- -->

			<main class="main">
				<section>
				<h1 class="main-title" class="hidden">공지사항</h1>
					<h1 class="hidden">경로</h1>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</section>

				<section>
					<h1 class="hidden">공지사항 검색 폼</h1>
					<form>
						<label>검색어</label><input type="text" /><input class="btn btn-text btn-default" type="submit"
							value="검색" />
					</form>
				</section>

				<section>
					<h1 class="hidden">공지사항 검색 목록</h1>
					<table class="table">
					<thead>
						<tr>
							<td class="width-s">번호</td>
							<td class="width-ex">제목</td>
							<td class="width-m">작성자</td>
							<td class="width-m">작성일</td>
							<td class="width-s">조회수</td>
							<td class="width-m">작성자</td>
							<td class="width-s">댓글수</td>
						</tr>
					</thead>
					<tbody>
							<%for(NoticeView n : list){ %>
						<tr>
							<td><%=n.getId()%></td>
							<td class="align-left text-indent text-ellipsis"><a href=""><span class="color-notice"><%=n.getTitle()%></span></a></td>
							<td><%=n.getWriterId()%></td>
							<td><%=n.getRegDate()%></td>
							<td><%=n.getHit()%></td>
							<td><%=n.getWriterName()%></td>
							<td><%=n.getCommentCnt()%></td>
						</tr>
							<%} %> 
						
					</tbody>
					</table>
				</section>
				
-----------------------------------------------------------------------------------------------------------------------------------------
<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------- -->
				<section>
					<h1 class="hidden">공지사항 검색 목록</h1>
					<div class="table">
						<div class="thead">
							<div class="tr">
								<div class="width-s td">번호</div>
								<div class="width-ex td">제목</div>
								<div class="width-m td">작성자</div>
								<div class="width-m td">작성일</div>
								<div class="width-s td">조회수</div>
								<div class="width-s td">작성자</div>
								<div class="width-s td">댓글수</div>
							</div>
						</div>
						
						<div class="tbody">
								<%for(NoticeView n : list){ %>
							<div class="tr">
								<div class="td width-s td"><%=n.getId()%></div>
								<div class="td  width-ex align-left text-indent text-ellipsis"><a href=""><span class="color-notice"><%=n.getTitle()%></span></a></div>
								<div class="td width-m"><%=n.getWriterId()%></div>
								<div class="td width-m"><%=n.getRegDate()%></div>
								<div class="td width-s"><%=n.getHit()%></div>
								<div class="td width-s"><%=n.getWriterName()%></div>
								<div class="td width-s"><%=n.getCommentCnt()%></div>
							</div>
								<%} %>
						</div>
					</div>
				</section>


				<div>1/1 pages</div>
				<div>
					<a href="reg" class="button default-button">글쓰기</a>
					<a href="reg" class="button cancel-button">취소</a>
				</div>
				이전1다음
			</main>
		</div>
	</div>

	<!-- footer 시작------------------------------------------------------------------------------------------------------------ -->

	<footer id="footer">
		<div class="root-container">회사정보 주소서울특별시 마포구 토정로35길 11, 5층
			266호(용강동, 인우빌딩)관리자메일admin@newlecture.com사업자 등록번호132-18-46763 통신 판매업
			신고제 2013-서울강동-0969 호 상호뉴렉처대표박용우전화번호070-4206-4084 [죄송합니다. 당분간 문의내용은
			고개센터 메뉴에서 1:1 문의를 이용해주시기 바랍니다] Copyright ⓒ newlecture.com 2012-2014
			All Right Reserved. Contact admin@newlecture.com for more information
		</div>
	</footer>

</body>
</html>