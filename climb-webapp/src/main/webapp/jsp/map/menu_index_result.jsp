<%@ taglib prefix="s" uri="/struts-tags" %>

<table   style="border:none">
    <tr>

        <th>
            <s:a href="#Spots" rel="Spots">
                <button onclick="toggle_display('menu-spot-result')"
                        type="button" class="btn btn-info">
                    Spots</button>
            </s:a>
        </th>
        <th>
            <s:a href="#Topos" rel="Topos">
                <button onclick="toggle_display('menu-topo-result')"
                        type="button" class="btn btn-info">Topos</button>
            </s:a>
        </th>
        <th>
            <s:a href="#Routes" rel="Routes">
                <button onclick="toggle_display('menu-routes-result')"
                        type="button" class="btn btn-info">Routes</button>
            </s:a>
        </th>
    </tr>
</table>