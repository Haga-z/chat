<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h1 class="text-center">Чаты:</h1>

    <#list chats as chat>
        <a href="/chat/${chat.chat.id}">
            <div class="col text-center border mt-4 mb-4 p-3">
        <h1>${chat.chat.getName()}</h1>
        <h2>${chat.user.getUsername()}</h2>
            </div>
        </a>
    </#list>


</@main.renderWith>