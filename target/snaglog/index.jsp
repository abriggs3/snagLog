<!DOCTYPE html>
<%@include file="tagLibrary.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="SnagLog Home" scope="session" />
<c:import url="page_sections/head/head_index.jsp" />
<c:import url="http://fonts.googleapis.com/css?family=Roboto" />
<body>

    <c:import url="page_sections/topNavBar/topNavBar_standard.jsp" />

<div class="container-fluid text-center">
    <div class="row content">

        <c:import url="page_sections/sidebar_left/sidebar_left_standard.jsp"/>
        <c:import url="page_sections/body/body_index.jsp" />
        <c:import url="page_sections/sidebar_right/sidebar_right_standard.jsp" />

    </div>
</div>

    <c:import url="page_sections/footer/footer_standard.jsp" />

</body>
</html>
