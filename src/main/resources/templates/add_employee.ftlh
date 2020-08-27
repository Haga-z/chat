<#import "partials/main.ftlh" as main />

<@main.renderWith title="Регистрация сотрудника">
    <h3 class="mb-3" style="text-align: center">Регистрация юзера </h3>
<div class="d-flex justify-content-center">
<div class="mx-3">
<form action="/add_employee" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'CSRF-TOKEN'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <div>
            <label class="flex-v-center">
                <p class="label-input-text">Username:</p>
                <input class="form-control mb-2"type="text" name="username" required>
            </label>
        </div>
        <div>
            <label class="flex-v-center">
                <p class="label-input-text">Пароль:</p>
                <input class="form-control mb-2" type="password" name="password" placeholder="********" required>
            </label>
        </div>
        <div>
            <button class="btn btn-outline-primary  btn-block " type="submit">Зарегистирировать</button>
        </div>
    </form>
</div>
</div>
</@main.renderWith>
