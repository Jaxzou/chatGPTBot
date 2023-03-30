package com.jax.ai.domain.zsxq.model.req;

import lombok.Data;

/**
 * @author jax
 * @description 请求问答接口信息
 */
@Data
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }
}
