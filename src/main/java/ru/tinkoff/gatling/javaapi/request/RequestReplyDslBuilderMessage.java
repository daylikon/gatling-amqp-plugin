package ru.tinkoff.gatling.javaapi.request;

import java.nio.charset.Charset;
import java.util.ArrayList;

import static io.gatling.javaapi.core.internal.Expressions.*;

public class RequestReplyDslBuilderMessage {
    private ru.tinkoff.gatling.amqp.request.RequestReplyDslBuilderMessage wrapped;

    public RequestReplyDslBuilderMessage(ru.tinkoff.gatling.amqp.request.RequestReplyDslBuilderMessage wrapped){
        this.wrapped = wrapped;
    }

    public RequestReplyDslBuilderMessage replyExchange(String name){
        this.wrapped = wrapped.replyExchange(toStringExpression(name));
        return this;
    }

    public RequestReplyDslBuilderMessage noReplyTo(){
        this.wrapped = wrapped.noReplyTo();
        return this;
    }

    public RequestReplyDslBuilder textMessage(String text){
        return textMessage(text, io.gatling.core.Predef.configuration().core().charset());
    }

    public RequestReplyDslBuilder textMessage(String text, Charset charset){
        return new RequestReplyDslBuilder(wrapped.textMessage(toStringExpression(text), charset));
    }

    public RequestReplyDslBuilder bytesMessage(ArrayList<Byte> bytes){
        return new RequestReplyDslBuilder(wrapped.bytesMessage(toBytesExpression(bytes.toString())));
    }
}
