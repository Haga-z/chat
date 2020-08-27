<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <div class="row justify-content-center mt-3">
        <form method="post" action="/create_chat">
            <h4 class="text-center">Пользователь</h4>
            <select class="form-control" name="user_id">
                <#list users as user>
                    <option name="user_id" value="${user.id}">${user.username}</option>
                </#list>
            </select>
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <h4 class="text-center mt-2">Название чата</h4>
            <input class="form-control " type="text" name="chat_name" required>
            <button class="btn btn-outline-dark mt-3" type="submit">Создать</button>
        </form>
    </div>

</@main.renderWith>