package com.jax.ai.domain.zsxq.model.aggregates;


import com.jax.ai.domain.zsxq.model.res.RespData;
import lombok.Data;

/**
 * @author jax
 * @description 未回答问题的聚合信息
 */
@Data
public class UnAnsweredQuestionsAggregates {

    private boolean succeeded;
    private RespData resp_data;
}
