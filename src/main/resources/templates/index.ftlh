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


</@main.renderWith>