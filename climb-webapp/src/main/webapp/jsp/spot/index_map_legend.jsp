<style>
    fieldset{
        position:absolute;
        bottom:47px;left:40px;
        background-color:#ffede3;
        padding-left: 30px;
        padding-right: 10px;
        border-radius:10px;
        width:120px;
    }
    .legend{
        position:relative;
        margin-left:15px;
        margin-right:15px;
        margin-top:5px;
        font-size: 12px;
        text-align: justify-all;
        padding:auto;
    }

    img{
        height:30px; width:30px;
    }

</style>

<form>
    <fieldset>
        <table class="legend">
            <tr>
                <th colspan="2">Legend:</th>
            </tr>
            <tr>
                <td><img height="30" width="30" alt="green_pin" src="<%=request.getContextPath()%>/img/green_pin.PNG"></td>
                <td>Boulder</td>
            </tr>
            <tr>
                <td><img height="42" width="42" alt="red_pin" src="<%=request.getContextPath()%>/img/red_pin.PNG"></td>
                <td>Rope</td>
            </tr>

        </table>
    </fieldset>
</form>