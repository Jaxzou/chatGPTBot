package com.jax.ai.domain.openAi;


/**
 * @author jax
 * @description ChatGPT open ai 接口：https://platform.openai.com/account/api-keys
 */
public interface IOpenAI {

    String doChatGPT(String openAiKey, String question) throws Exception;

}
