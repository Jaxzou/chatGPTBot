package com.jax.ai.domain.zsxq;


import com.jax.ai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @author jax
 * @description 知识星球 API 接口
 */
public interface IZsxqApi {

    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws Exception;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws Exception;

}