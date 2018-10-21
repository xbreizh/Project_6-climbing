<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
</head>
<body>
<div class="container">
You are now connected
<p>
    <a href="javascript: init()"><button>Close</button></a>

</p>

</div>

<script type="text/javascript">
    function init() {
        opener.location.reload();
        this.close();
        //close();
    }
</script>

    </body>
</html>
