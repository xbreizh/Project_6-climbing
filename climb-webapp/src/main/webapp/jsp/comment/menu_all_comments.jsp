<%@ taglib prefix="s" uri="/struts-tags" %>

<table   style="display: block; border:none">
    <tr>

        <th>
            <s:a href="#Spot-Comment" rel="Spot-Comment">
                <button onclick="toggle_display('menu-spot-comments')"
                        type="button" class="btn btn-info">
                    Comments Spot (<s:property value="%{commentListSpot.size()}"/>)</button>
            </s:a>
        </th>
        <th>
            <s:a href="#Route-Comment" rel="Route-Comment">
                <button onclick="toggle_display('menu-route-comments')"
                        type="button" class="btn btn-info">
                    Comments Route (<s:property value="%{commentListRoute.size()}"/>)</button>
            </s:a>
        </th>

    </tr>
</table>
<script >
    $('a').on('click', function(){
        var target = $(this).attr('rel');
        $("#"+target).show().siblings("div").hide();
    });
</script>