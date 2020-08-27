<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <div class="justify-content-center">
        <div class="chat-body border p-4" id="chat-body">
            <h4 class="text-center">${chat.name}</h4>
            <#list messages as message>
                <#if message.user.username==user.username>
                    <div class="message-box">
                        <h5 class="text-danger">Отправитель:${message.user.username}</h5>
                        <p class="text-primary">Сообщение: <strong> ${message.text}</strong></p>
                        <p class="text-muted">Дата: ${message.created_at}</p>
                    </div>
                    <#else >
                        <div class="message-box text-right">
                            <h5 class="text-danger">Отправитель:${message.user.username}</h5>
                            <p class="text-primary">Сообщение: <strong> ${message.text}</strong></p>
                            <p class="text-muted">Дата: ${message.created_at}</p>
                        </div>
                    </#if>
            </#list>
        </div>

        <form id="message-form" name="message-form" class="mt-5" enctype="form-data" >
            <div>
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <input type="hidden" name="chat_id" id="chat_id" value="${chat.id}">
                <input type="hidden" name="user_name" id="user-name" value="${user.username}">
                <textarea name="message" id="message" cols="100" rows="5" maxlength="500" required></textarea>
                <button type="button" id="push-message" class="btn btn-outline-dark mb-4" onclick="pushMessage(this.form)">Отправить</button>
            </div>
        </form>
    </div>
</@main.renderWith>