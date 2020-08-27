'use strict';
preloadMessages();

function preloadMessages() {
    setInterval(preloadWindow, 500);
}

async function getMessage() {
    let chat_id = document.getElementById("chat_id").value;
    let url = "/messages/" + chat_id;
    const response = await fetch(url);
    if (response.ok) {
        let json = await response.json();
        return json;
    } else {
       console.error()
    }
}

class Message {
    constructor(user, message,time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }
}

async function preloadWindow() {
    let messages = await getMessage();
    if (messages != null) {
        let newMessage = new Message(messages.user.username, messages.text, messages.created_at);
        let elem = createMessage(newMessage);
        elem.classList.add("text-right")
        document.getElementById("chat-body").appendChild(elem);
    }
}

function createMessage(newMessage) {
    let message_content = `
                        <h5 class="text-danger">Отправитель: ${newMessage.user}</h5>
                        <p class="text-primary">Сообщение:<strong> ${newMessage.message}</strong></p> 
                        <p class="text-muted">Дата: ${newMessage.time}</p>          
                        `
    let element = document.createElement(`div`);
        element.classList.add("message-box")
        element.innerHTML += message_content;
        return element;

}

function pushMessage(form) {
    let data = new FormData(form);
    let chat_id = data.get("chat_id").toString();
    let today = new Date();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let message = new Message(data.get("user_name").toString(), data.get("message").toString(),time)
    fetch("/chat/" + chat_id, {
        method: "POST",
        body: data
    }).catch(console.error);
    let elem = createMessage(message);
    document.getElementById("chat-body").appendChild(elem);
    document.getElementById("message").value="";

}