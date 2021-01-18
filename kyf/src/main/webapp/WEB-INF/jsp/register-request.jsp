<%--
  Created by IntelliJ IDEA.
  User: Horizontal13
  Date: 17/01/2021
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>KYF</title>


    <style>
      .error{

          color: red;
      }


    </style>
</head>
<body>
<h1>Konullu Yardim Fondunun Qeydiyyat Sistemi</h1>
<form:form modelAttribute="form" action="register-request" method="post">

    Ad:<form:input path="name"/></br>
    <span><form:errors  path="name" cssClass="error" </span></br>

    Soyad:<form:input path="surname" /></br>
    <span><form:errors path="surname" cssClass="error" </span></br>

    Region:<form:select path="region" items="${regionMap}"/></br>
    <span><form:errors path="region" cssClass="error"</span></br>

    Telefon:<form:input path="phone" /></br>
    <span><form:errors path="phone" cssClass="error"</span></br>

    Status:<form:radiobuttons path="status" items="${statusMap}"/></br>
    <span><form:errors path="status" cssClass="error"</span></br>



    Unvan:<form:textarea path="address"/></br>
    Ehtiyaclar:<form:textarea path="needs"/></br>
    Qeyd:<form:textarea path="note"/></br>
    Vasiteci:<form:input path="contactPerson"/></br>
    <input type="submit" value="Qeydiyyata Al!"/>





</form:form>

</body>
</html>
