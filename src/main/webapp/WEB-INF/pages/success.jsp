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
    <style type="text/css">
        header, main, footer {
            padding-left: 240px;
        }

        @media only screen and (max-width : 992px) {
            header, main, footer {
                padding-left: 0;
            }
        }
    </style>

</head>
 <script src="/js/angular.min.js"></script>
 <script src="/js/angular.min.js"></script>
 <script src="/js/angular.min.js"></script>
<body>
<div>

    <p>hello,here</p>
</div>

<div ng-app="">
    <p>名字 : <input type="text" ng-model="name"></p>
    <h1>Hello {{name}}</h1>
</div>

<nav>
    <ul class="right hide-on-med-and-down">
        <li><a href="#!">First Sidebar Link</a></li>
        <li><a href="#!">Second Sidebar Link</a></li>
    </ul>
    <ul id="slide-out" class="side-nav">
        <li><a href="#!">First Sidebar Link</a></li>
        <li><a href="#!">Second Sidebar Link</a></li>
    </ul>
    <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
</nav>

</body>
<script style="text/javascript">
    $('.button-collapse').sideNav({
                menuWidth: 300, // Default is 240
                edge: 'right', // Choose the horizontal origin

        // Initialize collapsible (uncomment the line below if you use the dropdown variation)
        //$('.collapsible').collapsible();
                closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
            }
    );

    // Show sideNav
    $('.button-collapse').sideNav('show');
    // Hide sideNav
    $('.button-collapse').sideNav('hide');


</script>

</html>
