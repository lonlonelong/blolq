<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/8/9
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>here</title>
</head>
    <script src="/js/angular.min.js"></script>
<body>
<div>

    <p>hello,here</p>
</div>

<div ng-app="">
    <p>名字 : <input type="text" ng-model="name"></p>
    <h1>Hello {{name}}</h1>
</div>

</body>
</html>
