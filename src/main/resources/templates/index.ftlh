<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <#if user??>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="index-header">Добро пожаловать ${user.getUsername()}</h1>
                <p class="index-content"></p>
            </div>
        </div>
    <#else>
    <p>Войдите в систему!</p>
    </#if>
    <form class="flex box-128" action="/logout" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <button class="btn btn-outline-light ">Выйти</button>
    </form>


</@main.renderWith>