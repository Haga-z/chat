<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h1 class="text-center">Чаты:</h1>

    <#list chats as chat>
        <a class="link-chat" href="/chat/${chat.chat.id}">
            <div class="col text-center border mt-4 mb-4 p-3">
        <h1>${chat.chat.getName()}</h1>
            </div>
        </a>
    </#list>


</@main.renderWith>