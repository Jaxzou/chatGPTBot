package com.jax.ai.domain.openAi.model.vo;

import lombok.Data;

/**
 * @author jax
 * @description 选择
 */
@Data
public class Choices {

    private String text;

    private int index;

    private String logprobs;

    private String finish_reason;
}
