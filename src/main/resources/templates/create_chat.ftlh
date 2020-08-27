<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <div class="justify-content-center">
        <form method="post" action="/create_chat">
            <select name="user_id">
                <#list users as user>
                    <option name="user_id" value="${user.id}">${user.username}</option>
                </#list>
            </select>
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <input type="text" name="chat_name" required>
            <button class="btn btn-outline-dark" type="submit">Создать</button>
        </form>
    </div>

</@main.renderWith>