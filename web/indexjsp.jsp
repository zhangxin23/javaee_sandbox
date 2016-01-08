<%--
  Created by IntelliJ IDEA.
  User: zhangxin
  Date: 16/1/8
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<body>
Time: <span id="foo"></span>

<br><br>
<button onclick="start()">Start</button>

<script type="text/javascript">
  function start() {

    var eventSource = new EventSource("sse-servlet");

    eventSource.onmessage = function(event) {

      document.getElementById('foo').innerHTML = event.data;

    };

  }
</script>
</body>
</html>
