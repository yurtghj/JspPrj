<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header">
	<div>
		<img class="hamburger-button"
			src="../../../images/ic_menu_black_24dp_1x.png" />
	</div>
	<div class="content-container">
		<!-- ---------------------------<header>--------------------------------------- -->

		<h1 id="logo">
			<a href="../../../index.jsp"> 
				<img src="../../../images/logo.png" alt="뉴렉처 온라인" />
				
			</a>
		</h1>

		<section>
			<h1 class="hidden">헤더</h1>

			<nav id="main-menu">
				<h1>메인메뉴</h1>
				<ul>
					<li><a href="/guide">학습가이드</a></li>
					
					<li><a href="/course">강좌선택</a></li>
					<li><a href="../../../answeris/index.jsp">AnswerIs</a></li>					
				</ul>
			</nav>

			<div class="sub-menu">
								
				<section id="search-form">
					<h1>강좌검색 폼</h1>
					<form>
						<fieldset>
							<legend>과정검색필드</legend>
							<label>과정검색</label> <input type="text" value="" /><input
								type="submit" value="검색" />
						</fieldset>
					</form>
				</section>
				
				<nav id="acount-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="/index">HOME</a></li>
						
						
						
							<li>
								<form action="/logout" method="post">
									<input type="hidden" name="" value="" />
									<input type="submit" value="로그아웃" style="border:none;background: none;vertical-align: middle;font-size: 10px;color:#979797;font-weight: bold;" />
									
								</form>								
							</li>
						

						

						<li><a href="/member/agree">회원가입</a></li>
					</ul>
				</nav>

				<nav id="member-menu" class="linear-layout">
					<h1 class="hidden">고객메뉴</h1>
					<ul class="linear-layout">
						<li><a href="../../index.jsp"><img
								src="../../../images/txt-mypage.png" alt="마이페이지" /></a></li>
						<li><a href="/customer/notice"><img
								src="../../../images/txt-customer.png" alt="고객센터" /></a></li>
					</ul>
				</nav>

			</div>
		</section>

	</div>
	<div class="search-button">
		<img src="../../../images/ic_search_black_24dp_1x.png" />
	</div>
	<div class="more-vert-button">
		<img src="../../../images/ic_more_vert_black_24dp_1x.png" />
	</div>
</header>