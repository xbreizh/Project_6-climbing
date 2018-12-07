<%@ taglib prefix="s" uri="/struts-tags" %>

<table   style="border:none">
    <tr>

        <th>
            <s:a href="#Spots" rel="Spots">
                <button onclick="toggle_display('menu-spot-result')"
                        type="button" class="btn btn-info">
                    (<s:property value="%{spotList.size()}"/>) Spots</button>
            </s:a>
        </th>
        <th>
            <s:a href="#Topos" rel="Topos">
                <button onclick="toggle_display('menu-topo-result')"
                        type="button" class="btn btn-info">
                    <%--(<s:property value="%{spotList.size()}"/>)--%>Topos</button>
            </s:a>
        </th>

    </tr>
</table>