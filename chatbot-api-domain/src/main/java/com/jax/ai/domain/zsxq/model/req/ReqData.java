package com.jax.ai.domain.zsxq.model.req;

import lombok.Data;

/**
 * @author jax
 * @description 请求对象
 */
@Data
public class ReqData {

    private String text;
    private String[] image_ids = new String[]{};
    private boolean silenced;

    public ReqData(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }
}
