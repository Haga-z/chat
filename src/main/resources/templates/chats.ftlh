<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h1>HELLO</h1>
    <#if chats??>
        <h1>FILL</h1>
        <#else >
            <h1>EMPTY</h1>
    </#if>
    <#list chats as chat>
        <h1>${chat.chat.getName()}</h1>
        <h2>${chat.user.getUsername()}</h2>
        <h1>--------------------------------</h1>
    </#list>
</@main.renderWith>